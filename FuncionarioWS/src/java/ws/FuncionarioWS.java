/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.daoFuncionario;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.mdlFuncionario;

/**
 * REST Web Service
 *
 * @author Almir
 */
@Path("funcionario")
public class FuncionarioWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FuncionarioWS
     */
    public FuncionarioWS() {
    }

    /**
     * Retrieves representation of an instance of ws.FuncionarioWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "Testando a API!!!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Funcionario/listFuncNome/{nome}")
    public String getListaFuncPorNome(@PathParam("nome") String nomeFunc) 
    {
        mdlFuncionario func = new mdlFuncionario();
        func.setNome(nomeFunc);
        
        List<mdlFuncionario> lista;
        daoFuncionario dao = new daoFuncionario();
        lista = dao.buscarFuncNome(func);
        
        //Convertendo para GSon
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Funcionario/listFuncCPF/{cpf}")
    public String getListaFuncPorCPF(@PathParam("cpf") String cpfFunc) 
    {
        mdlFuncionario func = new mdlFuncionario();
        func.setCpf(cpfFunc);
        
        mdlFuncionario fun;
        daoFuncionario dao = new daoFuncionario();
        fun = dao.buscarFuncCPF(func);
        
        //Convertendo para GSon
        Gson g = new Gson();
        return g.toJson(fun);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Funcionario/listFuncCargo/{cargo}")
    public String getListaFuncPorCargo(@PathParam("cargo") String cargoFunc) 
    {
        mdlFuncionario func = new mdlFuncionario();
        func.setCargo(cargoFunc);
        
        List<mdlFuncionario> lista;
        daoFuncionario dao = new daoFuncionario();
        lista = dao.buscarFuncCargo(func);
        
        //Convertendo para GSon
        Gson g = new Gson();
        return g.toJson(lista);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Funcionario/listFuncDataCad/{datacad}")
    public String getListaFuncPorDataCad(@PathParam("datacad") String dataCad)  
    {
        mdlFuncionario func = new mdlFuncionario();
        func.setDataCad(dataCad);
        
        List<mdlFuncionario> lista;
        daoFuncionario dao = new daoFuncionario();
        lista = dao.buscarFuncDataCad(func);
        
        //Convertendo para GSon
        Gson g = new Gson();
        return g.toJson(lista);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Funcionario/listFuncStatus/{status}")
    public String getListaFuncPorStatus(@PathParam("status") String statusFunc) 
    {
        mdlFuncionario func = new mdlFuncionario();
        func.setStatus(statusFunc);
        
        List<mdlFuncionario> lista;
        daoFuncionario dao = new daoFuncionario();
        lista = dao.buscarFuncStatus(func);
        
        //Convertendo para GSon
        Gson g = new Gson();
        return g.toJson(lista);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Funcionario/listFuncFaixaSalarial/{salini}/{salfim}")
    public String getListaFuncPorFaixaSalario(@PathParam("salini") Double saliniFunc, @PathParam("salfim") Double salfimFunc) 
    {        
        List<mdlFuncionario> lista;
        daoFuncionario dao = new daoFuncionario();
        lista = dao.buscarFuncFaixaSalarial(saliniFunc, salfimFunc);
        
        //Convertendo para GSon
        Gson g = new Gson();
        return g.toJson(lista);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("Funcionario/listFuncAgrupaUFNasc")
    public String getListaFuncPorFaixaSalario() 
    {        
        List<mdlFuncionario> lista;
        daoFuncionario dao = new daoFuncionario();
        lista = dao.buscarFuncAgrupadoUFNasc();
        
        //Convertendo para GSon
        Gson g = new Gson();
        return g.toJson(lista);
    }

    /**
     * PUT method for updating or creating an instance of FuncionarioWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) 
    {
    }

}
