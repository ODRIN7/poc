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

    public static void main(String[] args) {
        SpringApplication.run(PcfRedisApplication.class, args);
    }

}
