package com.dfbz.xbhy.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
@EnableCaching  //开启注解支持
///**
// * 1.开启注解支持
// * 2.需要操作的类添加序列化接口
// * 3.自定义RedisCacheManager
// */
public class SpringCach {

    @Bean
    public RedisCacheManager getCacheManager(RedisConnectionFactory connectionFactory){
        //通过接口提供的方法自动调用子类的方法实现创建一个缓存写对象
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
//序列化  value的序列化器对象
        GenericJackson2JsonRedisSerializer redisSerializer = new GenericJackson2JsonRedisSerializer();
//获取序列化器配对对象
        RedisSerializationContext.SerializationPair<Object> pair
                = RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer);
        //配置对象
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
        configuration.entryTtl(Duration.ofSeconds(600));//设置10分钟生存时间
                                                                                    //放多个缓存名字
        return new RedisCacheManager(redisCacheWriter,configuration,new String[]{"appVersionCache","officeCache"});
    }
}