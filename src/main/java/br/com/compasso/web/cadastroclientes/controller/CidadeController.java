package br.com.compasso.web.cadastroclientes.controller;


import br.com.compasso.web.cadastroclientes.domain.Cidade;
import br.com.compasso.web.cadastroclientes.repository.ICidadeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Cadastro Cidades")
@CrossOrigin(origins = "*")
@Validated
public class CidadeController {

    @Autowired
    ICidadeRepository cidadeRepository;

    @PostMapping("/cidade")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Salva uma Cidade")
    public Cidade salvarCidade(@Valid @RequestBody Cidade cidade){
       return cidadeRepository.save(cidade);
    }

    @GetMapping("/cidade/nome/{nome}")
    @ApiOperation(value = "Consulta Cidade por Nome")
    public Cidade consultarCidadePorNome(@PathVariable(value = "nome") @Min(3) @Size String nome){
        return cidadeRepository.findByNome(nome);
    }

    @GetMapping("/cidade/estado/nome/{estado}")
    @ApiOperation(value = "Consulta Cidade por Estado")
    public List<Cidade> consultarCidadePorEstado(@PathVariable(value = "estado") @Size String estado){
        return cidadeRepository.findByEstado(estado);
    }

}
