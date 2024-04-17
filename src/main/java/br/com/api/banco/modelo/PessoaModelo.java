package br.com.api.banco.modelo;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoas")
@Component
public class PessoaModelo {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String nome;
	private String cpf;
	private String email;
	private Integer senha;
	private Integer confsenha;

	@OneToMany(mappedBy = "pessoaModelo", cascade = CascadeType.ALL)
    private List<Conta> contas;

	// Construtor padrão sem argumentos
    public PessoaModelo() {
    }

	
	public PessoaModelo(Long id,String nome, String cpf, String email, Integer senha, Integer confsenha) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.confsenha = confsenha;
		this.id = id;
	
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public void setCPF(String cPF) {
		cpf = cPF;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getSenha() {
		return senha;
	}

	public Integer getConfsenha() {
		return confsenha;
	}

	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public String toString() {
		return "\nNome " + this.getNome() +
				"\nCPF " + this.getCPF() +
				"\nEmail " + this.getEmail() ;
	}
}
