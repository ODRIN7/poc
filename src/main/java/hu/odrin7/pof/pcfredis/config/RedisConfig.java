package hu.odrin7.pof.pcfredis.config;

import hu.odrin7.pof.pcfredis.model.ObjectRelation;
import hu.odrin7.pof.pcfredis.model.PaymentId;
import hu.odrin7.pof.pcfredis.model.PaymentObjectReference;
import hu.odrin7.pof.pcfredis.model.PaymentTestData;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;

@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    private String host;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.port}")
    private int port;

    @Value("${redis.jedis.pool.max-total}")
    private int maxTotal;
    @Value("${redis.jedis.pool.max-idle}")
    private int maxIdle;
    @Value("${redis.jedis.pool.min-idle}")
    private int minIdle;

    // Pool client config
    @Bean
    public JedisClientConfiguration getJedisClientConfiguration() {
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder JedisPoolingClientConfigurationBuilder = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration
                .builder();
        GenericObjectPoolConfig GenericObjectPoolConfig = new GenericObjectPoolConfig();
        GenericObjectPoolConfig.setMaxTotal(maxTotal);
        GenericObjectPoolConfig.setMaxIdle(maxIdle);
        GenericObjectPoolConfig.setMinIdle(minIdle);
        return JedisPoolingClientConfigurationBuilder.poolConfig(GenericObjectPoolConfig).build();
        // https://commons.apache.org/proper/commons-pool/apidocs/org/apache/commons/pool2/impl/GenericObjectPool.html
    }

    @Bean
    public JedisConnectionFactory getJedisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        if (!StringUtils.isEmpty(password)) {
            redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        }
        redisStandaloneConfiguration.setPort(port);
        return new JedisConnectionFactory(redisStandaloneConfiguration, getJedisClientConfiguration());
    }


    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(getJedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
/*        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());*/
        return redisTemplate;
    }

    @Bean
    @Qualifier("listOperations")
    public ListOperations<String, PaymentTestData> listOperations(RedisTemplate<String, PaymentTestData> redisTemplate) {
        return redisTemplate.opsForList();
    }

    @Bean
    @Qualifier("setOperations")
    public SetOperations<String, PaymentTestData> setOperations(RedisTemplate<String, PaymentTestData> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    @Bean
    @Qualifier("hashOperations")
    public HashOperations<String, Long, PaymentTestData> hashOperations(RedisTemplate<String, PaymentTestData> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    @Bean
    @Qualifier("paymentOperations")
    public HashOperations<String, PaymentObjectReference, PaymentId> setPaymentOperations(RedisTemplate<String, PaymentId> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    @Bean
    @Qualifier("relationOperations")
    public HashOperations<String, Long, ObjectRelation> hashRelationOperations(RedisTemplate<String, ObjectRelation> redisTemplate) {
        return redisTemplate.opsForHash();
    }
}
