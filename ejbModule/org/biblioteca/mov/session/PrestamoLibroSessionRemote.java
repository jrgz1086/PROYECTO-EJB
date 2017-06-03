package org.biblioteca.mov.session;

import java.util.List;
import javax.ejb.Remote;
import org.biblioteca.entidad.PrestamoLibro;

@Remote
public interface PrestamoLibroSessionRemote {
	List<PrestamoLibro> buscarPorNumeroPrestamo(Integer numeroPrestamo)
			throws Exception;

	void eliminarPorPrestamo(Integer prestamo) throws Exception;
}