package cl.mar.usuarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mar.usuarios.models.Usuario;
import cl.mar.usuarios.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
    UsuarioRepository usuarioRepo;
	
	
	@Override
	public List<Usuario> todosLosUsuarios() {
		return this.usuarioRepo.findAll();
	}
	

	@Override
	public Usuario agregarUsuario(Usuario usuario) {
		return this.usuarioRepo.save(usuario);
	}

	
	@Override
	public Optional<Usuario> buscarUsuario(Long id) {		
		return this.usuarioRepo.findById(id);
	}
	

	@Override
	public boolean eliminarUsuario(Long id) {		
		try{
			this.usuarioRepo.deleteById(id);
			return true;
        }catch(Exception err){
        	return false;
        }		
	}


	@Override
	public List<Usuario> buscaPorEstado(Integer estado) {
		
		return this.usuarioRepo.findByEstado(estado);
	}

}