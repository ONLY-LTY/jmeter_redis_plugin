package me.lty.redis;

import java.util.*;

/**
 * Created by LTY on 4/18/16.
 */
public class Data  {
   public static final Map<String,List<Operator>> TYPE_OPERATOR ;

    static {
        TYPE_OPERATOR = new HashMap<>();

        TYPE_OPERATOR.put("Key",createKeyList() );

        TYPE_OPERATOR.put("String",createStringList());

        TYPE_OPERATOR.put("Hash",createHashList());

        TYPE_OPERATOR.put("List",createList());

        TYPE_OPERATOR.put("Set",createSetList());
    }



    public static List<Operator> createKeyList(){
        List<Operator> key = new ArrayList<Operator>();
        String type = "Key";
        key.add(new Operator(type,"清空所用Key",0));
        key.add(new Operator(type,"设置key的过期时间",1));
        key.add(new Operator(type,"判断key是否存在",2));
        key.add(new Operator(type,"获取key的存储类型",3));
        key.add(new Operator(type,"删除key",4));
        key.add(new Operator(type,"获取所有key",5));
        return key;
    }

    public static List<Operator> createStringList(){
        List<Operator> string = new ArrayList<Operator>();
        String type = "String";
        string.add(new Operator(type,"根据key获取记录",0));
        string.add(new Operator(type,"添加一条记录",1));
        string.add(new Operator(type,"批量添加记录",2));
        string.add(new Operator(type,"批量获取记录",3));
        return string;
    }

    public static List<Operator> createHashList(){
        List<Operator> Hash = new ArrayList<Operator>();
        String type = "Hash";
        Hash.add(new Operator(type,"查看指定的field是否存在",0));
        Hash.add(new Operator(type,"获取指定的field的值",1));
        Hash.add(new Operator(type,"获取所有的field value",2));
        Hash.add(new Operator(type,"添加一条记录",3));
        Hash.add(new Operator(type,"批量添加记录",4));
        Hash.add(new Operator(type,"获取Hash的长度",5));
        Hash.add(new Operator(type,"删除field 对应的值",6));
        return Hash;
    }

    public static List<Operator> createList(){
        List<Operator> list = new ArrayList<Operator>();
        String type = "List";
        list.add(new Operator(type,"获取List的长度",0));
        list.add(new Operator(type,"覆盖List中指定位置的值",1));
        list.add(new Operator(type,"在List中插入一条记录",2));
        list.add(new Operator(type,"获取List中指定位置的值",3));
        list.add(new Operator(type,"移除List的第一条记录",4));
        list.add(new Operator(type,"移除List的最后一条记录",5));
        list.add(new Operator(type,"List头部追加记录",6));
        list.add(new Operator(type,"List尾部追加记录",7));
        list.add(new Operator(type,"获取List所有数据",9));
        list.add(new Operator(type,"清空List数据",8));
        return list;
    }

    private static List<Operator> createSetList() {
        List<Operator> list = new ArrayList<>();
        String type = "Set";
        list.add(new Operator(type,"向集合中添加一个元素",0));
        list.add(new Operator(type,"获取集合中元素的个数",1));
        list.add(new Operator(type,"判断指定元素是否存在",2));
        list.add(new Operator(type,"获取集合中的所有元素",3));
        list.add(new Operator(type,"从集合中删除指定元素",4));
        return list;
    }
}
