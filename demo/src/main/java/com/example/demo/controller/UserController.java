package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.User;
import com.example.demo.service.AuthenticationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/users")
@Api(tags = "Usuários", description = "Operações relacionadas a usuários")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

	// Injetando o serviço de autenticação
	@Autowired
	private AuthenticationService authService;
	private List<User> userList = new ArrayList<>();

	@Autowired
	public UserController(AuthenticationService authService) {
		this.authService = authService;
	}

	// Construtor padrão (sem parâmetros)
	public UserController() {
		this.userList = new ArrayList<>();
	}

	// Construtor adicional com a lista de usuários como parâmetro
	public UserController(List<User> userList) {
		this.userList = userList;
	}
	
	

	@ApiOperation("Cadastrar um novo usuário")
	@PostMapping
	public ResponseEntity<ApiResponse> cadastrarUsuario(@RequestBody User user,
			@RequestHeader(value = "Authorization", required = false) String authorizationHeader) {

		// Verifica se o cabeçalho de autorização está presente
		if (authorizationHeader == null || authorizationHeader.isEmpty()) {
			ApiResponse errorResponse = new ApiResponse("Acesso não autorizado.");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
		}

	/*	if (user == null || user.getUsuario() == null || user.getUsuario().trim().isEmpty()) {
			ApiResponse errorResponse = new ApiResponse("O nome de usuário é obrigatório.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}

		if (user.getSenha() == null || user.getSenha().trim().isEmpty()) {
			ApiResponse errorResponse = new ApiResponse("A senha é obrigatória.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}

		if (user.getNomeCompleto() == null || user.getNomeCompleto().trim().isEmpty()) {
			ApiResponse errorResponse = new ApiResponse("O nome completo é obrigatório.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}

		String usuario = user.getUsuario().trim();
		int usuarioLength = usuario.length();
		if (usuarioLength < 4 || usuarioLength > 20) {
			ApiResponse errorResponse = new ApiResponse("O nome de usuário deve ter entre 5 e 20 caracteres.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}

		if (!user.getUsuario().matches("^[a-zA-Z]+$")) {
			ApiResponse errorResponse = new ApiResponse("O nome de usuário só pode conter letras.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}*/

		for (User existingUser : userList) {
			if (existingUser.getUsuario().equals(user.getUsuario())) {
				ApiResponse errorResponse = new ApiResponse("Nome de usuário já existe.");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
			}
		}

		userList.add(user);

		ApiResponse response = new ApiResponse("Usuário cadastrado com sucesso!");

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@ApiOperation("Obter a lista de usuários")
	@GetMapping
	public ResponseEntity<?> getUsers() {
		if (userList.isEmpty()) {
			ApiResponse response = new ApiResponse("Lista de usuários está vazia.");
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.ok(userList);
		}
	}

	@ApiOperation("Deletar todos os usuários")
	@DeleteMapping
	public ResponseEntity<ApiResponse> deletarUsuarios() {
		if (userList.isEmpty()) {
			ApiResponse response = new ApiResponse("Lista de usuários já está vazia.");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}

		userList.clear();

		ApiResponse response = new ApiResponse("Todos os usuários foram deletados sem sucesso!");
		return ResponseEntity.ok(response);
	}

	private boolean isAuthenticated(String authorizationHeader) {
		// Extrai as credenciais do cabeçalho de autorização (Basic Authentication)
		String base64Credentials = authorizationHeader.substring("Basic".length()).trim();
		byte[] decoded = Base64.getDecoder().decode(base64Credentials);
		String credentials = new String(decoded);

		// Separa o usuário e a senha das credenciais
		String[] values = credentials.split(":", 2);
		String username = values[0];
		String password = values[1];

		// Verifica a autenticação utilizando o serviço de autenticação
		return authService.isAuthenticated(username, password);
	}

}
