package tomaszslowik1.beusableproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BeusableprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeusableprojectApplication.class, args);
	}

}
