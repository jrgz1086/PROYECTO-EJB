package org.biblioteca.abm.session;

import java.util.List;
import javax.ejb.Remote;
import org.biblioteca.entidad.Ciudad;

@Remote
public interface CiudadSessionRemote {
	List<Ciudad> buscarTodos() throws Exception;

	Ciudad buscarPorCodigo(Integer codigo) throws Exception;

	Ciudad actualizar(Ciudad Ciudad) throws Exception;

	void eliminar(Integer codigo) throws Exception;
}