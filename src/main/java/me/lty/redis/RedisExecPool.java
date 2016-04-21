package me.lty.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * Created by LTY on 4/18/16.
 */
public class RedisExecPool {

    private static JedisPool jedisPool = null;

    private static  RedisExecPool redisExecPool = null;

    private RedisExecPool(String ip, int port, String password){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(PoolConfig.MAX_TOTAL);
        config.setMaxIdle(PoolConfig.MAX_IDLE);
        config.setMinIdle(PoolConfig.MIN_IDLE);
        config.setMaxWaitMillis(PoolConfig.MAX_WAIT);
        config.setTestOnBorrow(PoolConfig.TEST_ON_BORROW);
        config.setTestOnReturn(PoolConfig.TEST_ON_RETURN);
        if("".equals(password.trim())){
            //没有密码
            jedisPool = new JedisPool(config,ip,port);
        }else{
            //有密码
            jedisPool = new JedisPool(config,ip,port,10000,password);
        }
    }

    public static RedisExecPool getInstance(String ip, int port, String password){
        if(redisExecPool == null){
            synchronized (RedisExecPool.class){
                if(redisExecPool == null){
                    redisExecPool = new RedisExecPool(ip,port,password);
                    System.out.println("new RedisExecPool");
                }

            }
        }
        return redisExecPool;
    }

    public void reConneciont(){
         redisExecPool = null;
    }
    public JedisPool getJedisPool(){
        return jedisPool;
    }

    public Jedis getJedis(){
        return jedisPool.getResource();
    }

    public void returnJedis(Jedis jedis){
        jedis.close();
    }
}
