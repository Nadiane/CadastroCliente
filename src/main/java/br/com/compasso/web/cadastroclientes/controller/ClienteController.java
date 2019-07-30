package br.com.compasso.web.cadastroclientes.controller;

import br.com.compasso.web.cadastroclientes.domain.Cidade;
import br.com.compasso.web.cadastroclientes.domain.Cliente;
import br.com.compasso.web.cadastroclientes.repository.ICidadeRepository;
import br.com.compasso.web.cadastroclientes.repository.IClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Clientes")
@CrossOrigin(origins = "*")
@Validated
public class ClienteController {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ICidadeRepository cidadeRepository;

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Salva um Cliente")
    public Cliente salvarCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @GetMapping("/cliente/id/{id}")
    @ApiOperation(value = "Consulta Cliente por Id")
    public Cliente listarClientePorId(@PathVariable (value = "id") @Min(1) long id){
        return clienteRepository.findById(id);
    }

    @GetMapping("/cliente/nome/{nome}")
    @ApiOperation(value = "Consulta Cliente por Nome")
    public List<Cliente> listarClientePorNome(@PathVariable (value = "nome") String nome){
        return clienteRepository.findByNome(nome);
    }

    @DeleteMapping("/cliente/remover")
    @ApiOperation(value = "Remove Cliente")
    public void removerCliente(@RequestBody Cliente cliente){
        clienteRepository.delete(cliente);
    }

    @PutMapping("/cliente/alterar")
    @ApiOperation(value = "Altera Nome Cliente")
    public Cliente alterarNomeCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

}
