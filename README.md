# FourD Challenge
Projeto desenvolvido para gercimaneto de cadastro para empresa Oni-Service.

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

* A secret do JWT está exposta no repo no docker compose dev apenas para facilitar os testes na máquina de quem for avaliar.