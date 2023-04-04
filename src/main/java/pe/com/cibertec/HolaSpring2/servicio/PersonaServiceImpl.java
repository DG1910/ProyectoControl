/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.HolaSpring2.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.cibertec.HolaSpring2.Dao.PersonaDao;
import pe.com.cibertec.HolaSpring2.domain.Persona;

/**
 *
 * @author angel
 */
@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    private PersonaDao objDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>)objDao.findAll(); //Listado de personas        
    }

    @Override
    @Transactional //para tratar al metodo como transaccion
    public void guardar(Persona persona) {
        objDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        objDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return objDao.findById(persona.getId()).orElse(null);
    }
    
}
