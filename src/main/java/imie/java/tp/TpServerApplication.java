package imie.java.tp;

import imie.java.tp.model.CsvMemoryModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpServerApplication {

	@Bean
	public CsvMemoryModel csvMemoryModel()
	{
		return new CsvMemoryModel();
	}


	public static void main(String[] args) {
		SpringApplication.run(TpServerApplication.class, args);
	}
}
