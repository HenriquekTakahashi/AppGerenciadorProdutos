 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia_semdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author PTOLEDO
 */
public class Produto {

    private int id;
    private String descricao;
    private double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void cadastrar() throws SQLException, ClassNotFoundException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("insert into produtos(descricao, preco) values(?,?)");
        comando.setString(1, descricao);
        comando.setDouble(2, preco);
        comando.execute();
        con.close();
    }

    public boolean deletar() throws SQLException, ClassNotFoundException {
        Connection con = getConexao();
        Produto p = new Produto();
        PreparedStatement comando = con.prepareStatement("delete from produtos where id=?");
        comando.setInt(1, id);
        int linhasAfetadas = comando.executeUpdate();
        con.close();
        return linhasAfetadas > 0; // > 0 deletou, se não, não achou 
    }

    public boolean atualizar() throws SQLException, ClassNotFoundException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("update produtos set descricao = ?, preco = ? where id = ?");
        comando.setString(1, descricao);
        comando.setDouble(2, preco);
        comando.setInt(3, id);
        int linhasAfetadas = comando.executeUpdate();
        con.close();
        return linhasAfetadas > 0; // > 0 atualizou, se não, não achou 
    }

    public Produto consultarById() throws SQLException, ClassNotFoundException {
        Connection con = getConexao();
        String SQL = "select * from produtos where id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setInt(1, id);
        ResultSet resultado = comando.executeQuery();
        Produto prod = new Produto();

        if (resultado.next()) {
            prod.setId(resultado.getInt("id"));
            prod.setDescricao(resultado.getString("descricao"));
            prod.setPreco(resultado.getDouble("preco"));
        }
        con.close();
        return prod;

    }
    
 
    public List<Produto> consultarTodos() throws SQLException, ClassNotFoundException {
        Connection con = getConexao();
        String SQL = "select id as codigo, descricao as descri, preco from produtos";
        PreparedStatement comando = con.prepareStatement(SQL);
        ResultSet resultado = comando.executeQuery();
        List<Produto> listaprodutos = new ArrayList<Produto>();
        while (resultado.next()) {
            Produto prod = new Produto();
            prod.setId(resultado.getInt("codigo"));
            prod.setDescricao(resultado.getString("descri"));
            prod.setPreco(resultado.getDouble("preco"));
            listaprodutos.add(prod);
        }
        con.close();
        return listaprodutos;
    }

    public Connection getConexao() {
        try {
            // O método forName carrega e inicia o driver passado por parâmetro
            Class.forName("com.mysql.cj.jdbc.Driver"); //verificar em seu computador
            // Estabelecendo a conexão
            return DriverManager.getConnection("jdbc:mysql://localhost:3307/aula_ioo", "root", "");
        } catch (ClassNotFoundException | SQLException ex) { // Tratamento de Exceções
            System.out.println(ex);
            return null;
        }
    }

}
