package hu.odrin7.pof.pcfredis.dao;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class PaymentIdRepositoryImpl implements PaymentIdRepository {

    private final RedisTemplate<String, Object> redisTemplate;

    public PaymentIdRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
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
}
