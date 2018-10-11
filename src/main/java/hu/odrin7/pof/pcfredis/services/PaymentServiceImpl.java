package hu.odrin7.pof.pcfredis.services;

import hu.odrin7.pof.pcfredis.dao.PaymentRepository;
import hu.odrin7.pof.pcfredis.model.ObjectRelation;
import hu.odrin7.pof.pcfredis.model.PaymentId;
import hu.odrin7.pof.pcfredis.model.PaymentObjectReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void savePaymentId(List<PaymentId> paymentId) {
        paymentRepository.savePaymentId(paymentId);
    }

    @Override
    public Map<PaymentObjectReference, PaymentId> getAllPaymentId() {
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
