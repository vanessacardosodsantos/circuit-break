Projeto que implementa Circuit Breaker e Fallback utilizando Java, Spring Boot, MongoDB, Redis e Resilience4j.
Basicamente é um serviço backend focado numa implementação de posts de redes sociais. 

## Tecnologias
- Java 17
- SpringBoot
- Spring Cloud Open Feign
- Docker
- MongoDb
- Redis
- Resilience4j
- Lombok
- Maven
- WireMock

## Instalação

```maven
maven clean install
```

```docker
docker-compose up
docker ps
docker exec -it 2d6a91dd46d8 /bin/bash
use circuit-breaker
mongosh -u "USER DA APLICACAO"
```

```wireMock
 java -jar wiremock-standalone-3.12.0.jar --port 8082
```

Adicionar o arquivo json na pasta mappings para mockar os dados usando o WireMock.


