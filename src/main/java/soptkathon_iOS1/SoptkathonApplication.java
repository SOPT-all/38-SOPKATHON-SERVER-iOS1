package soptkathon_iOS1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SoptkathonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoptkathonApplication.class, args);
	}

}
