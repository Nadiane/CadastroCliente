package br.com.compasso.web.cadastroclientes.controller;

import br.com.compasso.web.cadastroclientes.domain.Cliente;
import br.com.compasso.web.cadastroclientes.repository.ICidadeRepository;
import br.com.compasso.web.cadastroclientes.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;

@RestController
@RequestMapping(value = "/apicliente")
public class ClienteController {

    @Autowired
    private IClienteRepository clienteRepository;

    @PostMapping("/cliente")
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @GetMapping("/cliente/{id}")
    public Cliente listarClientePorId(@PathVariable (value = "id") long id){
        return clienteRepository.consultarClientePorId(id);
    }

    @GetMapping("/cliente/{nome}")
    public Cliente listarClientePorNome(@PathVariable (value = "nome") String nome){
        return clienteRepository.consultarClientePorNome(nome);
    }

    @DeleteMapping("/cliente")
    public void removerCliente(@RequestBody Cliente cliente){
        clienteRepository.delete(cliente);
    }

    @PutMapping("/cliente")
    public Cliente alterarNomeCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

}
