# CRM Empresarial

Sistema CRM desenvolvido para estudos e prática de arquitetura fullstack.

## Stack

- Java + Spring Boot
- React
- PostgreSQL (Supabase)
- Docker

## Estrutura

```
/senaisales-backend
/senaisales-frontend
```

## Como rodar

### Backend

**1. Configure o banco de dados**

```bash
cp application.properties.example src/main/resources/application.properties
```

**2. Configure as variáveis de ambiente**

Crie o arquivo `.vscode/launch.json` baseado no `launch.json.example` e preencha com a senha do banco. Solicite a senha ao responsável pelo projeto.

**3. Rode**

```bash
cd senaisales-backend
./mvnw spring-boot:run
```

### Frontend

```bash
cd senaisales-frontend
npm install
npm run dev
```

## Arquivos de exemplo

O repositório contém arquivos `.example` que servem de modelo para configuração local:

- `application.properties.example` → copiar para `src/main/resources/application.properties`
- `launch.json.example` → copiar para `.vscode/launch.json`