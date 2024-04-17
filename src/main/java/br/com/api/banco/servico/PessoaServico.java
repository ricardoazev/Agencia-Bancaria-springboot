package br.com.api.banco.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.banco.modelo.Conta;
import br.com.api.banco.modelo.PessoaModelo;
import br.com.api.banco.modelo.RespostaModelo;
import br.com.api.banco.repositorio.ContaRepositorio;
import br.com.api.banco.repositorio.PessoaRepositorio;

@Service
public class PessoaServico {
    
    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    @Autowired
    private ContaRepositorio contaRepositorio;

    @Autowired
    private RespostaModelo respostaModelo;

    //Método para listar todos as Pessoas
    public Iterable<PessoaModelo> listar() {
        return pessoaRepositorio.findAll();
    }

    // Método para cadastrar Pessoas
    public ResponseEntity<?> cadastrar(PessoaModelo pessoaModelo){

        if(pessoaModelo.getNome().equals("")){
    
            respostaModelo.setMensagem("O Nome da Pessoa é obrigatório!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
    
        } else if(pessoaModelo.getCPF().equals("")){
    
            respostaModelo.setMensagem("O CPF da Pessoa é obrigatório!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST); 
    
        } else if(pessoaModelo.getEmail().equals("")){
        
            respostaModelo.setMensagem("O Seu email é obrigatorio!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST); 
        
        } else if (pessoaModelo.getSenha() == null){
    
            respostaModelo.setMensagem("A criação de Senha é obrigatoria!");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
    
        } else if (pessoaModelo.getConfsenha() == null){
            
            respostaModelo.setMensagem("Confime sua senha !");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        
        
        } else if (!pessoaModelo.getSenha().equals(pessoaModelo.getConfsenha())) {
    
            respostaModelo.setMensagem("A senha e a comfirmação de senha precisa ser iguais! ");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
            
        } else {
            // Salva a pessoa no banco de dados
            PessoaModelo pessoaSalva = pessoaRepositorio.save(pessoaModelo);
            
            // Cria uma conta para a pessoa
            Conta conta = new Conta();
            conta.setPessoaModelo(pessoaSalva);
            // Configurações adicionais da conta, se necessário
            // Salva a conta no banco de dados
            contaRepositorio.save(conta);
    
            return new ResponseEntity<PessoaModelo>(pessoaSalva, HttpStatus.CREATED);
        }
    }
    
}
