package com.generation.brecho.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome do produto é obrigatório!")
	@Size(min = 3, max = 255, message = "Nome deve ter entre 3 e 255 caracteres")
	@Column(nullable = false, length = 255)
	private String nome;
	
	@NotBlank(message = "Tamanho do produto é obrigatório!")
	@Size(min = 1, max = 10, message = "Tamanho deve ter entre 1 e 10 caracteres")
	@Column(nullable = false, length = 10)
	private String tamanho;
	
	@NotNull(message = "Preço é obrigatório!")
	@DecimalMin(value = "0.01", message = "Preço deve ser maior do que zero")
	@Digits(integer = 10, fraction = 2, message = "Preço deve ter no máximo 10 digitos inteiros e 2 decimais")
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal preco;
	
	@Size(max = 500, message = "O link da foto deve ter no máximo 500 caracteres")
	@Column(length = 500)
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
