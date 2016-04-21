package me.lty.redis;

/**
 * Created by LTY on 4/18/16.
 */
public class Operator {
    public String type ; //操作的父类型   例如 List
    public String operator ;//具体的操作描述  例如 向List中insert一条数据
    public int code; //操作码 具体执行方法

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Operator(String type,String operator,int code){
        this.type = type;
        this.operator = operator;
        this.code = code;
    }
    @Override
    public String toString() {
        return operator;
    }
}
