/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Almir
 */
@ManagedBean
public class funcionariosMB {
    public String getFilmesEmCartaz() 
    {
        Client c = Client.create();
        WebResource wr = c.resource("http://localhost:8080/FuncionarioWS/webresources/funcionario/Funcionario/listFuncStatus/ATIVO");
        return wr.get(String.class);
      }
}
