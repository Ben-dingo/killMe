package application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new BuddyInfo("Ernie", "14", "123 Sesame st"));
            repository.save(new BuddyInfo("Elmo", "56", "123 Sesame st"));
            repository.save(new BuddyInfo("Oscar", "21", "123 Sesame st"));
            repository.save(new BuddyInfo("Burt", "14", "123 Sesame st"));

            // fetch all customers
            log.info("Buddies found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo Buddy : repository.findAll()) {
                log.info(Buddy.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("Customer found with findByLastName('Ernie'):");
            log.info("--------------------------------------------");
            repository.findByName("Ernie").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}