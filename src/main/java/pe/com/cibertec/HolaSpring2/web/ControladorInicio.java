/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.HolaSpring2.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.cibertec.HolaSpring2.domain.Persona;
import pe.com.cibertec.HolaSpring2.servicio.PersonaService;

/**
 *
 * @author angel
 */
//@RestController
@Controller
@Slf4j
public class ControladorInicio {
    @Autowired
    //private PersonaDao personaDao; 
    private PersonaService objServ;
   // private Persona persona;
    
    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal User user){ //@AuthenticationPrincipal User user para alamcenar el usuario autenticado
        //Model ayuda a enviar info de controldor a la vista
        
        log.info("Ejecutando el controlador spring MVC");
        //return "<h1>Hola Mundo con SpringBoot</h1>";
        
        var mensaje = "Canitdad de personas: ";
        //var listaPersonas=personaDao.findAll();
        //var cantPersonas = personaDao.count();
        
        var listaPersonas = objServ.listarPersonas();
        var cantPersonas = listaPersonas.size();
        var saldo_total = 0D;
        
        for (var p : listaPersonas) {
            saldo_total += p.getSaldo();
        }
        
        model.addAttribute("personas", listaPersonas);  
        model.addAttribute("cantidad_personas", cantPersonas);
        model.addAttribute("mensaje", mensaje + cantPersonas); 
        model.addAttribute("saldo_total", saldo_total); 
        
        log.info(user+" jolas");
        
        return "index";
    }
    
        
    @GetMapping("/agregar") //para lectura del CRUD
    public String agregar(Persona obj){
        
        
        return "modificar";
    }   
    
    @PostMapping("/guardar") //para escritura del CRUD
    public String guardar(@Valid Persona obj, Errors errores){ //para indicar que se esta validando el formulario y enviando sus errores
        if(errores.hasErrors()){
            return "index";
        }
        
        objServ.guardar(obj);
        return "redirect:/"; //redireccionando al index o pagina de inicio
    }    
    
    @GetMapping("/editar/{id}")
    public String editar(Persona persona, Model model){
        persona = objServ.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        
        return "modificar";
    }    
    @GetMapping("/eliminar/{id}")
    public String eliminar(Persona persona){
        objServ.eliminar(persona);
        return "redirect:/";
    }    
}
