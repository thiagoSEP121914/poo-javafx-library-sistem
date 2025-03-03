package com.application.javafx2.repository.Dao;

import com.application.javafx2.model.entity.Livro;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main (String[] args) {
        LivroDao factory = DaoFactory.crateLivroDao();
        List<Livro> lista = factory.findAll();
        lista.forEach(System.out::println);
    }
}
