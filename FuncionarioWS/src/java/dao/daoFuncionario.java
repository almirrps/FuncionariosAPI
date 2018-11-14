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
    
    public boolean inserirFuncionario(mdlFuncionario funcionario)
    {
        String sql = "INSERT INTO funcionarios (DataCad, Cargo, Cpf, Nome, UfNasc, Salario, Status) VALUES (?,?,?,?,?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = daoConexao.getPreparedStatement(sql);
        try 
        {
            pst.setString(1, funcionario.getDataCad());
            pst.setString(2, funcionario.getCargo());
            pst.setString(3, funcionario.getCpf());
            pst.setString(4, funcionario.getNome());
            pst.setString(5, funcionario.getUfNasc());
            pst.setDouble(6, funcionario.getSalario());
            pst.setString(7, funcionario.getStatus());
            
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

    public boolean atualizarFuncionario(mdlFuncionario funcionario)
    {
        String sql = "UPDATE funcionarios SET DataCad=?,Cargo=?,Nome=?,UfNasc=?,Salario=?,Status=? WHERE Cpf=?";
        Boolean retorno = false;
        PreparedStatement pst = daoConexao.getPreparedStatement(sql);
        
        try
        {
            pst.setString(1, funcionario.getDataCad());
            pst.setString(2, funcionario.getCargo());
            pst.setString(3, funcionario.getCpf());
            pst.setString(4, funcionario.getNome());
            pst.setString(5, funcionario.getUfNasc());
            pst.setDouble(6, funcionario.getSalario());
            pst.setString(7, funcionario.getStatus());

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
    
    public boolean excluirFuncionario(mdlFuncionario funcionario)
    {
        String sql = "DELETE FROM funcionarios WHERE Cpf = ?";
        Boolean retorno = false;
        PreparedStatement pst = daoConexao.getPreparedStatement(sql);
        try 
        {
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
        
        String sql = "SELECT * FROM funcionarios WHERE Nome = ?";        
        PreparedStatement pst = daoConexao.getPreparedStatement(sql);       

        try
        {
            pst.setString(1, funcionario.getNome());
            ResultSet res = pst.executeQuery();
             
            while (res.next()) 
            {
                mdlFuncionario f = new mdlFuncionario();
                
                f.setDataCad(res.getString("DataCad"));
                f.setCargo(res.getString("Cargo"));
                f.setCpf(res.getString("Cpf"));
                f.setNome(res.getString("Nome"));
                f.setUfNasc(res.getString("UfNasc"));
                f.setSalario(res.getDouble("Salario"));
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
        String sql = "SELECT * FROM funcionarios WHERE Cpf=?";
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
                retorno.setSalario(res.getDouble("Salario"));
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
        
        String sql = "SELECT * FROM funcionarios WHERE Cargo=?";        
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
                f.setSalario(res.getDouble("Salario"));
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
        
        String sql = "SELECT * FROM funcionarios WHERE DataCad=?";        
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
                f.setSalario(res.getDouble("Salario"));
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
        
        String sql = "SELECT * FROM funcionarios WHERE Status=?";        
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
                f.setSalario(res.getDouble("Salario"));
                f.setStatus(res.getString("Status"));

                funcionarios.add(f);                
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(daoFuncionario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return funcionarios;    
    }

    public List<mdlFuncionario> buscarFuncFaixaSalarial(double salarioIni, double salarioFim) 
    {
        List<mdlFuncionario> funcionarios = new ArrayList<>();
        
        String sql = "SELECT * FROM funcionarios WHERE Salario BETWEEN ? AND ? ";        
        PreparedStatement pst = daoConexao.getPreparedStatement(sql);       

        try {
            pst.setDouble(1, salarioIni);
            pst.setDouble(2, salarioFim);
            ResultSet res = pst.executeQuery();
             
            while (res.next()) {
                
                mdlFuncionario f = new mdlFuncionario();
                
                f.setDataCad(res.getString("DataCad"));
                f.setCargo(res.getString("Cargo"));
                f.setCpf(res.getString("Cpf"));
                f.setNome(res.getString("Nome"));
                f.setUfNasc(res.getString("UfNasc"));
                f.setSalario(res.getDouble("Salario"));
                f.setStatus(res.getString("Status"));

                funcionarios.add(f);                
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(daoFuncionario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return funcionarios;    
    }
    
    public List<mdlFuncionario> buscarFuncAgrupadoUFNasc() 
    {
        List<mdlFuncionario> funcionarios = new ArrayList<>();
        
        String sql = "SELECT concat(UfNasc, ' - ' , COUNT(UfNasc)) AS UfNasc FROM funcionarios GROUP BY UfNasc ORDER BY UfNasc";        
        PreparedStatement pst = daoConexao.getPreparedStatement(sql);       

        try {
            ResultSet res = pst.executeQuery();
             
            while (res.next()) {
                
                mdlFuncionario f = new mdlFuncionario();
                
                f.setUfNasc(res.getString("UfNasc"));

                funcionarios.add(f);                
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(daoFuncionario.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        return funcionarios;    
    }

}
