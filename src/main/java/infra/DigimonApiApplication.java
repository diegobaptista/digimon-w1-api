package infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"presentation", "domain", "infra"})
@EnableJpaRepositories("domain")
@EntityScan("domain")
public class DigimonApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(DigimonApiApplication.class, args);
    }
}
