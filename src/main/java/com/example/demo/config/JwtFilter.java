package com.example.demo.config;

import com.example.demo.service.JwtService;
import com.example.demo.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// Filtro executado em toda requisição para validar o token JWT.
// OncePerRequestFilter garante que ele é executado apenas uma vez por requisição.
@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    public JwtFilter(JwtService jwtService, UserDetailsServiceImpl userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Pega o header Authorization da requisição.
        String authHeader = request.getHeader("Authorization");

        // Se não tiver token ou não começar com "Bearer ", deixa a requisição passar.
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // Extrai o token removendo o prefixo "Bearer ".
        String token = authHeader.substring(7);

        // Extrai o email do usuário a partir do token.
        String email = jwtService.extrairEmail(token);

        // Se o email foi extraído e o usuário ainda não está autenticado no contexto.
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // Busca o usuário no banco pelo email.
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            // Valida se o token é válido para esse usuário.
            if (jwtService.tokenValido(token, userDetails)) {

                // Cria o objeto de autenticação e registra no contexto do Spring Security.
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // Passa a requisição para o próximo filtro da cadeia.
        filterChain.doFilter(request, response);
    }
}