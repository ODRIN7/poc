package hu.odrin7.pof.pcfredis;

import hu.odrin7.pof.pcfredis.entity.PaymentIdEntity;
import hu.odrin7.pof.pcfredis.entity.RelationEntity;
import hu.odrin7.pof.pcfredis.repostiory.PaymentIdRepository;
import hu.odrin7.pof.pcfredis.repostiory.RelationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IDController {

    private final RelationRepository relationRepository;
    private final PaymentIdRepository paymentIdRepository;

    public IDController(RelationRepository relationRepository,
                        PaymentIdRepository paymentIdRepository) {
        this.relationRepository = relationRepository;
        this.paymentIdRepository = paymentIdRepository;
    }

    @GetMapping(value = "/getPaymentIds/")
    public List<PaymentIdEntity> getPaymentIds() {
        List<PaymentIdEntity> paymentIdEntities = new ArrayList<>();
        paymentIdRepository.findAll().forEach(paymentIdEntities::add);
        return paymentIdEntities;
    }

    @GetMapping(value = "/getRelations/")
    public List<RelationEntity> getRelations() {
        List<RelationEntity> relationEntities = new ArrayList<>();
        relationRepository.findAll().forEach(relationEntities::add);
        return relationEntities;
    }
}
