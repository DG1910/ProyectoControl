/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.HolaSpring2.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author angel
 */
@Data
@Entity //para que reconozca como una Entidad
@Table (name="persona") //para que no haya problemas entre minus y mayus con las tablas de la BD
public class Persona implements Serializable{ //para optimizar una clase
    
    private static final long serialVersionUID = 1L; 
    
    @Id //para id de persistencia
    @GeneratedValue (strategy = GenerationType.IDENTITY) //para cuadando el Id es autoincrement
    private Long id;
    
    @NotEmpty // valida que lacadena no sea vacía
    private String nombre;
    
    @NotEmpty // valida que lacadena no sea vacía
    private String apellidos;

    @NotEmpty // valida que lacadena no sea vacía
    @Email
    private String email;

    //@NotEmpty // valida que lacadena no sea vacía
    private String telefono;   
    
    @NotNull
    private Double saldo;
}
