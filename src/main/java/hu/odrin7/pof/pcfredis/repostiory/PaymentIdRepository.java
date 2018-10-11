package hu.odrin7.pof.pcfredis.repostiory;

import hu.odrin7.pof.pcfredis.entity.PaymentIdEntity;
import org.springframework.data.repository.CrudRepository;

public interface PaymentIdRepository extends CrudRepository<PaymentIdEntity, Long> {
}
