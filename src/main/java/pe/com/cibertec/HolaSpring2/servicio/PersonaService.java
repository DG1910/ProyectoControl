/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.HolaSpring2.servicio;

import java.util.List;
import pe.com.cibertec.HolaSpring2.domain.Persona;

/**
 *
 * @author angel
 */
public interface PersonaService {
    public List<Persona> listarPersonas();
    
    public void guardar(Persona persona);
    
    public void eliminar (Persona persona);
    
    public Persona encontrarPersona(Persona persona);
}
