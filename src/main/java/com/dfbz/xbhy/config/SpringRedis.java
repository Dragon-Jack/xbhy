package com.dfbz.xbhy.config;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@Configuration
@EnableCaching  //开启spring Cache注解支持
public class SpringRedis {


    @Bean(name = "redisTemplate")
    //配置序列化
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        //配置序列化     非hash
        template.setKeySerializer(template.getStringSerializer());
        //序列化器
        GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        //非hash value序列化
        template.setValueSerializer(jsonRedisSerializer);


        //配置hash序列化
        template.setHashKeySerializer(template.getStringSerializer());
        template.setHashValueSerializer(jsonRedisSerializer);

        return template;
    }


}
