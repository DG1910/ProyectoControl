package pe.com.cibertec.HolaSpring2.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class EncriptarPassword {
    public static void main(String[] args) {
       
        var password = "Lvargas123";
        
        System.out.println("Original: " + password);
        System.out.println("Encriptado: " + encriptarPassword(password));
    }
    
    public static String encriptarPassword(String password){
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                
        return encoder.encode(password);
    }
}