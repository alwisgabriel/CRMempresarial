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

# Padrão de Commits

O projeto seguirá o padrão Conventional Commits para organização e rastreabilidade das alterações.

Formato:

```txt
tipo: descrição curta
```

Exemplos:

```txt
feat: adiciona cadastro de empresas
fix: corrige validação de CNPJ
docs: atualiza README do projeto
style: ajusta layout do dashboard
refactor: reorganiza camada de service
test: adiciona testes de autenticação
chore: configura eslint
```

---

# Tipos de Commit

| Tipo | Uso |
|---|---|
| feat | Nova funcionalidade |
| fix | Correção de bugs |
| docs | Documentação |
| style | Ajustes visuais/formatação |
| refactor | Refatoração sem alterar comportamento |
| test | Testes |
| chore | Configurações e tarefas internas |

---

# Fluxo de Desenvolvimento

O fluxo principal do projeto será baseado em branches e Pull Requests.

## Fluxo padrão

```txt
main
  └── feature/nome-feature
```

---

# Processo de Desenvolvimento

1. Criar uma branch a partir da `main`
2. Desenvolver a funcionalidade
3. Realizar commits padronizados
4. Enviar branch para o GitHub
5. Abrir Pull Request
6. Revisar alterações
7. Realizar merge na `main`

---

# Padrão de Branches

Formato:

```txt
feature/nome-feature
fix/nome-correcao
docs/nome-documentacao
refactor/nome-refactor
```

Exemplos:

```txt
feature/cadastro-empresa
feature/integracao-receita-api
fix/validacao-cnpj
docs/readme-inicial
```

---

# Regras Gerais

- Não realizar commits diretamente na `main`
- Commits devem possuir descrição objetiva
- Cada funcionalidade deve possuir sua própria branch
- Pull Requests devem ser utilizados antes do merge
- Evitar commits grandes com múltiplas funcionalidades
- Código deve permanecer organizado e padronizado

---
