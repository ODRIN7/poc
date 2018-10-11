package hu.odrin7.pof.pcfredis.services;

import hu.odrin7.pof.pcfredis.model.ObjectRelation;
import hu.odrin7.pof.pcfredis.model.PaymentId;
import hu.odrin7.pof.pcfredis.model.PaymentObjectReference;

import java.util.List;
import java.util.Map;

public interface PaymentService {

    void savePaymentId(List<PaymentId> paymentId);

    Map<PaymentObjectReference, PaymentId> getAllPaymentId();

    void saveRelation(ObjectRelation objectRelation);

    Map<Long, ObjectRelation> getAllObjectReletion();
}
