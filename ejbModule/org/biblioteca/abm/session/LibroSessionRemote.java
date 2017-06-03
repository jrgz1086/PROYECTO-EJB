package org.biblioteca.abm.session;

import java.util.List;
import javax.ejb.Remote;
import org.biblioteca.entidad.Libro;

@Remote
public interface LibroSessionRemote {
	List<Libro> buscarTodos() throws Exception;

	Libro buscarPorCodigo(Integer codigo) throws Exception;

	Libro actualizar(Libro Libro) throws Exception;

	void eliminar(Integer codigo) throws Exception;
}