package hu.odrin7.pof.pcfredis.services;

import hu.odrin7.pof.pcfredis.dao.PaymentRepository;
import hu.odrin7.pof.pcfredis.model.ObjectRelation;
import hu.odrin7.pof.pcfredis.model.PaymentId;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void savePaymentId(PaymentId... paymentId) {
        paymentRepository.savePaymentId(paymentId);
    }

    @Override
    public Set<PaymentId> getAllPaymentId() {
        return paymentRepository.getAllPaymentId();
    }

    @Override
    public void saveRelation(ObjectRelation objectRelation) {
        paymentRepository.saveRelation(objectRelation);
    }

    @Override
    public Map<Long, ObjectRelation> getAllObjectReletion() {
        return paymentRepository.getAllObjectReletion();
    }
}
