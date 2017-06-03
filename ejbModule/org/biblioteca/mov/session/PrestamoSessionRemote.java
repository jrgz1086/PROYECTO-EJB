package org.biblioteca.mov.session;

import java.util.List;
import javax.ejb.Remote;
import org.biblioteca.entidad.Prestamo;
import org.biblioteca.entidad.PrestamoLibro;

@Remote
public interface PrestamoSessionRemote {
	List<Prestamo> buscarTodos() throws Exception;

	Prestamo buscarPorCodigo(Integer codigo) throws Exception;

	Prestamo actualizar(Prestamo prestamo, List<PrestamoLibro> prestamoLibroList)
			throws Exception;

	void anular(Integer codigo) throws Exception;
}