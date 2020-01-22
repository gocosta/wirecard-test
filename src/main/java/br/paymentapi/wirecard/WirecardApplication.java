package br.paymentapi.wirecard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WirecardApplication {

	public static void main(String[] args) {
		SpringApplication.run(WirecardApplication.class, args);
	}

}
