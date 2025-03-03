package com.application.javafx2.model.service;

import com.application.javafx2.model.entity.Livro;
import com.application.javafx2.repository.Dao.LivroDao;

import java.util.List;

public class LivroService {

    LivroDao repository;
    // criar a DB.Factory no MainController ??
    public LivroService(LivroDao livroDao) {
        repository = livroDao;
    }

    public List<Livro> findAll () {
        return repository.findAll();
    }

    public int insert(Livro obj) {
       return repository.insert(obj);
    }

    public int update (Livro obj) {
        return repository.update(obj);
    }

}
