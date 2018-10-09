package hu.odrin7.pof.pcfredis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;


@SpringBootApplication
public class PcfRedisApplication {

    private final Logger logger = LoggerFactory.getLogger(PcfRedisApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PcfRedisApplication.class, args);
    }

    @Bean
    CommandLineRunner loadDatabase(IDRepository idRepository) {
        return args -> {
            logger.info("loading database .....");
            idRepository.deleteAll();
            idRepository.save(new PaymentIdEntity(1L, "A",
                    "1", "area", "createdBy", LocalDate.now()));
            logger.info("loading ended .....");
        };
    }
}
