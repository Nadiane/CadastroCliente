package br.com.compasso.web.cadastroclientes.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

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

    @Size(max = 200, message = "Por favor, informe um nome com o máximo 200 caracteres.")
    @NotBlank(message = "Por favor, informe o nome do Cliente.")
    @Column(nullable = false, length = 200)
    private String nome;

    @NotBlank(message = "Por favor, informe o sexo(Masculino, Feminino).")
    @Size(max = 10, message = "Campo Sexo possui limite de 10 caracteres.")
    @Column(nullable = false, length = 10)
    private String sexo;

    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @Column(nullable = false, length = 3)
    private Integer idade;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "id_cidade_fk")
    private Cidade cidade;

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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
