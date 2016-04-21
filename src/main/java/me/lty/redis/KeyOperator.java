package me.lty.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by LTY on 4/18/16.
 * Redis Key相关操作类
 */
public class KeyOperator {

    /**
     * 清空所用Key
     * @param pool
     * @return
     */
    public static String flushAll(RedisExecPool pool){
        Jedis jedis = pool.getJedis();
        String data = jedis.flushAll();
        pool.returnJedis(jedis);
        return data;
    }

    /**
     * 设置key的过期时间
     * @param pool
     * @param key
     * @param seconds
     * @return 影响的记录数
     */
    public static long expired(RedisExecPool pool,String key,int seconds){
        Jedis jedis = pool.getJedis();
        long count = jedis.expire(key,seconds);
        pool.returnJedis(jedis);
        return count;
    }

    /**
     * 判断key是否存在
     * @param pool
     * @param key
     * @return
     */
    public static boolean exists(RedisExecPool pool,String key){
        Jedis jedis = pool.getJedis();
        boolean exists = jedis.exists(key);
        pool.returnJedis(jedis);
        return exists;
    }

    /**
     * 获取key的存储类型
     * @param pool
     * @param key
     * @return string | list | set | zset | hash
     */
    public static String type(RedisExecPool pool,String key){
        Jedis jedis = pool.getJedis();
        String type = jedis.type(key);
        pool.returnJedis(jedis);
        return type;
    }

    /**
     * 删除key
     * @param pool
     * @param key
     * @return
     */
    public static long delete(RedisExecPool pool,String key){
        Jedis jedis = pool.getJedis();
        long status = jedis.del(key);
        pool.returnJedis(jedis);
        return status;
    }

    /**
     * 查找所有匹配给定模式的key
     * @param pool
     * @param pattern
     * @return
     */
    public static Set<String> keys(RedisExecPool pool,String pattern){
        Jedis jedis = pool.getJedis();
        Set<String> set = jedis.keys(pattern);
        pool.returnJedis(jedis);
        return set;
    }
}
