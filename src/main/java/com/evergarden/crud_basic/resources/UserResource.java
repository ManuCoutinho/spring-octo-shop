package com.evergarden.crud_basic.resources;

import com.evergarden.crud_basic.entities.User;
import com.evergarden.crud_basic.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/users")
@Tag(name = "user", description = "user management")
public class UserResource {
	@Autowired
	private UserService service;
	@GetMapping
	@Operation(summary = "Retrieve list of all users", description = "Get all users")
	@ApiResponse(responseCode = "200", description = "Success")
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
//todo: validar body
	@PostMapping()
	public ResponseEntity<User> create(@RequestBody User obj){
		obj =	service.insert(obj);
		//forma correta de responder com hyperlink, respeitando o terceiro nível restfull concepts
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//criar finduser by email para garantir apenas um
		 obj.setPassword("");
		return ResponseEntity.created(uri).body(obj);
	}

@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		//responde 204 no body
		return ResponseEntity.noContent().build();
}

@PutMapping(value = "/{id}")
public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
	obj =	service.update(id, obj);
	return ResponseEntity.ok().body(obj);
}
}
