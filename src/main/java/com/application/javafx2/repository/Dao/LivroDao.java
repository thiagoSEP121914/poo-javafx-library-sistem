package com.application.javafx2.repository.Dao;

import com.application.javafx2.model.entity.Livro;

import java.util.List;

public interface LivroDao {
    List<Livro> findAll();
    List<Livro> findById();
    int insert (Livro obj);

    int update(Livro obj);
}
