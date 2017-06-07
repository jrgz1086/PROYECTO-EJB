package org.biblioteca.abm.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.biblioteca.entidad.Cliente;
import org.biblioteca.entidad.Usuario;

@Stateless
public class UsuarioSession implements UsuarioSessionRemote {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Usuario> buscarTodos() throws Exception {
		String jpql = "SELECT o FROM Usuario o ORDER BY o.codigo";
		List<Usuario> usuarios = (List<Usuario>) em.createQuery(jpql,
				Usuario.class).getResultList();
		return usuarios;
	}

	@Override
	public Usuario buscarPorCodigo(Integer codigo) throws Exception {
		return em.find(Usuario.class, codigo);
	}

	@Override
	public Usuario actualizar(Usuario UsuarioAct) throws Exception {
		Usuario Usuario = buscarPorCodigo(UsuarioAct.getCodigo());
		if (Usuario == null) { // Si no encuentra Usuario valdra null
			UsuarioAct.setCodigo(null); // para que la bd auto-genere el ID
			em.persist(UsuarioAct);
			em.refresh(UsuarioAct);
		} else {
			UsuarioAct = em.merge(UsuarioAct);
		}
		return UsuarioAct;
	}

	@Override
	public void eliminar(Integer codigo) throws Exception {
		Usuario usuario = buscarPorCodigo(codigo); // Busca el objeto Usuario
		if (usuario != null) {
			em.remove(usuario);

		}
	}
}
