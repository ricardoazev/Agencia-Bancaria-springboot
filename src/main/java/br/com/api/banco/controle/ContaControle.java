package br.com.api.banco.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.banco.servico.ContaService;

@RestController
@CrossOrigin(origins = "*")
public class ContaControle {
    
    @Autowired
    private ContaService contaService;

    @PostMapping("/contas/{pessoa_id}/depositar")
    public ResponseEntity<String> depositar(@PathVariable Long pessoa_id, @RequestBody Double valor) {
       contaService.depositar(pessoa_id, valor);
       return new ResponseEntity<>("Depósito realizado com sucesso!", HttpStatus.OK);
    }

    @PostMapping("/contas/{pessoa_id}/sacar")
    public ResponseEntity<String> sacar(@PathVariable long pessoa_id, @RequestBody Double valor) {
       contaService.sacar(pessoa_id, valor); 
       return new ResponseEntity<>("Saque realizado com sucesso!", HttpStatus.OK);
    }

    @PutMapping("/contas/{contaOrigemId}/transferir/{contaDestinoId}")
    public ResponseEntity<String> transferir(@PathVariable Long contaOrigemId, @PathVariable Long contaDestinoId, @RequestBody Double valor) {
        contaService.transferir(contaOrigemId, contaDestinoId, valor);
        return new ResponseEntity<>("Transferência realizada com sucesso!", HttpStatus.OK);
    }


}
