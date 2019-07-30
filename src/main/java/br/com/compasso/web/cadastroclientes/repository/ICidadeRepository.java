package br.com.compasso.web.cadastroclientes.repository;

import br.com.compasso.web.cadastroclientes.domain.Cidade;
import br.com.compasso.web.cadastroclientes.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICidadeRepository extends JpaRepository<Cidade, Long> {

    public Cidade findByNomeCidade(String nome);

    public Cidade findByEstado(Estado estado);
}
