package hu.odrin7.pof.pcfredis.dao;

import hu.odrin7.pof.pcfredis.model.paymentText;
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
    private final ListOperations<String, paymentText> listOperations;
    private final SetOperations<String, paymentText> setOperations;
    private final HashOperations<String, Long, paymentText> hashOperations;

    public PaymentIdRepositoryImpl(RedisTemplate<String, Object> redisTemplate,
                                   ListOperations<String, paymentText> listOperations,
                                   SetOperations<String, paymentText> setOperations,
                                   HashOperations<String, Long, paymentText> hashOperations) {
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
    public void addToPaymentAsList(paymentText paymentText) {
        listOperations.leftPush(REDIS_LIST_KEY, paymentText);
    }

    @Override
    public List<paymentText> getPaymentAsListMembers() {
        return listOperations.range(REDIS_LIST_KEY, 0, -1);
    }

    @Override
    public Long getProgrammersListCount() {
        return listOperations.size(REDIS_LIST_KEY);

    }

    ///// -------- Set ------------/////////
    @Override
    public void addToPaymentSet(paymentText... paymentText) {
        setOperations.add(REDIS_SET_KEY, paymentText);
    }

    @Override
    public Set<paymentText> getPaymentIdSetMembers() {
        return setOperations.members(REDIS_SET_KEY);
    }

    @Override
    public boolean isSetMember(paymentText paymentText) {
        return setOperations.isMember(REDIS_SET_KEY, paymentText);
    }

    ///// -------- Hash ------------/////////
    @Override
    public void saveHash(paymentText paymentText) {
        hashOperations.put(REDIS_HASH_KEY, paymentText.getId(), paymentText);
    }

    @Override
    public void updateHash(paymentText paymentText) {
        hashOperations.put(REDIS_HASH_KEY, paymentText.getId(), paymentText);
    }

    @Override
    public Map<Long, paymentText> findAllHash() {
        return hashOperations.entries(REDIS_HASH_KEY);
    }

    @Override
    public paymentText findInHash(Long id) {
        return hashOperations.get(REDIS_HASH_KEY, id);
    }

    @Override
    public void deleteHash(Long id) {
        hashOperations.delete(REDIS_HASH_KEY, id);
    }
}
