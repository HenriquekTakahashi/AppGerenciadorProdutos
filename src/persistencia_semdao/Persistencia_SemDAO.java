/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package persistencia_semdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author PTOLEDO
 */
public class Persistencia_SemDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        Scanner input = new Scanner(System.in);
        Produto p = new Produto();
        
       
        System.out.print("Descricao: ");
        String descricao = input.nextLine();
        String upDescricao = descricao.toUpperCase();
        
        System.out.print("Preco: R$ ");
        double preco = input.nextDouble();
        
        try {
            p.setDescricao(upDescricao);
            p.setPreco(preco);
            p.cadastrar();
            System.out.println("Cadastrado com sucesso.");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        */

        
        /*
        System.out.print("Qual o id do produto a se deletar: ");
        int id = input.nextInt();
        
        try{
            p.setId(id);
            p.deletar();
            System.out.println("Deletado com sucesso.");
        }
        catch(SQLException | ClassNotFoundException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        */
        
        /*
        System.out.print("Id: ");
        int id = input.nextInt();
        
        input.nextLine();
        
        System.out.print("Descricao a atualizar: ");
        String descricao = input.nextLine();
        String upDescricao = descricao.toUpperCase();
        
        System.out.print("Preco: R$ ");
        double preco = input.nextDouble();
        
        try {
            p.setId(id);
            p.setDescricao(upDescricao);
            p.setPreco(preco);
            p.atualizar();
            System.out.println("Atualizado com sucesso.");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        */
 
        /* 
        System.out.print("Id do produto a consultar: ");
        int id = input.nextInt();

        try {
            p.setId(id);
            p = p.consultarById();
            if (p.getDescricao() != null) {
                System.out.println("ID.........: " + p.getId());
                System.out.println("Descricao..: " + p.getDescricao());
                System.out.println("Preco......: " + p.getPreco());
            } else {
                System.out.println("ID nao encontrado.");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        */


        
        /*
        try {
            List<Produto> lprod = p.consultarTodos();
            for (Produto prod : lprod) {
                System.out.println("ID.........: " + prod.getId());
                System.out.println("Descricao..: " + prod.getDescricao());
                System.out.println("Preco......: " + prod.getPreco());
                System.out.println("-----------------------------------");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        */
    }

}
