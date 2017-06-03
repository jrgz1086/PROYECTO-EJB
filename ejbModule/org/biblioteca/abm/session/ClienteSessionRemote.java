package org.biblioteca.abm.session;

import java.util.List;
import javax.ejb.Remote;
import org.biblioteca.entidad.Cliente;

@Remote
public interface ClienteSessionRemote {
	List<Cliente> buscarTodos() throws Exception;

	Cliente buscarPorCodigo(Integer codigo) throws Exception;

	Cliente actualizar(Cliente Cliente) throws Exception;

	void eliminar(Integer codigo) throws Exception;
}