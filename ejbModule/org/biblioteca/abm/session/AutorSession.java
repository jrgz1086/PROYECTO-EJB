package org.biblioteca.abm.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.biblioteca.entidad.Autor;

@Stateless
public class AutorSession implements AutorSessionRemote {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Autor> buscarTodos() throws Exception {
		String jpql = "SELECT o FROM Autor o ORDER BY o.codigo ORDER BY o.codigo";
		List<Autor> ciudades = (List<Autor>) em.createQuery(jpql,
				Autor.class).getResultList();
		return ciudades;
	}

	@Override
	public Autor buscarPorCodigo(Integer codigo) throws Exception {
		return em.find(Autor.class, codigo);
	}

	@Override
	public Autor actualizar(Autor autorAct) throws Exception {
		Autor autor = buscarPorCodigo(autorAct.getCodigo()); // Busca el
																// objeto ciudad
		if (autor == null) { // Si no encuentra autor valdrá null
			autorAct.setCodigo(null); // para que la bd auto-genere el ID
			em.persist(autorAct);
			em.refresh(autorAct);
		} else {
			autorAct = em.merge(autorAct);
		}
		return autorAct;
	}

	@Override
	public void eliminar(Integer codigo) throws Exception {
		Autor ciu = buscarPorCodigo(codigo); // Busca el objeto ciudad
		if (ciu != null) {
			em.remove(ciu);
		}
	}
}
