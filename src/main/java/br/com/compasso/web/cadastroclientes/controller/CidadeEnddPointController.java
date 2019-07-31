package br.com.compasso.web.cadastroclientes.controller;


import br.com.compasso.web.cadastroclientes.domain.Cidade;
import br.com.compasso.web.cadastroclientes.error.CustomizacaoTipoErro;
import br.com.compasso.web.cadastroclientes.repository.ICidadeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class CidadeEnddPointController {

    @Autowired
    ICidadeRepository cidadeRepository;

    @GetMapping("/cidades")
    @ApiOperation(value = "Consulta Cidades")
    public ResponseEntity<?> consultarCidades(){
        return new ResponseEntity<>(cidadeRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/cidade")
    @ApiOperation(value = "Salva uma Cidade")
    public ResponseEntity<?> salvarCidade(@Valid @RequestBody Cidade cidade){
        Cidade cidadeEncontra = cidadeRepository.findByNome(cidade.getNome());
        if(cidadeEncontra != null)
           return new ResponseEntity<>(new CustomizacaoTipoErro("Cidade já cadastrada."), HttpStatus.NOT_FOUND);
        return new ResponseEntity(cidadeRepository.save(cidade), HttpStatus.CREATED);
    }

    @GetMapping("/cidade/nome/{nome}")
    @ApiOperation(value = "Consulta Cidade por Nome")
    public ResponseEntity<?> consultarCidadePorNome(@PathVariable(value = "nome") @Size String nome){
        Cidade cidadeEncontrada = cidadeRepository.findByNome(nome);
        if(cidadeEncontrada == null){
            return new ResponseEntity<>(new CustomizacaoTipoErro("Cidade não encontrada."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cidadeEncontrada, HttpStatus.OK);
    }

    @GetMapping("/cidade/estado/nome/{estado}")
    @ApiOperation(value = "Consulta Cidade por Estado")
    public ResponseEntity<? extends Object> consultarCidadePorEstado(@PathVariable(value = "estado") @Size String estado){
        List<Cidade> cidadesEncontradas = cidadeRepository.findByEstado(estado);
        if(cidadesEncontradas.isEmpty()){
            return new ResponseEntity<>(new CustomizacaoTipoErro("Cidade não encontrada."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cidadesEncontradas, HttpStatus.OK);
    }

}
