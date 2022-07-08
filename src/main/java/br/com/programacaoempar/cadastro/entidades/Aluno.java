package br.com.programacaoempar.cadastro.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Aluno {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String email;
    private LocalDate nascimento;
    private String linkedin;

}
