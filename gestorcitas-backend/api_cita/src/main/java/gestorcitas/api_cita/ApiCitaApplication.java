package gestorcitas.api_cita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiCitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCitaApplication.class, args);
	}

}
