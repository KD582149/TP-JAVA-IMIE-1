package imie.java.tp;

import imie.java.tp.model.CsvMemoryModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class TpServerApplication {

	@Bean
	public CsvMemoryModel csvMemoryModel()
	{
		return new CsvMemoryModel();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
						.exposedHeaders("Authorization");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TpServerApplication.class, args);
	}
}
