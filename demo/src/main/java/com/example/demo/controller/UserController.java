package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {

	private List<User> userList = new ArrayList<>();

	@ApiOperation("Cadastrar um novo usuário")
	@PostMapping
	public ResponseEntity<ApiResponse> cadastrarUsuario(@RequestBody User user) {
		if (user == null || user.getUsuario() == null || user.getUsuario().trim().isEmpty()) {
			ApiResponse errorResponse = new ApiResponse("O nome de usuário é obrigatório.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}

		String usuario = user.getUsuario().trim();
		int usuarioLength = usuario.length();
		if (usuarioLength < 4 || usuarioLength > 20) {
			ApiResponse errorResponse = new ApiResponse("O nome de usuário deve ter entre 5 e 20 caracteres.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}

	/*	if (!user.getUsuario().matches("^[a-zA-Z]+$")) {
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

		ApiResponse response = new ApiResponse("Todos os usuários foram deletados com sucesso!");
		return ResponseEntity.ok(response);
	}

}
