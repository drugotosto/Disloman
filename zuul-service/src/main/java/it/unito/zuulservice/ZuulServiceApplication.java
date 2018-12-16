package it.unito.zuulservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Slf4j
@SpringBootApplication
@EnableZuulProxy
public class ZuulServiceApplication implements CommandLineRunner{

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(ZuulServiceApplication.class, args);
	}

	/**
	 * 	Definisce la CORS Configuration indicando le policies che definiscono quali request client accettare.
	 * 	Tutto questo si traduce in una serie di HEADERS restituiti dal server all'interno della risposta HTTP.
	 * 	Al momento le policies abilitano tutte le possibili richieste da parte di qualisiasi client.
	 */
	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		/*
			CORS Access-Control-Allow-Credentials HEADER
			Indica se il server è in grado o meno di gestire l'autenticazione tramite cookie
		 */
		config.setAllowCredentials(true);
		/*
			CORS Access-Control-Allow-Origin HEADER
			Indica quali sono i client-domains (confronto con l'Origin HEADER della Request) che hanno accesso alle risorse del server
		 */
		config.addAllowedOrigin("*");
		/*
			CORS Access-Control-Allow-Headers
			Definsice una lista di Custom Request Headers che il server è disposto ad accettare
		 */
		config.addAllowedHeader("*");
//		config.addAllowedMethod("OPTIONS");
//		config.addAllowedMethod("HEAD");
//		config.addAllowedMethod("GET");
//		config.addAllowedMethod("PUT");
//		config.addAllowedMethod("POST");
//		config.addAllowedMethod("DELETE");
//		config.addAllowedMethod("PATCH");
		/*
			CORS Access-Control-Allow-Methods
			Fornisce una lista dei HTTP Request methods accettate dal server
		 */
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	@Override
	public void run(String... args) throws Exception {
		log.warn("Il nome dell'applicazione e: {}",env.getProperty("spring.application.name"));
	}
}

