Projeto que implementa Circuit Breaker e Fallback utilizando Java, Spring Boot, MongoDB, Redis e Resilience4j.
A padrão Circuit Breaker impede que um serviço continue chamando outro que está falhando, evitando sobrecarga e melhorando a recuperação.
Quando usar? 
- Quando sua aplicação consome APIs externas ou microserviços que podem ficar indisponíveis ou apresentar alta latência.
- Se um serviço falhar repetidamente e não houver um mecanismo de proteção, pode sobrecarregar a aplicação chamadora, levando a falhas em cadeia.
- Se um serviço já está sobrecarregado, um Circuit Breaker pode interromper chamadas desnecessárias até que ele se recupere, reduzindo o consumo de recursos.
- O Circuit Breaker pode ser configurado para permitir algumas falhas antes de abrir o circuito, permitindo uma resposta mais tolerante a falhas intermitentes.
- Quando um serviço cai, o Circuit Breaker pode abrir por um tempo e, depois, permitir algumas requisições de teste para verificar se o serviço voltou ao normal.
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


