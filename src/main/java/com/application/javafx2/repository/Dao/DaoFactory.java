package com.application.javafx2.repository.Dao;

import com.application.javafx2.repository.DB;
import com.application.javafx2.repository.Dao.jdbcImpl.LivroDaoImpl;

public class DaoFactory {

    public static LivroDao crateLivroDao() {
            return new LivroDaoImpl(DB.getConn());
    }
}
