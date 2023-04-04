package pe.com.cibertec.HolaSpring2.Dao;

import org.springframework.data.repository.CrudRepository;
import pe.com.cibertec.HolaSpring2.domain.Persona;

/**
 *
 * @author angel
 */
public interface PersonaDao extends CrudRepository<Persona, Long>{ //nombre la clase entidad y tipo de dato la llave primaria
     
}
