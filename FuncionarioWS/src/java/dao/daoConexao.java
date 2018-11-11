/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Almir
 */
public class daoConexao {
    
    /*
    * Informando tipo, local e nome da base de dados
    */    
    private static final String banco = "jdbc:mysql://localhost/testedesenv";
    
    /*
    * Atribuindo o driver utilizado para a conexão com a base de dados
    */
    private static final String driver = "com.mysql.jdbc.Driver";
    
    /*
    * Atribuindo usuario e senha para a conexão a base de dados
    */
    private static final String usuario = "root";
    private static final String senha = "rootadm";  
    
    /*
    * O atributo con representa um objeto que 
    * contém a conexão com o banco de dados em si
    */
    private static Connection con = null;
    
    /*
    * Metodo que retorna uma conexão com o banco de dados
    * @return objeto java.sql.Connection
    */
    public static Connection getConexao(){
        
        // Primeiro é testado se o objeto con não foi inicializado
        if (con == null){
            try {
                // definida a classe do driver a ser usado
                Class.forName(driver);
                // criação da conexão com o BD
                con = 
                DriverManager.getConnection(banco, usuario, senha);
            } catch (ClassNotFoundException ex) {
                System.out.println("Não encontrou o driver");
            } catch (SQLException ex) {
                System.out.println("Erro ao conectar: "+ex.getMessage());
            }
        }
        return con;
    }
    
    /**
     * Método que recebe um comando SQL para ser executado
     * @param sql
     * @return um objeto java.sql.PreparedStatement
     */
    public static PreparedStatement getPreparedStatement(String sql){
        
        // testando se a conexão já foi criada
        if (con == null){
            // criando a conexão
            con = getConexao();
        }
        
        try {
            // retornando um objeto java.sql.PreparedStatement
            return con.prepareStatement(sql);
        } catch (SQLException e){
            System.out.println("Erro de sql: "+e.getMessage());
        }
        return null;
    }
    
}
