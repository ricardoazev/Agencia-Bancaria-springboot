package br.com.api.banco.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contas")
public class Conta {
   
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private PessoaModelo pessoaModelo;
    
    private Double saldo = 0.0;

    
    
    public Conta() {
    }

    public Conta(PessoaModelo pessoaModelo) {
        this.pessoaModelo = pessoaModelo;
    }

    public Long getId() {
        return id;
    }

    public PessoaModelo getPessoaModelo() {
        return pessoaModelo;
    }

    public Double getSaldo() {
        return saldo;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setPessoaModelo(PessoaModelo pessoaModelo) {
        this.pessoaModelo = pessoaModelo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

   
}
