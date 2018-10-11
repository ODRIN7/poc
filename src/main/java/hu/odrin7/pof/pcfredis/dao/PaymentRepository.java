package hu.odrin7.pof.pcfredis.dao;

import hu.odrin7.pof.pcfredis.model.ObjectRelation;
import hu.odrin7.pof.pcfredis.model.PaymentId;

import java.util.Map;
import java.util.Set;

public interface PaymentRepository {
    ///// -------- Payment HASH ------------/////////
    void savePaymentId(PaymentId... paymentId);

    void saveRelation(ObjectRelation objectRelation);

    Set<PaymentId> getAllPaymentId();

    Map<Long, ObjectRelation> getAllObjectReletion();
}
