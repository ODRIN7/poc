package hu.odrin7.pof.pcfredis.dao;

import hu.odrin7.pof.pcfredis.model.PaymentTestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private static final String REDIS_SET_KEY = "PaymentIdSET";
    private static final String REDIS_HASH_KEY = "PaymentIdHash";

    @Autowired
    private  RedisTemplate<String, Object> redisTemplate;
    @Autowired
    @Qualifier("listOperations")
    private  ListOperations<String, PaymentTestData> listOperations;
    @Autowired
    @Qualifier("setOperations")
    private  SetOperations<String, PaymentTestData> setOperations;
    @Autowired
    @Qualifier("hashOperations")
    private  HashOperations<String, Long, PaymentTestData> hashOperations;

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
    public void addToPaymentAsList(PaymentTestData paymentTestData) {
        listOperations.leftPush(REDIS_LIST_KEY, paymentTestData);
    }

    @Override
    public List<PaymentTestData> getPaymentAsListMembers() {
        return listOperations.range(REDIS_LIST_KEY, 0, -1);
    }

    @Override
    public Long getProgrammersListCount() {
        return listOperations.size(REDIS_LIST_KEY);

    }

    ///// -------- Set ------------/////////
    @Override
    public void addToPaymentSet(PaymentTestData... paymentTestData) {
        setOperations.add(REDIS_SET_KEY, paymentTestData);
    }

    @Override
    public Set<PaymentTestData> getPaymentIdSetMembers() {
        return setOperations.members(REDIS_SET_KEY);
    }

    @Override
    public boolean isSetMember(PaymentTestData paymentTestData) {
        return setOperations.isMember(REDIS_SET_KEY, paymentTestData);
    }

    ///// -------- Hash ------------/////////
    @Override
    public void saveHash(PaymentTestData paymentTestData) {
        hashOperations.put(REDIS_HASH_KEY, paymentTestData.getId(), paymentTestData);
    }

    @Override
    public void updateHash(PaymentTestData paymentTestData) {
        hashOperations.put(REDIS_HASH_KEY, paymentTestData.getId(), paymentTestData);
    }

    @Override
    public Map<Long, PaymentTestData> findAllHash() {
        return hashOperations.entries(REDIS_HASH_KEY);
    }

    @Override
    public PaymentTestData findInHash(Long id) {
        return hashOperations.get(REDIS_HASH_KEY, id);
    }

    @Override
    public void deleteHash(Long id) {
        hashOperations.delete(REDIS_HASH_KEY, id);
    }

}
