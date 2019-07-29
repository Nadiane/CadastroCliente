package br.com.compasso.web.cadastroclientes.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_ESTADO")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Column(name = "nome_estado", nullable = false, length = 100)
    private String nomeEstado;

    @NotBlank
    @Size(min = 2, max = 2)
    @Column(nullable = false, length = 2)
    private String uf;

    @OneToMany(mappedBy = "TB_ESTADO", cascade = CascadeType.ALL)
    private List<Cidade> cidades;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return id == estado.id &&
                Objects.equals(nomeEstado, estado.nomeEstado) &&
                Objects.equals(uf, estado.uf) &&
                Objects.equals(cidades, estado.cidades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeEstado, uf, cidades);
    }
}
