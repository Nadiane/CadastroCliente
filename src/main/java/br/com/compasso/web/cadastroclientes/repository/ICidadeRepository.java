package br.com.compasso.web.cadastroclientes.repository;

import br.com.compasso.web.cadastroclientes.domain.Cidade;
import br.com.compasso.web.cadastroclientes.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICidadeRepository extends JpaRepository<Cidade, Long> {

    Cidade cadastrarCidade(Cidade cidade);

    Cidade consultarPorNome(String nome);

    Cidade consultarPorEstado(Estado estado);
}
