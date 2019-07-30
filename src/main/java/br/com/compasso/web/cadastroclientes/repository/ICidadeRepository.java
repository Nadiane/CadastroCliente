package br.com.compasso.web.cadastroclientes.repository;

import br.com.compasso.web.cadastroclientes.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICidadeRepository extends JpaRepository<Cidade, Long> {

    public Cidade findByNome(String nome);

    public List<Cidade> findByEstado(String estado);
}
