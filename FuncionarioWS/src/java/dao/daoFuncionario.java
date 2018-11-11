/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.mdlFuncionario;

/**
 *
 * @author Almir
 */
public class daoFuncionario {
    
    public daoFuncionario()
    {
    
    }
    
    public boolean incluirFuncionario(mdlFuncionario funcionario)
    {
        Boolean retorno = false;
        
        /*Verificando se o funcionario já existe*/
        String sql = "SELECT * FROM funcionarios where Cpf=?";
        PreparedStatement pst = daoConexao.getPreparedStatement(sql);
        try {
            pst.setString(1, funcionario.getCpf());
            ResultSet res = pst.executeQuery();
            
            /*Se já existe, atualiza*/
            if(res.next())
            {
                String sqlUp = "UPDATE funcionarios set DataCad=?,Cargo=?,Nome=?,UfNasc=?,Salario=?,Status=? where Cpf=?";
                PreparedStatement pstUp = daoConexao.getPreparedStatement(sqlUp);

                pstUp.setString(1, funcionario.getDataCad());
                pstUp.setString(2, funcionario.getCargo());
                pstUp.setString(3, funcionario.getCpf());
                pstUp.setString(4, funcionario.getNome());
                pstUp.setString(5, funcionario.getUfNasc());
                pstUp.setFloat(6, funcionario.getSalario());
                pstUp.setString(7, funcionario.getStatus());
                if(pstUp.executeUpdate()>0)
                {
                    retorno = true;
                }
            }
            else  /*Se não existe, inclui*/
            {            
                String sqlIn = "INSERT INTO funcionarios (DataCad, Cargo, Cpf, Nome, UfNasc, Salario, Status) VALUES(?,?,?,?,?,?,?)";
                PreparedStatement pstIn = daoConexao.getPreparedStatement(sqlIn);

                pstIn.setString(1, funcionario.getDataCad());
                pstIn.setString(2, funcionario.getCargo());
                pstIn.setString(3, funcionario.getCpf());
                pstIn.setString(4, funcionario.getNome());
                pstIn.setString(5, funcionario.getUfNasc());
                pstIn.setFloat(6, funcionario.getSalario());
                pstIn.setString(7, funcionario.getStatus());

                if(pstIn.executeUpdate()>0)
                {
                    retorno = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(daoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;    
    }
    
    public boolean excluirFuncionario(mdlFuncionario funcionario)
    {
        String sql = "DELETE FROM funcionarios where Cpf=?";
        Boolean retorno = false;
        PreparedStatement pst = daoConexao.getPreparedStatement(sql);
        try {

            pst.setString(1, funcionario.getCpf());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                            
        } catch (SQLException ex) {
            Logger.getLogger(daoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    }
    
    public List<mdlFuncionario> buscarFuncNome(mdlFuncionario funcionario)
    {
        List<mdlFuncionario> funcionarios = new ArrayList<>();
        
        String sql = "SELECT * FROM funcionarios where Nome Like %?%";        
        PreparedStatement pst = daoConexao.getPreparedStatement(sql);       

        try {
            pst.setString(1, funcionario.getNome());
            ResultSet res = pst.executeQuery();
             
            while (res.next()) {
                
                mdlFuncionario f = new mdlFuncionario();
                
                f.setDataCad(res.getString("DataCad"));
                f.setCargo(res.getString("Cargo"));
                f.setCpf(res.getString("Cpf"));
                f.setNome(res.getString("Nome"));
                f.setUfNasc(res.getString("UfNasc"));
                f.setSalario(res.getFloat("Salario"));
                f.setStatus(res.getString("Status"));

                funcionarios.add(f);                
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(daoFuncionario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return funcionarios;    
    }

    public mdlFuncionario buscarFuncCPF(mdlFuncionario funcionario)
    {
        String sql = "SELECT * FROM funcionarios where Cpf=?";
        mdlFuncionario retorno = null;
        
        PreparedStatement pst = daoConexao.getPreparedStatement(sql);
        try {
           
            pst.setString(1, funcionario.getCpf());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
                retorno = new mdlFuncionario();
                retorno.setDataCad(res.getString("DataCad"));
                retorno.setCargo(res.getString("Cargo"));
                retorno.setCpf(res.getString("Cpf"));
                retorno.setNome(res.getString("Nome"));
                retorno.setUfNasc(res.getString("UfNasc"));
                retorno.setSalario(res.getFloat("Salario"));
                retorno.setStatus(res.getString("Status"));                                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(daoFuncionario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return retorno;    
    }

    public List<mdlFuncionario> buscarFuncCargo(mdlFuncionario funcionario)
    {
        List<mdlFuncionario> funcionarios = new ArrayList<>();
        
        String sql = "SELECT * FROM funcionarios where Cargo=?";        
        PreparedStatement pst = daoConexao.getPreparedStatement(sql);       

        try {
            pst.setString(1, funcionario.getCargo());
            ResultSet res = pst.executeQuery();
             
            while (res.next()) {
                
                mdlFuncionario f = new mdlFuncionario();
                
                f.setDataCad(res.getString("DataCad"));
                f.setCargo(res.getString("Cargo"));
                f.setCpf(res.getString("Cpf"));
                f.setNome(res.getString("Nome"));
                f.setUfNasc(res.getString("UfNasc"));
                f.setSalario(res.getFloat("Salario"));
                f.setStatus(res.getString("Status"));

                funcionarios.add(f);                
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(daoFuncionario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return funcionarios;    
    }

    public List<mdlFuncionario> buscarFuncDataCad(mdlFuncionario funcionario)
    {
        List<mdlFuncionario> funcionarios = new ArrayList<>();
        
        String sql = "SELECT * FROM funcionarios where DataCad=?";        
        PreparedStatement pst = daoConexao.getPreparedStatement(sql);       

        try {
            pst.setString(1, funcionario.getDataCad());
            ResultSet res = pst.executeQuery();
             
            while (res.next()) {
                
                mdlFuncionario f = new mdlFuncionario();
                
                f.setDataCad(res.getString("DataCad"));
                f.setCargo(res.getString("Cargo"));
                f.setCpf(res.getString("Cpf"));
                f.setNome(res.getString("Nome"));
                f.setUfNasc(res.getString("UfNasc"));
                f.setSalario(res.getFloat("Salario"));
                f.setStatus(res.getString("Status"));

                funcionarios.add(f);                
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(daoFuncionario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return funcionarios;    
    }

    public List<mdlFuncionario> buscarFuncStatus(mdlFuncionario funcionario)
    {
        List<mdlFuncionario> funcionarios = new ArrayList<>();
        
        String sql = "SELECT * FROM funcionarios where Status=?";        
        PreparedStatement pst = daoConexao.getPreparedStatement(sql);       

        try {
            pst.setString(1, funcionario.getStatus());
            ResultSet res = pst.executeQuery();
             
            while (res.next()) {
                
                mdlFuncionario f = new mdlFuncionario();
                
                f.setDataCad(res.getString("DataCad"));
                f.setCargo(res.getString("Cargo"));
                f.setCpf(res.getString("Cpf"));
                f.setNome(res.getString("Nome"));
                f.setUfNasc(res.getString("UfNasc"));
                f.setSalario(res.getFloat("Salario"));
                f.setStatus(res.getString("Status"));

                funcionarios.add(f);                
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(daoFuncionario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return funcionarios;    
    }

}