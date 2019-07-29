package br.com.compasso.web.cadastroclientes.repository;

import br.com.compasso.web.cadastroclientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente consultarClientePorNome(String nome);

    Cliente consultarClientePorId(long id);

    Cliente alterarNomeCliente(String nome);
}
