package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.ApiResponse;
import com.example.demo.model.User;
import com.example.demo.service.AuthenticationService;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private AuthenticationService authService;

    private List<User> userList;

    @BeforeEach
    void setUp() {
        userList = new ArrayList<>();
        userController = new UserController(authService);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCadastrarUsuario() {
     
        // Preparando dados do usuário para o teste
        User user = new User();
        user.setUsuario("usuario");
        user.setSenha("senha123");
        user.setNomeCompleto("Nome Completo");

        // Simulando autenticação válida
        String validAuthorizationHeader = "Basic " + Base64.getEncoder().encodeToString("e2etreinamentos:e2e@123".getBytes());
        when(authService.isAuthenticated("", "")).thenReturn(true);

        // Executando o método a ser testado
        ResponseEntity<ApiResponse> responseEntity = userController.cadastrarUsuario(user, validAuthorizationHeader);
        assertEquals("Usuário cadastrado com sucesso!", responseEntity.getBody().getMessage());
    }

    
    @Test
    void testCadastrarUsuarioSemUsuario() {
     
        // Preparando dados do usuário para o teste
        User user = new User();
        user.setUsuario("");
        user.setSenha("senha123");
        user.setNomeCompleto("Nome Completo");

        // Simulando autenticação válida
        String validAuthorizationHeader = "Basic " + Base64.getEncoder().encodeToString("e2etreinamentos:e2e@123".getBytes());
        when(authService.isAuthenticated("", "")).thenReturn(true);

        // Executando o método a ser testado
        ResponseEntity<ApiResponse> responseEntity = userController.cadastrarUsuario(user, validAuthorizationHeader);
        assertEquals("O nome de usuário é obrigatório.", responseEntity.getBody().getMessage());
    }
    
   
}
