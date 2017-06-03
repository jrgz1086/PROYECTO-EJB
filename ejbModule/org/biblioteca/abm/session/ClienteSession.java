package org.biblioteca.abm.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.biblioteca.entidad.Cliente;

@Stateless
public class ClienteSession implements ClienteSessionRemote {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Cliente> buscarTodos() throws Exception {
		String jpql = "SELECT o FROM Cliente o ORDER BY o.codigo";
		List<Cliente> Clientees = (List<Cliente>) em.createQuery(jpql,
				Cliente.class).getResultList();
		return Clientees;
	}

	@Override
	public Cliente buscarPorCodigo(Integer codigo) throws Exception {
		return em.find(Cliente.class, codigo);
	}

	@Override
	public Cliente actualizar(Cliente ClienteAct) throws Exception {
		Cliente Cliente = buscarPorCodigo(ClienteAct.getCodigo());
		if (Cliente == null) { // Si no encuentra Cliente valdrá null
			ClienteAct.setCodigo(null); // para que la bd auto-genere el ID
			em.persist(ClienteAct);
			em.refresh(ClienteAct);
		} else {
			ClienteAct = em.merge(ClienteAct);
		}
		return ClienteAct;
	}

	@Override
	public void eliminar(Integer codigo) throws Exception {
		Cliente ciu = buscarPorCodigo(codigo); // Busca el objeto Cliente
		if (ciu != null) {
			em.remove(ciu);

		}
	}
}
