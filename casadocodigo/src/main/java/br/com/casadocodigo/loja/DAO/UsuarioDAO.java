package br.com.casadocodigo.loja.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.modelo.Usuario;

@Repository
public class UsuarioDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;

//	public Usuario find(String userName) {
//		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where u.userName = :userName", Usuario.class )
//				.setParameter("userName", userName).getResultList();
//		
//		if(usuarios.isEmpty()) {
//			throw new RuntimeException("Usuário não encontrado!");
//		}
//		
//		return usuarios.get(0);
//	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<Usuario> usuarios = manager
				.createQuery("select u from Usuario u where u.userName = :userName", Usuario.class)
				.setParameter("userName", userName).getResultList();

		if (usuarios.isEmpty()) {
			System.out.println("Falhou");
			throw new UsernameNotFoundException("Usuário não encontrado!");

		}

		return usuarios.get(0);
	}

}
