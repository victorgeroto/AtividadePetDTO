package com.projetodtoH2.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pet")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotNull
	private String documento;
	
	@NotNull
	@NotBlank
	private String nascimento;
	

	private String cuidador;

	public Pet(String nome, String documento, String nascimento) {
		super();
		this.nome = nome;
		this.documento = documento;
		this.nascimento = nascimento;
	}
	
	
}
	
