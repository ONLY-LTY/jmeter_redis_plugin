package me.lty.redis;

/**
 * Created by LTY on 4/18/16.
 */
public interface PoolConfig {
    int MAX_TOTAL = 100 ;   //最大连接数
    int MAX_IDLE = 50 ;    //最大空闲连接数
    int MIN_IDLE = 10 ;    //最小空闲连接数(初始化连接数)
    int MAX_WAIT = 2000;   //没有连接的时候 最大等待时间
    boolean TEST_ON_BORROW = true;
    boolean TEST_ON_RETURN = true;
}
