package com.mzenteno.movies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @SuppressWarnings("null")
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Permite CORS en todas las rutas
                        .allowedOrigins("http://localhost:5173", "https://mzenteno.github.io", "https://lucky-baklava-607e71.netlify.app")  // Permitir dominios específicos
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos permitidos
                        .allowedHeaders("*")  // Permitir todos los headers
                        .allowCredentials(true);  // Permitir cookies/credenciales
            }
        };
    }
}