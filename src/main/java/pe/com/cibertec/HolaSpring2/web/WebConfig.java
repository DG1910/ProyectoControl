/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.cibertec.HolaSpring2.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author angel
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
    //PARA CAMBIO DE IDIOMAS
    @Bean
    public LocaleResolver localeResolver(){
        //añadiendo variable de sesion
        var slr = new SessionLocaleResolver();
        
        //llamando al metod setDefaultLocale mediante slr
        slr.setDefaultLocale(new Locale("es"));
        
        //retornamos la variables slr
        return slr;        
    }
    
    //creando el metodo interceptor (PARA CAMBIO DE IDIOMAS)
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        
        //creando variable interceptor
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        
        //retornando la variable intercepcion
        return lci;
        
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
        
        registro.addViewController("/errores/403").setViewName("errores/403");
    }
    
}
