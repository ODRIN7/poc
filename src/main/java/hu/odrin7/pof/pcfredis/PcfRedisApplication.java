package hu.odrin7.pof.pcfredis;

import hu.odrin7.pof.pcfredis.entity.ObjectReference;
import hu.odrin7.pof.pcfredis.entity.PaymentIdEntity;
import hu.odrin7.pof.pcfredis.entity.RelationEntity;
import hu.odrin7.pof.pcfredis.repostiory.PaymentIdRepository;
import hu.odrin7.pof.pcfredis.repostiory.RelationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PcfRedisApplication {

    private final Logger logger = LoggerFactory.getLogger(PcfRedisApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PcfRedisApplication.class, args);
    }







    @Bean
    CommandLineRunner loadDatabase(PaymentIdRepository idRepository, RelationRepository relationRepository) {
        return args -> {
            logger.info("loading database .....");
            idRepository.deleteAll();
            idRepository.save(new PaymentIdEntity(1L, new ObjectReference("A", "1"), 11L));
            idRepository.save(new PaymentIdEntity(2L, new ObjectReference("B", "1"), 12L));
            idRepository.save(new PaymentIdEntity(3L, new ObjectReference("C", "1"), 13L));
            relationRepository.deleteAll();
            relationRepository.save(new RelationEntity(22L, new ObjectReference("A", "1"),
                    new ObjectReference("b", "1"), "aa", "22", "aa"));
            relationRepository.save(new RelationEntity(23L, new ObjectReference("A", "1"),
                    new ObjectReference("b", "1"), "aa", "22", "aa"));

            logger.info("loading ended .....");
        };
    }
}
