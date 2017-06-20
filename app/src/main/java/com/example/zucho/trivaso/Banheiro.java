package com.example.zucho.trivaso;

/**
 * Created by zucho on 19/06/2017.
 */

public class Banheiro {
    int id_banheiro;
    String nome;
    String descricao;
    double media;
    float lat;
    float lon;
    int id_statusbanheiros;

    public Banheiro() {
    }

    public Banheiro(int id_banheiro, String nome, String descricao, double media, float lat, float lon, int id_statusbanheiros) {
        this.id_banheiro = id_banheiro;
        this.nome = nome;
        this.descricao = descricao;
        this.media = media;
        this.lat = lat;
        this.lon = lon;
        this.id_statusbanheiros = id_statusbanheiros;
    }

    public int getId_banheiro() {
        return id_banheiro;
    }

    public void setId_banheiro(int id_banheiro) {
        this.id_banheiro = id_banheiro;
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

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public int getId_statusbanheiros() {
        return id_statusbanheiros;
    }

    public void setId_statusbanheiros(int id_statusbanheiros) {
        this.id_statusbanheiros = id_statusbanheiros;
    }
}
