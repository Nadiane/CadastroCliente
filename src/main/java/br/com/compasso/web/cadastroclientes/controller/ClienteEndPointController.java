package br.com.compasso.web.cadastroclientes.controller;

import br.com.compasso.web.cadastroclientes.domain.Cidade;
import br.com.compasso.web.cadastroclientes.domain.Cliente;
import br.com.compasso.web.cadastroclientes.error.CustomizacaoTipoErro;
import br.com.compasso.web.cadastroclientes.repository.ICidadeRepository;
import br.com.compasso.web.cadastroclientes.repository.IClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Clientes")
@CrossOrigin(origins = "*")
@Validated
public class ClienteEndPointController {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ICidadeRepository cidadeRepository;

    @PostMapping("/cliente")
    @ApiOperation(value = "Salva um Cliente")
    public ResponseEntity<?> salvarCliente(@RequestBody Cliente cliente){
        Cliente clienteCadastrado = clienteRepository.findById(cliente.getId());
        if(clienteCadastrado != null){
            return new ResponseEntity<>(new CustomizacaoTipoErro("Cliente já cadastrado."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clienteRepository.saveAndFlush(cliente), HttpStatus.CREATED);
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
