# FourD Challenge

### Pré-requisitos
O que você precisa instalar para rodar o projeto?

* Docker
* Docker compose
* JDK-17

### Como rodar a aplicação?
Dentro da pasta raiz do projeto:
```
sh docker-compose-dev.sh
```

### Para acessar a documentação do Swagger:
```
http://localhost:8080/swagger-ui.html
```

### Para verificar se aplicação está rodando:
```
http://localhost:8080/healthcheck
```

### Observações

* As variáveis de ambiente estão hardcoded apenas para fins de avaliação e considerando um ambiente de desenvolvimento. Num cenário real, as variáveis seriam setadas num ambiente em cloud numa ferramenta de orquestração de containers como kubernetes ou fargate, por exemplo.
