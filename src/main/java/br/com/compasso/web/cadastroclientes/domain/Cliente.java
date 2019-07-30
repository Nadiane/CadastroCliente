package br.com.compasso.web.cadastroclientes.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Size(max = 200)
    @Column(name = "nome_cliente", nullable = false, length = 200)
    private String nomeCliente;

    @NotBlank
    @Size(max = 10)
    @Column(nullable = false, length = 10)
    private String sexo;

    @NotBlank
    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @NotBlank
    @Size(min = 1, max = 3)
    @Column(nullable = false, length = 3)
    private int idade;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidadeMoradia;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Cidade getCidadeMoradia() {
        return cidadeMoradia;
    }

    public void setCidadeMoradia(Cidade cidadeMoradia) {
        this.cidadeMoradia = cidadeMoradia;
    }
}
