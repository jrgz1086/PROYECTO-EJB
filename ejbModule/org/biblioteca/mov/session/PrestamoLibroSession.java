package org.biblioteca.mov.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.biblioteca.entidad.PrestamoLibro;

@Stateless
public class PrestamoLibroSession implements PrestamoLibroSessionRemote {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<PrestamoLibro> buscarPorNumeroPrestamo(Integer numeroPrestamo) throws Exception {
		String jpql = "SELECT o FROM PrestamoLibro o WHERE o.prestamo = "
				+ numeroPrestamo;
		List<PrestamoLibro> Prestamoes = (List<PrestamoLibro>) em.createQuery(
				jpql, PrestamoLibro.class).getResultList();
		return Prestamoes;
	}

	@Override
	public void eliminarPorPrestamo(Integer prestamo) throws Exception {
		Query q = em
				.createQuery("DELETE FROM PrestamoLibro pl WHERE pl.prestamo="
						+ prestamo);
		q.executeUpdate();
	}
}