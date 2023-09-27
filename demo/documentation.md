# Documentação Técnica

## Visão Geral
Esta documentação descreve a API para gerenciamento de usuários.

## Recursos

### Cadastrar um novo usuário
Endpoint: POST /api/users
Descrição: Permite cadastrar um novo usuário no sistema.

Regras de Negócio:
- O nome de usuário é obrigatório.
- O nome completo é obrigatório.
- O nome de usuário deve ter entre 5 e 20 caracteres.
- O nome de usuário só pode conter letras.
- Não é permitido cadastrar um nome de usuário que já exista no sistema.

### Obter a lista de usuários
Endpoint: GET /api/users
Descrição: Retorna a lista de usuários cadastrados no sistema.

### Deletar todos os usuários
Endpoint: DELETE /api/users
Descrição: Deleta todos os usuários cadastrados no sistema.

Regras de Negócio:
- A lista de usuários não pode estar vazia para realizar a exclusão.

## Modelos

### User
Representa um usuário no sistema.

Propriedades:
- usuario (string): O nome de usuário.

### ApiResponse
Representa a resposta da API.

Propriedades:
- message (string): A mensagem da resposta.
  
### Usuário e senha para autenticar api
USERNAME = "e2etreinamentos";
PASSWORD = "e2e@123";
