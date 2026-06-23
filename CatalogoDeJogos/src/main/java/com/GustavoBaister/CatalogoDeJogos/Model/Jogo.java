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

    public String getDesenvolvedora(){ return desenvolvedora; }

    public Integer getAnoLancamento(){ return anoLancamento; }

    public Double getPreco(){ return preco;}

    public boolean isAtivo(){ return ativo; }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
