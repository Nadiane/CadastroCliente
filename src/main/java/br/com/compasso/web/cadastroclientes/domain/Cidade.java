package br.com.compasso.web.cadastroclientes.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_cidade")
public class Cidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(max = 100, message = "Nome possui limite de 100 Caracteres.")
    @NotBlank(message = "Por favor, informe o nome da Cidade.")
    @Column(nullable = false, length = 100, unique = true)
    private String nome;

    @Size(max = 100, message = "Estado possui limite de 100 Caracteres.")
    @NotBlank(message = "Por favor, informe o estado da Cidade.")
    @Column(nullable = false, length = 100)
    private String estado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return id == cidade.id &&
                Objects.equals(nome, cidade.nome) &&
                Objects.equals(estado, cidade.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, estado);
    }
}
