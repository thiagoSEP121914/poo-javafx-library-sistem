package com.application.javafx2.model.entity;

import java.io.Serializable;
import java.net.IDN;
import java.util.Objects;

public class Livro implements Serializable {

    private Integer id;
    private String titulo;
    private String anoLancamento;
    private String autor;
    private String genero;
    private String status;

    public Livro () {
    }

    public Livro (Integer id, String titulo, String anoLancamento, String autor, String genero, String status) {
        this.id = id;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.autor = autor;
        this.genero = genero;
        this.status = status;
    }

    public Livro(Integer id, String titulo, String anoLancamento, String autor, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.autor = autor;
        this.genero = genero;
    }

    public Livro (String titulo, String anoLancamento, String autor, String genero) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.autor = autor;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId (int id) { this.id = id;}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return id == livro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anoLancamento='" + anoLancamento + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
