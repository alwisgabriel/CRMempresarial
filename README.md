# CRM Empresarial - SenaiSales

## Sobre o Projeto

Projeto integrador desenvolvido com foco em arquitetura fullstack utilizando React no frontend e Java Spring Boot no backend.

O sistema tem como objetivo centralizar e organizar o gerenciamento de clientes empresariais, contatos, atendimentos e oportunidades de venda, substituindo o controle manual realizado em planilhas.

---

# Objetivos

- Gerenciar empresas clientes
- Consultar dados de CNPJ automaticamente
- Registrar contatos e atendimentos
- Controlar pipeline de vendas
- Organizar negociações comerciais
- Centralizar histórico de interações

---

# Tecnologias Planejadas

## Frontend

- React
- React Router
- Axios
- Hooks
- Componentização
- CSS

## Backend

- Java
- Spring Boot
- Maven
- JPA / Hibernate
- API REST

## Banco de Dados

- PostgreSQL

## Integrações

- ReceitaWS API (consulta de CNPJ)

---

# Funcionalidades Planejadas

## Autenticação

- Login de usuários
- Controle de permissões
- Perfil Administrador
- Perfil Vendedor

---

## Cadastro de Empresas

- Cadastro manual
- Consulta automática por CNPJ
- Validação de CNPJ duplicado
- Histórico de cadastro

Campos principais:

- CNPJ
- Razão social
- Nome fantasia
- Email
- Telefone
- Endereço
- Cidade
- Estado
- CEP

---

## Gestão de Contatos

Cada empresa poderá possuir múltiplos contatos.

Campos:

- Nome
- Cargo
- Telefone
- Email
- Observações

---

## Histórico de Atendimento

Registro de interações comerciais.

Tipos:

- Ligação
- Reunião
- WhatsApp
- Email
- Visita técnica

---

## Pipeline de Vendas

Etapas:

- Lead
- Primeiro contato
- Proposta enviada
- Negociação
- Fechado ganho
- Fechado perdido

---

## Dashboard

Indicadores planejados:

- Quantidade de clientes
- Oportunidades abertas
- Negócios fechados
- Atendimentos do dia
- Gráfico de status

---

# Regras de Negócio

## RN001
Não permitir empresas duplicadas pelo CNPJ.

## RN002
Apenas administradores podem excluir registros.

## RN003
Toda interação deve ficar salva no histórico.

## RN004
O vendedor só pode visualizar seus próprios clientes.

## RN005
Ao consultar o CNPJ, os dados devem preencher automaticamente o formulário.

---

# Estrutura Planejada do Backend

```txt
src
├── controller
├── service
├── repository
├── entity
├── dto
├── config
└── exception
```

---

# Estrutura Planejada do Frontend

```txt
src
├── pages
├── components
├── services
├── routes
├── hooks
├── context
└── styles
```

---

# Entidades Planejadas

- Usuários
- Empresas
- Contatos
- Atendimentos
- Oportunidades

---

# Relacionamentos

- Empresa possui vários contatos
- Empresa possui vários atendimentos
- Usuário possui vários clientes
- Oportunidade pertence a uma empresa

---

# Fluxo do Sistema

1. Usuário informa o CNPJ
2. Sistema consulta API da Receita Federal
3. Dados da empresa são preenchidos automaticamente
4. Empresa é salva no sistema
5. Contatos e atendimentos podem ser registrados
6. Oportunidades são acompanhadas pelo pipeline

---


