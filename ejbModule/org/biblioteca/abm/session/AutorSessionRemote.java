package org.biblioteca.abm.session;

import java.util.List;
import javax.ejb.Remote;
import org.biblioteca.entidad.Autor;

@Remote
public interface AutorSessionRemote {
	List<Autor> buscarTodos() throws Exception;

	Autor buscarPorCodigo(Integer codigo) throws Exception;

	Autor actualizar(Autor Autor) throws Exception;

	void eliminar(Integer codigo) throws Exception;
}