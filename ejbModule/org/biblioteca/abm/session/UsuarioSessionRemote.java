package org.biblioteca.abm.session;

import java.util.List;

import javax.ejb.Remote;

import org.biblioteca.entidad.Usuario;

@Remote
public interface UsuarioSessionRemote {
	List<Usuario> buscarTodos() throws Exception;

	Usuario buscarPorCodigo(Integer codigo) throws Exception;

	Usuario actualizar(Usuario usuario) throws Exception;

	void eliminar(Integer codigo) throws Exception;
}