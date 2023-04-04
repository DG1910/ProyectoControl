package pe.com.cibertec.HolaSpring2.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.cibertec.HolaSpring2.domain.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByUsername (String username);
}
