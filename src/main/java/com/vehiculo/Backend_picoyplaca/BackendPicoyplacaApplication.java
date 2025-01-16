package com.vehiculo.Backend_picoyplaca;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendPicoyplacaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPicoyplacaApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Permitir todas las rutas
						.allowedOrigins("http://localhost:4200") // Cambia esto por las URL permitidas
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
						.allowedHeaders("*") // Permitir todas las cabeceras
						.allowCredentials(true); // Permitir credenciales como cookies
			}
		};
	}
}