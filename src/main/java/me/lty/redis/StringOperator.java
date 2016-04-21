package me.lty.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by LTY on 4/18/16.
 * Redis 基本String类型操作类
 * 提供了基本的增删改查 后期如果有需求 请自行添加
 */

public class StringOperator {

    /**
     * 根据key获取记录
     * @param key
     * @param pool
     * @return
     */
    public static String get(String key,RedisExecPool pool){
        Jedis jedis = pool.getJedis();
        String value = jedis.get(key);
        pool.returnJedis(jedis);
        return value;
    }

    /**
     * 添加一条记录,仅当给定的Key不存在的时候才添加
     * @param pool
     * @param key
     * @param value
     * @return
     */
    public static long setNotExists(RedisExecPool pool,String key,String value){
        Jedis jedis = pool.getJedis();
        long status = jedis.setnx(key,value);
        pool.returnJedis(jedis);
        return status;
    }

    /**
     * 添加一条记录,如果记录已存在则覆盖原有的value
     * @param pool
     * @param key
     * @param value
     * @return
     */
    public static String set(RedisExecPool pool,String key,String value){
        Jedis jedis = pool.getJedis();
        String status = jedis.set(key,value);
        pool.returnJedis(jedis);
        return status;
    }

    /**
     * 批量添加记录
     * @param pool
     * @param keysValues = "key1","value1","key2","value2"
     * @return
     */
    public static String set(RedisExecPool pool,String... keysValues){
        Jedis jedis = pool.getJedis();
        String status = jedis.mset(keysValues);
        pool.returnJedis(jedis);
        return status;
    }

    /**
     * 批量获取记录,如果指定的key不存在在返回的list对应位置为null
     * @param pool
     * @param keys
     * @return
     */
    public static List<String> get(RedisExecPool pool,String... keys){
        Jedis jedis = pool.getJedis();
        List<String> result = jedis.mget(keys);
        pool.returnJedis(jedis);
        return result;
    }
}
