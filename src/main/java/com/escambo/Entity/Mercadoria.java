package com.escambo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="mercadorias")
public class Mercadoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mercadoriaId;

    private String nome;

    private String descricao;

    private String imagemUrl;

    public Long getMercadoriaId() {
        return mercadoriaId;
    }

    public void setMercadoriaId(Long mercadoriaId) {
        this.mercadoriaId = mercadoriaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}
