package br.com.api.banco.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.banco.modelo.Conta;
import br.com.api.banco.modelo.PessoaModelo;
import br.com.api.banco.repositorio.ContaRepositorio;

@Service
public class ContaService {

    @Autowired
    private ContaRepositorio contaRepositorio;

    @Autowired PessoaModelo pessoaModelo;

    public void depositar(Long id, Double valor) {
        Conta conta = contaRepositorio.findById(id).orElse(null);
        if (conta != null && valor > 0) {
            conta.setSaldo(conta.getSaldo() + valor);
            contaRepositorio.save(conta);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o depósito!");
        }
    }
    
    public void sacar(Long id, Double valor) {
        Conta conta = contaRepositorio.findById(id).orElse(null);
        if (conta != null && valor > 0 && conta.getSaldo() >= valor) {
            conta.setSaldo(conta.getSaldo() - valor);
            contaRepositorio.save(conta);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o saque!");
        }
    }
    
    public void transferir(Long contaOrigemId, Long contaDestinoId, Double valor) {
        Conta contaOrigem = contaRepositorio.findById(contaOrigemId).orElse(null);
        Conta contaDestino = contaRepositorio.findById(contaDestinoId).orElse(null);
        if (contaOrigem != null && contaDestino != null && valor > 0 && contaOrigem.getSaldo() >= valor) {
            contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
            contaRepositorio.save(contaOrigem);
            contaRepositorio.save(contaDestino);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a transferência!");
        }
    }
}
