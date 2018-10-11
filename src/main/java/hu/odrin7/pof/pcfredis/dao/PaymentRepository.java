package hu.odrin7.pof.pcfredis.dao;

import hu.odrin7.pof.pcfredis.model.ObjectRelation;
import hu.odrin7.pof.pcfredis.model.PaymentId;
import hu.odrin7.pof.pcfredis.model.PaymentObjectReference;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PaymentRepository {
    ///// -------- Payment HASH ------------/////////
    void savePaymentId(List<PaymentId> paymentIds);

    Map<PaymentObjectReference, PaymentId> getAllPaymentId();

    void saveRelation(ObjectRelation objectRelation);

    Map<Long, ObjectRelation> getAllObjectReletion();
}
