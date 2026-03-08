![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)

# 🌸 Jardim Encantado API

O Jardim Encantado é uma escola de ensino fundamental dedicada ao desenvolvimento das crianças de forma leve, acolhedora e cheia de descobertas. A proposta da escola valoriza o aprendizado em contato com a natureza, incentivando a curiosidade, a imaginação e o respeito pelo mundo ao nosso redor.

Esta API foi desenvolvida para auxiliar na organização da escola, permitindo o gerenciamento de salas, turmas, professores e a visualização dos responsáveis, contribuindo para que o ambiente educacional funcione de forma organizada e harmoniosa.

<br>

## 🪻 Funcionalidades

A API permite o gerenciamento das principais estruturas da escola:

- Cadastro e consulta de professores
- Organização das turmas (visualização dos alunos e criação de grade horária)
- Visualização para os responsáveis (boletins e ocorrências)
- Visualização para os professores (cadastro de notas e ocorrências)

<br>
  
## 🌻 Tecnologias

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- MapStruct
- Lombok
- Swagger / OpenAPI
- Maven

<br>

## 🌷 Arquitetura

Na API, utilizamos a seguinte arquitetura:

- Controller → Requisições Http
- Service → Lógica de negócio
- Repository → Acesso ao banco de dados
- DTOs → Objetos de tranferência
- Mappers → Conversões entre entidade e DTO

<br>

## 🌼 Estrutura do projeto

```
src
 ├── controller
 ├── service
 ├── repository
 ├── model
 │    ├── dto
 │    └── entity
 └── mapper
```

<br>

 ## 🌹 Banco de Dados

A aplicação utiliza **PostgreSQL** para armazenamento dos dados.

A configuração do banco pode ser feita no arquivo:

src/main/resources/application.properties

As entidades principais são as seguintes:

- Person
- Student
- Teacher
- Guardian
- Gradind
- SchollEvent
- Admin

<br>

 ## 🏵️ Como iniciar o projeto:

1. Clone o repositório
   <br>
`git clone https://github.com/your-username/api-jardim-encantado.git`

2. Entre na pasta do projeto
   <br>
`cd api-jardim-encantado`

3. Rode o projeto
   <br>
`./mvnw spring-boot:run`

<br>
 
## 💮 Documentação da API

A documentação da API foi feita na plataforma Swagger UI

Depois de iniciar o projeto, acesse:

http://localhost:8080/swagger-ui.html

<br>

## 🪷 Exemplo de Endpoint

As requisições da API seguem o padrão:

/api/v1/{nome-da-entidade}

Exemplos:

GET /api/v1/teachers  
GET /api/v1/students  
POST /api/v1/classroom-groups

<br>

## 💐 Autores

Desenvolvido com muito carinho pelos Devs do Jardim Encantado 🩷
