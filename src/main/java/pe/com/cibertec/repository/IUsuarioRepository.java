package pe.com.cibertec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findByEmail(String email);
}
