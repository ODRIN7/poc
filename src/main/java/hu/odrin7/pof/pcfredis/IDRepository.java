package hu.odrin7.pof.pcfredis;

import org.springframework.data.repository.CrudRepository;

public interface IDRepository extends CrudRepository<PaymentIdEntity, Long> {
}
