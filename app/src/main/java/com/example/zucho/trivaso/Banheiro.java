package com.example.zucho.trivaso;

/**
 * Created by zucho on 17/06/2017.
 */

public class Banheiro {

    int id_banheiro;
    String nome;
    String descricao;
    double media;
    float lat;
    float lon;
    int id_statusbanheiro;

    public Banheiro(int id, String s, int i){

    }

    public Banheiro() {
        this.id_banheiro = id_banheiro;
        this.nome = nome;
        this.descricao = descricao;
        this.media = media;
        this.lat = lat;
        this.lon = lon;
        this.id_statusbanheiro = id_statusbanheiro;
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

    public int getId_statusbanheiro() {
        return id_statusbanheiro;
    }

    public void setId_statusbanheiro(int id_statusbanheiro) {
        this.id_statusbanheiro = id_statusbanheiro;
    }
}
