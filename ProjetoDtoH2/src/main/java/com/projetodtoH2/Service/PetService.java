package com.projetodtoH2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodtoH2.DTO.PetDTO;
import com.projetodtoH2.entities.Pet;
import com.projetodtoH2.Repository.PetRepository;

@Service
public class PetService {
	private final PetRepository petRepository;
	
	@Autowired
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	public PetDTO salvar(PetDTO petDTO) {
		Pet pet = new Pet(petDTO.nome(), petDTO.documento(), petDTO.nascimento());
		Pet salvarPet = petRepository.save(pet);
		return new PetDTO(salvarPet.getId(), salvarPet.getNome(), salvarPet.getDocumento(), salvarPet.getNascimento());
	}
	public PetDTO atualizar(Long id, PetDTO petDTO) {
		Pet existePet = petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet não encontrado") );

		existePet.setNome(petDTO.nome());
		existePet.setDocumento(petDTO.documento());
		existePet.setNascimento(petDTO.nascimento());
	

		Pet updatePet = petRepository.save(existePet);
		return new PetDTO(updatePet.getId(), updatePet.getNome(), updatePet.getDocumento(), updatePet.getNascimento());
	}

	public boolean delete(Long id) {
		Optional <Pet> existePet = petRepository.findById(id);
		if (existePet.isPresent()) {
			petRepository.deleteById(id);
			return true;
		}
		return false;
	}
	public List<Pet> buscarTodos(){
		return petRepository.findAll();
	}
	public Pet buscarPorId(Long id) {
		Optional <Pet> usuario = petRepository.findById(id);
		return usuario.orElse(null);
	}

}


