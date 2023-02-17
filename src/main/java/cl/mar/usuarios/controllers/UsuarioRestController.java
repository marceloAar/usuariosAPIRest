package cl.mar.usuarios.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.mar.usuarios.models.Usuario;
import cl.mar.usuarios.services.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {

	@Autowired
    UsuarioServiceImpl usuarioService;	
	
	//muestra la lista de todos los usuarios
	// http://localhost:8080/usuarios/mostrar
	@GetMapping("/mostrar") 
	public List<Usuario> mostrar(){		
		List<Usuario> listaUsuarios = this.usuarioService.todosLosUsuarios(); 		
		return listaUsuarios;
	}
	
	
	//agrega un nuevo usuario a la bbdd
	// http://localhost:8080/usuarios/agregar
	@PostMapping("/agregar") 
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.agregarUsuario(usuario);
    }
	
	
	//busca un usuario por su id
	// http://localhost:8080/usuarios/buscar/{id}
    @GetMapping("/buscar/{id}")
    public Optional<Usuario> buscaUsuario(@PathVariable Long id) {
        return this.usuarioService.buscarUsuario(id);
    }
   
    
    //elimina un usuario por su id
    // http://localhost:8080/usuarios/eliminar/{id}
    @DeleteMapping("/eliminar/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id " + id;
        }
    }
    
    
    //busca por estado del usuario
    // http://localhost:8080/usuarios/buscar/estado/{id}
    @GetMapping("/buscar/estado/{id}")
    public List<Usuario> buscaEstado(@PathVariable("id") Integer estado){
    	return this.usuarioService.buscaPorEstado(estado);
    }
	
}
