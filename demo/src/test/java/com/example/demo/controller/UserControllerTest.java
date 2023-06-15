package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.User;

public class UserControllerTest {

    private UserController userController;

    @Before
    public void setup() {
        userController = new UserController();
    }

    @Test
    public void testCadastrarUsuario_Success() {
        User user = new User();
        User user1 = new User();
        user.setUsuario("teste");
        user.setUsuario("teste");
        System.out.println(user.getUsuario());

        ResponseEntity<ApiResponse> response = userController.cadastrarUsuario(user);
       
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Usuário com sucesso!", response.getBody().getMessage());
    }

   /* @Test
    public void testCadastrarUsuario_EmptyUsername() {
        User user = new User("");

        ResponseEntity<ApiResponse> response = userController.cadastrarUsuario(user);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("O nome de usuário é obrigatório.", response.getBody().getMessage());
    }

    @Test
    public void testCadastrarUsuario_InvalidUsernameLength() {
        User user = new User("abc");

        ResponseEntity<ApiResponse> response = userController.cadastrarUsuario(user);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("O nome de usuário deve ter entre 5 e 20 caracteres.", response.getBody().getMessage());
    }

    @Test
    public void testCadastrarUsuario_InvalidUsernameCharacters() {
        User user = new User("john_doe123");

        ResponseEntity<ApiResponse> response = userController.cadastrarUsuario(user);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("O nome de usuário só pode conter letras.", response.getBody().getMessage());
    }

    @Test
    public void testCadastrarUsuario_DuplicateUsername() {
        User user1 = new User("john_doe");
        User user2 = new User("john_doe");

        userController.cadastrarUsuario(user1);

        ResponseEntity<ApiResponse> response = userController.cadastrarUsuario(user2);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Nome de usuário já existe.", response.getBody().getMessage());
    }

    @Test
    public void testGetUsers_EmptyList() {
        ResponseEntity<?> response = userController.getUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof ApiResponse);
        assertEquals("Lista de usuários está vazia.", ((ApiResponse) response.getBody()).getMessage());
    }

    @Test
    public void testGetUsers_NonEmptyList() {
        User user1 = new User("john_doe");
        User user2 = new User("jane_smith");

        userController.cadastrarUsuario(user1);
        userController.cadastrarUsuario(user2);

        ResponseEntity<?> response = userController.getUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof List);
        assertEquals(2, ((List<?>) response.getBody()).size());
    }

    @Test
    public void testDeletarUsuarios_EmptyList() {
        ResponseEntity<ApiResponse> response = userController.deletarUsuarios();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Lista de usuários já está vazia.", response.getBody().getMessage());
    }

    @Test
    public void testDeletarUsuarios_NonEmptyList() {
        User user1 = new User("john_doe");
        User user2 = new User("jane_smith");

        userController.cadastrarUsuario(user1);
        userController.cadastrarUsuario(user2);

        ResponseEntity<ApiResponse> response = userController.deletarUsuarios();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Todos os usuários foram deletados com sucesso!", response.getBody().getMessage());
        assertTrue(userController.getUsers().getBody() instanceof ApiResponse);
        assertEquals("Lista de usuários está vazia.", ((ApiResponse) userController.getUsers().getBody()).getMessage());
    }*/
}
