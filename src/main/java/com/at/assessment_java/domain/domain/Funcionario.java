package com.at.assessment_java.domain.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "TB_FUNCIONARIO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private Date nascimento;
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    @PersistenceContext
    private Departamento departamento;
}
