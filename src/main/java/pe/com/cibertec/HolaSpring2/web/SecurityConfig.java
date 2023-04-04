package pe.com.cibertec.HolaSpring2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService UserDetailsService;
    
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
                
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configurerGobal(AuthenticationManagerBuilder build) throws Exception{
        
        build.userDetailsService(UserDetailsService).passwordEncoder(passwordEncoder());
        
    }   
    

    //restringiendo las URL (autorización)
    @Override
    protected void configure(HttpSecurity http) throws Exception { 
    
        http.authorizeRequests()
                .antMatchers("/editar/**","/eliminar/**", "/agregar/**", "/detalle/**") //el pad que se tendrá acceso
                    .hasRole("ADMIN") //el rol de usuario que tendrá acceso al pad arriba
                .antMatchers("/")
                    .hasAnyRole("USER", "ADMIN") // para ingresar varios roles
                .and()
                    .formLogin() //añadiendo la pagina de login mediante frm
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403")
                ;   
    }
}
