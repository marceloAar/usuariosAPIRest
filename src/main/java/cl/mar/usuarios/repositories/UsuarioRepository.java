package cl.mar.usuarios.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.mar.usuarios.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public abstract List<Usuario> findByEstado(Integer estado);
}