# Desafio Backend Senha Segura
Este projeto foi feito para estudo e aperfeiçoamento das ferramentas Java, Spring e validação de dados com Regex. A ideia partiu como uma proposta de solução ao Desafio de Secure Password do repositório do Backend Brasil.

## Sobre o desafio
O desafio propõe a construção de uma API web que irá receber uma requisição POST com uma senha, essa senha deve passar por vários critérios de validação de segurança para identificação se a senha informada é "segura", quando a senha atender estes critérios deverá ser retornado apenas um status HTTP 204 (No Content), porém quando a senha não atender estes critérios, deverá ser retornado um status HTTP 400 (Bad Request) e no corpo da resposta, deve conter todos os critérios que não foram atendidos. O desafio com maior detalhes você pode encontrar no repositório do [Backend Brasil](https://github.com/backend-br/desafios/blob/master/secure-password/PROBLEM.md).

### Regras
- Verificar se a senha possui pelo menos 08 caracteres.
- Verificar se a senha contém pelo menos uma letra maiúscula.
- Verificar se a senha contém pelo menos uma letra  minúscula.
- Verificar se a senha contém pelo menos um dígito numérico.
- Verificar se a senha contém pelo menos um caractere especial (e.g, !@#$%).

## Exemplo de Requisição:

### Rota "/validate-password"

- HTTP Status 204 - No Content

![no_content-post](https://res.cloudinary.com/dtu1wwbk6/image/upload/v1698791619/readme%20aleatorio/jog6fsgzitzkpf7wc2tu.png)

- HTTP Status 400 - Bad Request

![bad_request-post](https://res.cloudinary.com/dtu1wwbk6/image/upload/v1698791619/readme%20aleatorio/kvk6gxgdogs7oyupoaxm.png)