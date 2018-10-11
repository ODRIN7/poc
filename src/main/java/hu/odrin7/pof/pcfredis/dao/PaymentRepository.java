package hu.odrin7.pof.pcfredis.dao;

import hu.odrin7.pof.pcfredis.model.ObjectRelation;
import hu.odrin7.pof.pcfredis.model.PaymentId;

import java.util.Map;
import java.util.Set;

public interface PaymentRepository {
    ///// -------- Payment HASH ------------/////////
    void savePaymentId(PaymentId... paymentId);

    Set<PaymentId> getAllPaymentId();

    void saveRelation(ObjectRelation objectRelation);

    Map<Long, ObjectRelation> getAllObjectReletion();
}
