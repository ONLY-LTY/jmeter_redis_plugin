package me.lty.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by LTY on 4/19/16.
 * Redis set类型数据相关操作类
 */
public class SetOperator {

    /**
     * 向集合中添加一条记录 如果member已存在返回0,否则返回1
     * @param pool
     * @param key
     * @param member
     * @return
     */
    public static long add(RedisExecPool pool,String key,String... member){
        Jedis jedis = pool.getJedis();
        long status = jedis.sadd(key,member);
        pool.returnJedis(jedis);
        return status;
    }

    /**
     * 获取集合中的个数
     * @param pool
     * @param key
     * @return
     */
    public static long length(RedisExecPool pool,String key){
        Jedis jedis = pool.getJedis();
        long length = jedis.scard(key);
        pool.returnJedis(jedis);
        return length;
    }

    /**
     * 判断给定的元素是否存在
     * @param pool
     * @param key
     * @param member
     * @return
     */
    public static boolean exists(RedisExecPool pool,String key,String member){
        Jedis jedis = pool.getJedis();
        boolean result = jedis.sismember(key,member);
        pool.returnJedis(jedis);
        return result;
    }

    /**
     * 获取集合中所用成员
     * @param pool
     * @param key
     * @return
     */
    public static Set<String> getMembers(RedisExecPool pool,String key){
        Jedis jedis = pool.getJedis();
        Set<String> result = jedis.smembers(key);
        pool.returnJedis(jedis);
        return result;
    }

    /**
     * 从集合中删除指定成员
     * @param pool
     * @param key
     * @param member
     * @return
     */
    public static long delete(RedisExecPool pool,String key,String... member){
        Jedis jedis = pool.getJedis();
        long status = jedis.srem(key,member);
        pool.returnJedis(jedis);
        return status;
    }
}
