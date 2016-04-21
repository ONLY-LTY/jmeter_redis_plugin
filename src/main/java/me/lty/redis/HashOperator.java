package me.lty.redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * Created by LTY on 4/18/16.
 * Redis hash类型数据相关操作类
 */
public class HashOperator {

    /**
     * 查看指定的field是否存在
     * @param pool
     * @param key
     * @param field
     * @return
     */
    public static boolean exists(RedisExecPool pool,String key,String field){
        Jedis jedis = pool.getJedis();
        boolean result = jedis.hexists(key,field);
        pool.returnJedis(jedis);
        return result;
    }

    /**
     * 获取指定的field的值
     * @param pool
     * @param key
     * @param field
     * @return
     */
    public static List<String> get(RedisExecPool pool, String key, String... field){
        Jedis jedis = pool.getJedis();
        List<String> result = jedis.hmget(key,field);
        pool.returnJedis(jedis);
        return result;
    }

    /**
     * 获取所有的field value
     * @param pool
     * @param key
     * @return
     */
    public static Map<String,String> getAll(RedisExecPool pool,String key){
        Jedis jedis = pool.getJedis();
        Map<String,String> result = jedis.hgetAll(key);
        pool.returnJedis(jedis);
        return result;
    }

    /**
     * 添加一条记录 如果field存在 则更新value
     * @param pool
     * @param key
     * @param field
     * @param value
     * @return
     */
    public static long set(RedisExecPool pool,String key,String field,String value){
        Jedis jedis = pool.getJedis();
        long status = jedis.hset(key, field, value);
        pool.returnJedis(jedis);
        return status;
    }

    /**
     * 批量添加记录
     * @param pool
     * @param key
     * @param map
     * @return
     */
    public static String setAll(RedisExecPool pool,String key,Map<String,String> map){
        Jedis jedis = pool.getJedis();
        String result = jedis.hmset(key,map);
        pool.returnJedis(jedis);
        return result;
    }

    /**
     * 获取Hash的长度
     * @param pool
     * @param key
     * @return
     */
    public static long length(RedisExecPool pool,String key){
        Jedis jedis = pool.getJedis();
        long length = jedis.hlen(key);
        pool.returnJedis(jedis);
        return length;
    }

    /**
     * 删除field 对应的值
     * @param pool
     * @param key
     * @param field
     * @return
     */
    public static long delete(RedisExecPool pool,String key,String... field){
        Jedis jedis = pool.getJedis();
        long status = jedis.hdel(key, field);
        pool.returnJedis(jedis);
        return status;
    }
}
