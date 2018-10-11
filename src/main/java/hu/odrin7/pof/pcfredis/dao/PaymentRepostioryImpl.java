package hu.odrin7.pof.pcfredis.dao;

import hu.odrin7.pof.pcfredis.model.ObjectRelation;
import hu.odrin7.pof.pcfredis.model.PaymentId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Set;

@Repository
public class PaymentRepostioryImpl implements PaymentRepository {

    ///// -------- Payment Hash ------------/////////
    private static final String REDIS_PAYMENT_SET_KEY = "redisPaymentSetKey";
    private static final String REDIS_RELATION_HASH_KEY = "redisRelationHashKey";

    @Autowired
    @Qualifier("paymentOperations")
    private SetOperations<String, PaymentId> paymentOperations;
    @Autowired
    @Qualifier("relationOperations")
    private HashOperations<String, Long, ObjectRelation> relationOperations;

    @Override
    public void savePaymentId(PaymentId... paymentId) {
        paymentOperations.add(REDIS_PAYMENT_SET_KEY, paymentId);
    }

    @Override
    public void saveRelation(ObjectRelation objectRelation) {
        relationOperations.put(REDIS_RELATION_HASH_KEY, objectRelation.getId(), objectRelation);
    }

    @Override
    public Set<PaymentId> getAllPaymentId() {
        return paymentOperations.members(REDIS_PAYMENT_SET_KEY);
    }

    @Override
    public Map<Long, ObjectRelation> getAllObjectReletion() {
        return relationOperations.entries(REDIS_RELATION_HASH_KEY);
    }

}
