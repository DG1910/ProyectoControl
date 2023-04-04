package pe.com.cibertec.HolaSpring2.servicio;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.cibertec.HolaSpring2.Dao.UsuarioDao;
import pe.com.cibertec.HolaSpring2.domain.Rol;
import pe.com.cibertec.HolaSpring2.domain.Usuario;

@Service("userDetailsService") //nombre del bean para UsuarioService
@Slf4j //para imprimir en consola
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByUsername(username);
        
        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }
        
        var roles = new ArrayList<GrantedAuthority>(); 
        
        for (Rol rol : usuario.getRoles()) {
            
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
            log.info(rol.getNombre());
        }
        
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}
