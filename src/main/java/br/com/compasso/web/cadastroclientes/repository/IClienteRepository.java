package br.com.compasso.web.cadastroclientes.repository;

import br.com.compasso.web.cadastroclientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    public List<Cliente> findByNomeIgnoreCaseContaining(String nome);

    public Cliente findById(long id);

}
