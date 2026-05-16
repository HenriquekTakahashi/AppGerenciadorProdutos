/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;
import util.Conexao;

/**
 *
 * @author SYSTEM
 */
public class ProdutoDAO {
    public void cadastrar(Produto prod) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into produtos(descricao, preco, qntestoque, categoria) values(?,?,?,?)");
        comando.setString(1, prod.getDescricao());
        comando.setDouble(2, prod.getPreco());
        comando.setInt(3, prod.getQntEstoque());
        comando.setString(4, prod.getCategoria());
        comando.execute();
        con.close();
    }

    public boolean deletar(Produto prod) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from produtos where id=?");
        comando.setInt(1, prod.getId());
        int linhasAfetadas = comando.executeUpdate();
        con.close();
        return linhasAfetadas > 0; // > 0 deletou, se não, não achou 
    }

    public boolean atualizar(Produto prod) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update produtos set descricao = ?, preco = ?, qntestoque = ?, categoria = ? where id = ?");
        comando.setString(1, prod.getDescricao());
        comando.setDouble(2, prod.getPreco());
        comando.setInt(3, prod.getQntEstoque());
        comando.setString(4, prod.getCategoria());
        comando.setInt(5, prod.getId());
        int linhasAfetadas = comando.executeUpdate();
        con.close();
        return linhasAfetadas > 0; // > 0 atualizou, se não, não achou 
    }

    public Produto consultarById(Produto prod) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConexao();
        String SQL = "select * from produtos where id = ?";
        PreparedStatement comando = con.prepareStatement(SQL);
        comando.setInt(1, prod.getId());
        ResultSet resultado = comando.executeQuery();

        if (resultado.next()) {
            prod.setId(resultado.getInt("id"));
            prod.setDescricao(resultado.getString("descricao"));
            prod.setPreco(resultado.getDouble("preco"));
            prod.setQntEstoque(resultado.getInt("qntestoque"));
            prod.setCategoria(resultado.getString("categoria"));
            
            return prod;
        } else {
            con.close();
            return prod = null;
        }
        
    }
    
 
    public List<Produto> consultarTodos() throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConexao();
        String SQL = "select id as codigo, descricao as descri, preco, qntestoque as estoque, categoria from produtos";
        PreparedStatement comando = con.prepareStatement(SQL);
        ResultSet resultado = comando.executeQuery();
        List<Produto> listaprodutos = new ArrayList<Produto>();
        while (resultado.next()) {
            Produto prod = new Produto();
            prod.setId(resultado.getInt("codigo"));
            prod.setDescricao(resultado.getString("descri"));
            prod.setPreco(resultado.getDouble("preco"));
            prod.setQntEstoque(resultado.getInt("estoque"));
            prod.setCategoria(resultado.getString("categoria"));
            listaprodutos.add(prod);
        }
        con.close();
        return listaprodutos;
    }
}
