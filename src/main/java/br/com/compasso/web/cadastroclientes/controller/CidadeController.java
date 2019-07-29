package br.com.compasso.web.cadastroclientes.controller;


import br.com.compasso.web.cadastroclientes.domain.Cidade;
import br.com.compasso.web.cadastroclientes.domain.Estado;
import br.com.compasso.web.cadastroclientes.repository.ICidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class CidadeController {

    @Autowired
    private ICidadeRepository cidadeRepository;

    @PostMapping("/cidade")
    public Cidade salvarCidade(@RequestBody Cidade cidade){
       return cidadeRepository.save(cidade);
    }

    @GetMapping("/cidade/{nome}")
    public Cidade consultarCidadePorNome(@PathVariable(value = "nome") String nome){
        return cidadeRepository.consultarPorNome(nome);
    }

    @GetMapping("/cidade/{estado}")
    public Cidade consultarCidadePorEstado(@PathVariable(value = "estado") Estado estado){
        return cidadeRepository.consultarPorEstado(estado);
    }

}
