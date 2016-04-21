package me.lty.redis;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by LTY on 4/18/16.
 * Redis List类型数据相关操作
 */
public class ListOperator {

    /**
     * List 的长度
     * @param pool
     * @param key
     * @return
     */
    public static long length (RedisExecPool pool,String key){
        Jedis jedis = pool.getJedis();
        long length = jedis.llen(key);
        pool.returnJedis(jedis);
        return length;
    }

    /**
     * 覆盖操作,覆盖List中指定位置的值
     * @param pool
     * @param key
     * @param index
     * @param value
     * @return
     */
    public static String set(RedisExecPool pool,String key,int index,String value){
        Jedis jedis = pool.getJedis();
        String result = jedis.lset(key,index,value);
        pool.returnJedis(jedis);
        return result;
    }

    /**
     * 在list中插入一条记录
     * @param pool
     * @param key
     * @param where  前面插入还是后面插入
     * @param pivot  相对位置的内容(index 的内容)
     * @param value  插入的内容
     * @return
     */
    public static long insert(RedisExecPool pool, String key,LIST_POSITION where,String pivot,String value){
        Jedis jedis = pool.getJedis();
        long status = jedis.linsert(key, where, pivot, value);
        pool.returnJedis(jedis);
        return status;
    }

    /**
     * 获取List中指定位置的值
     * @param pool
     * @param key
     * @param index
     * @return
     */
    public static String get(RedisExecPool pool,String key,int index){
        Jedis jedis = pool.getJedis();
        String result = jedis.lindex(key,index);
        pool.returnJedis(jedis);
        return result;
    }

    /**
     * 移除List的第一条记录
     * @param pool
     * @param key
     * @return
     */
    public static String lpop(RedisExecPool pool,String key){
        Jedis jedis = pool.getJedis();
        String result = jedis.lpop(key);
        pool.returnJedis(jedis);
        return result;
    }

    /**
     * 移除List的最后一条记录
     * @param pool
     * @param key
     * @return
     */
    public static String rpop(RedisExecPool pool,String key){
        Jedis jedis = pool.getJedis();
        String result = jedis.rpop(key);
        pool.returnJedis(jedis);
        return result;
    }

    /**
     *List头部追加记录
     * @param pool
     * @param key
     * @return
     */
    public static long lpush(RedisExecPool pool,String key,String... value){
        Jedis jedis = pool.getJedis();
        long result = jedis.lpush(key,value);
        pool.returnJedis(jedis);
        return  result;
    }

    /**
     * List尾部追加记录
     * @param pool
     * @param key
     * @return
     */
    public static long rpush(RedisExecPool pool,String key,String... value){
        Jedis jedis = pool.getJedis();
        long result = jedis.rpush(key,value);
        pool.returnJedis(jedis);
        return result;
    }

    /**
     * 清空List数据
     * @param pool
     * @param key
     * @return
     */
    public static String clear(RedisExecPool pool,String key){
        Jedis jedis = pool.getJedis();
        String result = jedis.ltrim(key,0,0);
        jedis.lpop(key);
        pool.returnJedis(jedis);
        return result;
    }

    /**
     * 获取指定范围的记录
     * @param pool
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static List<String> lrange(RedisExecPool pool,String key,long start,long end){
        Jedis jedis = pool.getJedis();
        List<String> result = jedis.lrange(key,start,end);
        pool.returnJedis(jedis);
        return result;
    }
}
