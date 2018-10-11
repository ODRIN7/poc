package hu.odrin7.pof.pcfredis.dao;

import hu.odrin7.pof.pcfredis.model.PaymentId;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class PaymentIdRepositoryImpl implements PaymentIdRepository {

    private static final String REDIS_LIST_KEY = "PaymentIdLIST";
    public static final String REDIS_SET_KEY = "PaymentIdSET";
    public static final String REDIS_HASH_KEY = "PaymentIdHash";

    private final RedisTemplate<String, Object> redisTemplate;
    private final ListOperations<String, PaymentId> listOperations;
    private final SetOperations<String, PaymentId> setOperations;
    private final HashOperations<String, Long, PaymentId> hashOperations;

    public PaymentIdRepositoryImpl(RedisTemplate<String, Object> redisTemplate,
                                   ListOperations<String, PaymentId> listOperations,
                                   SetOperations<String, PaymentId> setOperations,
                                   HashOperations<String, Long, PaymentId> hashOperations) {
        this.redisTemplate = redisTemplate;
        this.listOperations = listOperations;
        this.setOperations = setOperations;
        this.hashOperations = hashOperations;
    }

    @Override
    public void setPaymentIdAsString(String idKey, String text) {
        redisTemplate.opsForValue().set(idKey, text);
        redisTemplate.expire(idKey, 10, TimeUnit.SECONDS);
    }

    @Override
    public String getProgrammerAsString(String idKey) {
        return (String) redisTemplate.opsForValue().get(idKey);
    }

    ///// -------- LIST ------------/////////
    @Override
    public void addToPaymentAsList(PaymentId paymentId) {
        listOperations.leftPush(REDIS_LIST_KEY, paymentId);
    }

    @Override
    public List<PaymentId> getPaymentAsListMembers() {
        return listOperations.range(REDIS_LIST_KEY, 0, -1);
    }

    @Override
    public Long getProgrammersListCount() {
        return listOperations.size(REDIS_LIST_KEY);

    }

    ///// -------- Set ------------/////////
    @Override
    public void addToPaymentSet(PaymentId... paymentId) {
        setOperations.add(REDIS_SET_KEY, paymentId);
    }

    @Override
    public Set<PaymentId> getPaymentIdSetMembers() {
        return setOperations.members(REDIS_SET_KEY);
    }

    @Override
    public boolean isSetMember(PaymentId paymentId) {
        return setOperations.isMember(REDIS_SET_KEY, paymentId);
    }

    ///// -------- Hash ------------/////////
    @Override
    public void saveHash(PaymentId paymentId) {
        hashOperations.put(REDIS_HASH_KEY, paymentId.getId(), paymentId);
    }

    @Override
    public void updateHash(PaymentId paymentId) {
        hashOperations.put(REDIS_HASH_KEY, paymentId.getId(), paymentId);
    }

    @Override
    public Map<Long, PaymentId> findAllHash() {
        return hashOperations.entries(REDIS_HASH_KEY);
    }

    @Override
    public PaymentId findInHash(Long id) {
        return hashOperations.get(REDIS_HASH_KEY, id);
    }

    @Override
    public void deleteHash(Long id) {
        hashOperations.delete(REDIS_HASH_KEY, id);
    }
}
