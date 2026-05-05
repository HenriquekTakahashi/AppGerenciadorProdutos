# AppGerenciadorProdutos

Aplicação Java para gerenciamento de produtos.  
Distribuída como um arquivo `.jar`, utiliza um banco de dados MySQL com a tabela `produtos`.

## Execução
1. Certifique-se de ter o Java instalado (versão 17 ou superior).
2. No terminal, execute:
     java -jar AppGerenciadorProdutos.jar

## Requisitos do banco de dados
### Banco de Dados

A aplicação conecta-se a um banco MySQL.  
Crie a tabela `produtos` com a seguinte estrutura:

```sql
CREATE DATABASE gerenciador_produto;
USE gerenciador_produto;
CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    preco DOUBLE NOT NULL
);
```
Certifique-se da porta do servidor ser 3307, usuário root e sem senha.
