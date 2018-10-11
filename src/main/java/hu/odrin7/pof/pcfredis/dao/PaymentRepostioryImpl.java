package hu.odrin7.pof.pcfredis.dao;

import hu.odrin7.pof.pcfredis.model.ObjectRelation;
import hu.odrin7.pof.pcfredis.model.PaymentId;
import hu.odrin7.pof.pcfredis.model.PaymentObjectReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PaymentRepostioryImpl implements PaymentRepository {

    ///// -------- Payment Hash ------------/////////
    private static final String REDIS_PAYMENT_SET_KEY = "redisPaymentSetKey";
    private static final String REDIS_RELATION_HASH_KEY = "redisRelationHashKey";

    @Autowired
    @Qualifier("paymentOperations")
    private HashOperations<String, PaymentObjectReference, PaymentId> paymentOperations;
    @Autowired
    @Qualifier("relationOperations")
    private HashOperations<String, Long, ObjectRelation> relationOperations;

    @Override
    public void savePaymentId(List<PaymentId> paymentIds) {
        paymentIds.forEach(paymentId ->
                paymentOperations.put(REDIS_PAYMENT_SET_KEY,
                        paymentId.getObjectReference(), paymentId));
        ;
    }

    @Override
    public void saveRelation(ObjectRelation objectRelation) {
        relationOperations.put(REDIS_RELATION_HASH_KEY, objectRelation.getId(), objectRelation);
    }

    @Override
    public Map<PaymentObjectReference, PaymentId> getAllPaymentId() {
        return paymentOperations.entries(REDIS_PAYMENT_SET_KEY);
    }

    @Override
    public Map<Long, ObjectRelation> getAllObjectReletion() {
        return relationOperations.entries(REDIS_RELATION_HASH_KEY);
    }

}
