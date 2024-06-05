package br.org.serratec.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.ecommerce.dtos.ClienteResumidoDto;
import br.org.serratec.ecommerce.entities.Cliente;
import br.org.serratec.ecommerce.exceptions.EntityNotFoundExceptionHandler;
import br.org.serratec.ecommerce.services.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		Cliente cliente = clienteService.findById(id);
		
		if(cliente == null) {
			return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);	
		}else {
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		}
	}
	
	@GetMapping("/cliente-resumido")
	public ResponseEntity<List<ClienteResumidoDto>> findAllClienteResumido() {
		return new ResponseEntity<>(clienteService.findAllClienteResumido(), HttpStatus.OK);
	}
	
	@GetMapping("/cliente-resumido/{id}")
	public ResponseEntity<ClienteResumidoDto> findByIdResumido(@PathVariable Integer id) {
		return new ResponseEntity<>(clienteService.findByIdResumido(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody @Valid Cliente cliente) {
		return new ResponseEntity<>(clienteService.save(cliente), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<Cliente> update(@Valid @PathVariable Integer id,@RequestBody  Cliente cliente) {
		return new ResponseEntity<>(clienteService.update(id,cliente), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Boolean deletado = clienteService.delete(id);
		
		if(deletado)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			throw new EntityNotFoundExceptionHandler("Este cliente não pode ser deletado pois o objeto de Id:" + id + " não existe. (╯°□°）╯︵ ┻━┻");
	}
}
