package br.com.compasso.web.cadastroclientes.controller;


import br.com.compasso.web.cadastroclientes.domain.Cidade;
import br.com.compasso.web.cadastroclientes.repository.ICidadeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Cadastro Cidades")
@CrossOrigin(origins = "*")
public class CidadeController {

    @Autowired
    ICidadeRepository cidadeRepository;

    @PostMapping("/cidade")
    @ApiOperation(value = "Salva uma Cidade")
    public Cidade salvarCidade(@RequestBody Cidade cidade){
       return cidadeRepository.save(cidade);
    }

    @GetMapping("/cidade/nome/{nome}")
    @ApiOperation(value = "Consulta Cidade por Nome")
    public Cidade consultarCidadePorNome(@PathVariable(value = "nome") String nome){
        return cidadeRepository.findByNome(nome);
    }

    @GetMapping("/cidade/estado/nome/{estado}")
    @ApiOperation(value = "Consulta Cidade por Estado")
    public List<Cidade> consultarCidadePorEstado(@PathVariable(value = "estado") String estado){
        return cidadeRepository.findByEstado(estado);
    }

}
