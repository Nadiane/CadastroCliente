package br.com.compasso.web.cadastroclientes.controller;

import br.com.compasso.web.cadastroclientes.domain.Cidade;
import br.com.compasso.web.cadastroclientes.domain.Cliente;
import br.com.compasso.web.cadastroclientes.error.CustomizacaoTipoErro;
import br.com.compasso.web.cadastroclientes.error.RecursoNaoEncontrado;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public ResponseEntity<?> salvarCliente(@Valid @RequestBody Cliente cliente) {
        Cliente clienteCadastrado = clienteRepository.findById(cliente.getId());
        if (clienteCadastrado != null)
            return new ResponseEntity<>(new CustomizacaoTipoErro("Cliente já cadastrado."), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(clienteRepository.saveAndFlush(cliente), HttpStatus.CREATED);
    }

    @GetMapping("/cliente/id/{id}")
    @ApiOperation(value = "Consulta Cliente por Id")
    public ResponseEntity<?> listarClientePorId(@PathVariable(value = "id") @Min(1) long id) {
        Cliente cliente = clienteRepository.findById(id);
        if (cliente == null)
            throw new RecursoNaoEncontrado("Cliente não encontrado para ID: " + id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/cliente/nome/{nome}")
    @ApiOperation(value = "Consulta Cliente por Nome")
    public ResponseEntity<?> listarClientePorNome(@PathVariable(value = "nome") String nome) {
        List<Cliente> clientes = clienteRepository.findByNomeIgnoreCaseContaining(nome);
        if (clientes.isEmpty())
            throw new RecursoNaoEncontrado("Cliente não encontrado para ID: " + nome);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @DeleteMapping("/cliente/remover")
    @ApiOperation(value = "Remove Cliente")
    public ResponseEntity<?> removerCliente(@RequestBody Cliente cliente) {
        clienteRepository.delete(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/cliente/alterar")
    @ApiOperation(value = "Altera Nome Cliente")
    public ResponseEntity<?> alterarNomeCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private boolean isDataValida(String data) {
        try {
            SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
            formatoData.setLenient(false);
            formatoData.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private String converterDateParaStringData() {
        Date dataAtual = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = dateFormat.format(dataAtual);
        return dataFormatada;
    }

}
