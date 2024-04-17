package br.com.api.banco.controle;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.api.banco.modelo.PessoaModelo;
import br.com.api.banco.servico.PessoaServico;

@RestController 
@CrossOrigin(origins = "*")
public class PessoaControle {

    @Autowired
    private PessoaServico pessoaServico;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody PessoaModelo pessoaModelo) {
        return pessoaServico.cadastrar(pessoaModelo);
    }

    @GetMapping("/listar")
    public Iterable<PessoaModelo> listar() {
        return pessoaServico.listar();
    }

    @GetMapping("/")
    public String rota(){
        return "API de PESSOAS FUNCIONANDO! Minha filha é uma princesa!";
    }


}
