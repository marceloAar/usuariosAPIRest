package cl.mar.usuarios.services;

import java.util.List;
import java.util.Optional;

import cl.mar.usuarios.models.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> todosLosUsuarios();
	
	public Usuario agregarUsuario(Usuario usuario);
	
	public Optional<Usuario> buscarUsuario(Long id);
	
	public List<Usuario> buscaPorEstado(Integer estado);
	
	public boolean eliminarUsuario(Long id);	

}