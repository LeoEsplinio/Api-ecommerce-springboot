package br.org.serratec.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.ecommerce.api.ApiViaCep;
import br.org.serratec.ecommerce.entities.Endereco;
import br.org.serratec.ecommerce.exceptions.EntityNotFoundExceptionHandler;
import br.org.serratec.ecommerce.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	ApiViaCepService apiViaCepService;
	
	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}
	
	public Endereco findById(Integer id) {
		return enderecoRepository.findById(id).orElseThrow(
				()-> new EntityNotFoundExceptionHandler("Este endereço não existe. Id: " + id));
	}
	
	public Endereco save(Endereco endereco) {
		ApiViaCep aux = apiViaCepService.consultaCep(endereco.getCep());
		endereco.setRua(aux.getLogradouro());
		endereco.setBairro(aux.getBairro());
		endereco.setCidade(aux.getLocalidade());
		endereco.setUf(aux.getUf());
		return enderecoRepository.save(endereco);
	}
	
	public Endereco update(Integer id, Endereco endereco) {
		Endereco entidade = enderecoRepository.findById(id).orElseThrow(
				()-> new EntityNotFoundExceptionHandler("Este endereço não existe. Id: " + id));;
		entidade.setCep(endereco.getCep());
		entidade.setNumero(endereco.getNumero());
		entidade.setComplemento(endereco.getComplemento());
		
		ApiViaCep aux = apiViaCepService.consultaCep(endereco.getCep());
		entidade.setRua(aux.getLogradouro());
		entidade.setBairro(aux.getBairro());
		entidade.setCidade(aux.getLocalidade());
		entidade.setUf(aux.getUf());
		
		return enderecoRepository.save(entidade);
	}
	
	public Boolean delete(Integer id) {
		if(enderecoRepository.existsById(id)) {
			enderecoRepository.deleteById(id);
			Endereco enderecoDeletado =  enderecoRepository.findById(id).orElse(null);
			
			if(enderecoDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
