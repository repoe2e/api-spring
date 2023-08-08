
// Importe a biblioteca Axios (se ainda não estiver fazendo isso)
import axios from 'axios';

// Defina as credenciais de autenticação
const username = 'e2etreinamentos';
const password = 'e2e@123';

// Codifique as credenciais em Base64
const authHeader = `Basic ${btoa(`${username}:${password}`)}`;

// Faça a chamada à API com o cabeçalho de autorização
axios.post('http://localhost:8080/api/users', {
  // Seus dados de cadastro aqui
}, {
  headers: {
    Authorization: authHeader,
  },
})
  .then(response => {
    // Lida com a resposta da API
  })
  .catch(error => {
    // Lida com os erros, como por exemplo o 401 Unauthorized
  });


// Função para exibir a lista de usuários
function showUsers(users) {
    const userList = document.getElementById('userList');
    userList.innerHTML = '';
    users.forEach(user => {
        const listItem = document.createElement('li');
        listItem.innerText = `Usuário: ${user.usuario}, Nome Completo: ${user.nomeCompleto || '-'}`;
        userList.appendChild(listItem);
    });
}

// Função para enviar o formulário de cadastro
async function cadastrarUsuario(event) {
    event.preventDefault();
    const form = event.target;
    const username = form.username.value;
    const password = form.password.value;
    const fullName = form.fullName.value;

    try {
        const response = await axios.post('http://localhost:8080/api/users', {
            usuario: username,
            senha: password,
            nomeCompleto: fullName,
        });

        alert(response.data.message);
        form.reset();
    } catch (error) {
        alert(error.response.data.message);
    }
}

// Função para buscar a lista de usuários
async function getUsers() {
    try {
        const response = await axios.get('http://localhost:8080/api/users');
        showUsers(response.data);
    } catch (error) {
        alert(error.response.data.message);
    }
}

// Chama a função getUsers para exibir a lista de usuários ao carregar a página
getUsers();

// Adiciona o evento de submit para o formulário de cadastro
const userForm = document.getElementById('userForm');
userForm.addEventListener('submit', cadastrarUsuario);
