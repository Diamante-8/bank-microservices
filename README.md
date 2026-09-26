# **Distributed Budget System using CQRS, Quarkus, Kafka, and Kotlin**
____
#### 🇺🇸

This repository contains a microservices architecture implementation designed for budget and financial transaction management. The project implements the CQRS pattern (Command Query Responsibility Segregation), asynchronous event-driven communication using Apache Kafka, and high performance built with Quarkus and Kotlin.

Project Architecture
The system is split into two independent microservices that communicate in a decoupled manner:

_**transaction-service (Write / Commands):**_ Handles incoming financial transaction requests (incomes and expenses), persists data in its dedicated PostgreSQL database, and publishes asynchronous events to Kafka.

**_balance-service (Read / Queries):_** Acts as a Kafka consumer, listening to transaction events in real time, processing balance rules, and maintaining an optimized database for fast queries.

## _Technologies Used_

**_Quarkus & Kotlin:_** Cloud-Native framework optimized for fast boot times and low memory footprint.

**_Apache Kafka:_** Distributed messaging broker for resilient asynchronous communication.

**_PostgreSQL & Flyway:_** Relational database with automated, version-controlled schema migrations.

_**Docker & Docker Compose:**_ Container orchestration for local development environments.

## _How to Run the Project_

Ensure Docker is running on your machine and start the underlying infrastructure (Kafka, Zookeeper, and Databases):


### `docker compose up -d`


Navigate to the transaction-service directory and start the Quarkus application:

### `cd transaction-service ./gradlew quarkusDev`

In a separate terminal, navigate to the balance-service directory and start the application:

### `cd balance-service  ./gradlew quarkusDev`












# **Sistema de Orçamento Distribuído com CQRS, Quarkus, Kafka e Kotlin**
____

#### 🇧🇷 

Este repositório contém a implementação de uma arquitetura de microsserviços voltada para o gerenciamento de orçamento e transações financeiras. O projeto aplica o padrão CQRS (Segregação de Responsabilidade de Consulta e Comando), comunicação assíncrona orientada a eventos com Apache Kafka, e alta performance utilizando Quarkus e Kotlin
Arquitetura do Projeto
O sistema é dividido em dois microsserviços independentes que compartilham informações de forma desacoplada:

**transaction-service (Escrita / Commands):** Responsável por receber novas requisições de transações (receitas e despesas), persistir os dados em seu banco PostgreSQL exclusivo e disparar eventos assíncronos para o Kafka.

**balance-service (Leitura / Queries):** Atua como um consumidor do Kafka, escutando os eventos de transações em tempo real, processando as regras de saldo e mantendo uma base de dados otimizada para consultas rápidas.

## _Tecnologias Utilizadas_

_**Quarkus & Kotlin:**_ Framework Cloud-Native de inicialização instantânea e baixo consumo de memória. 

**_Apache Kafka:_** Barramento de mensagens para mensageria assíncrona e resiliente.

_**PostgreSQL & Flyway:**_ Banco de dados relacional com migrações automatizadas e versionadas.

**_Docker & Docker Compose:_** Orquestração de containers para o ambiente de desenvolvimento local.

## _Como Executar o Projeto_
Certifique-se de ter o Docker rodando na sua máquina e suba a infraestrutura base (Kafka, Zookeeper e Bancos de Dados):

### `docker compose up -d`

Acesse a pasta do transaction-service e inicie a aplicação Quarkus:

### `cd transaction-service /gradlew quarkusDev`


Em outro terminal, acesse a pasta do balance-service e inicie a aplicação:
### `cd balance-service ./gradlew quarkusDev`