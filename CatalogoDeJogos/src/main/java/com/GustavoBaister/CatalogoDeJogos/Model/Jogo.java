package com.GustavoBaister.CatalogoDeJogos.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table (name = "jogos")
public class Jogo {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String titulo;

    @Column(nullable = false)
    private String desenvolvedora;

    @Column
    private Integer anoLancamento;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private boolean ativo;

    public Long getId(){return id;}

    public String getTitulo(){ return titulo; }

    public Integer getAnoLancamento(){ return anoLancamento; }

    public Double getPreco(){ return preco;}

    public boolean isAtivo(){ return ativo; }


}
