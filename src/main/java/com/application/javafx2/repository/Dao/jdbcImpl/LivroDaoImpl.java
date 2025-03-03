package com.application.javafx2.repository.Dao.jdbcImpl;

import com.application.javafx2.model.entity.Livro;
import com.application.javafx2.repository.DB;
import com.application.javafx2.repository.Dao.LivroDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDaoImpl implements LivroDao {

    public  Connection conn;
    public LivroDaoImpl (Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Livro> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM livro;";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Livro> list = new ArrayList<>();

            while (rs.next()) {
                list.add(instanciarLivro(rs));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException("Deu pau" + e.getMessage());
        } finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Livro> findById() {
        return null;
    }

    @Override
    public int insert(Livro obj) {
        PreparedStatement ps;
        String sql = "INSERT INTO livro (titulo, ano_lancamento, autor, genero) VALUES "
                     + "(?, ?, ? ,?);";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getTitulo());
            ps.setString(2,obj.getAnoLancamento());
            ps.setString(3, obj.getAutor());
            ps.setString(4, obj.getGenero());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco" + e.getMessage());
        }
    }

    @Override
    public int update(Livro obj) {
        PreparedStatement ps;
        String sql =  "Update livro "
                     + "SET titulo = ?, ano_lancamento = ?, autor = ?, genero = ? "
                     + "WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getTitulo());
            ps.setString(2,obj.getAnoLancamento());
            ps.setString(3, obj.getAutor());
            ps.setString(4, obj.getGenero());
            ps.setInt(5, obj.getId());
            return ps.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Não foi possivel Editar os dados " + e.getMessage());
        }
    }

    public Livro instanciarLivro(ResultSet rs) throws SQLException {
        Livro livro = new Livro();
        livro.setId(rs.getInt("id"));
        livro.setTitulo(rs.getString("titulo"));
        livro.setAnoLancamento(rs.getString("ano_lancamento"));
        livro.setAutor(rs.getString("autor"));
        livro.setGenero(rs.getString("genero"));
        livro.setStatus(rs.getString("status"));
        return livro;
    }
}
