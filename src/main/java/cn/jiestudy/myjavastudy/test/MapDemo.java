package cn.jiestudy.myjavastudy.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MapDemo {

    public static void main(String[] args) {
        System.out.println("Map集合的值为Map");
        oneToMap();

        System.out.println("Map集合的值为List，特别常用！必须会！");
        oneToList();
    }

    /*
     * 这种是把班级和学生作为映射
     * 而且又把学号和姓名做了映射
     */
    public static void oneToMap() {
        Map<String,Map<String,String>> jiSuanJi = new HashMap<String,Map<String,String>>();
        Map<String,String> ruanJian = new HashMap<String,String>();
        Map<String,String> wangZhan = new HashMap<String,String>();

        /*
         * 千万不要每次都new一个进去，这样就不是原来的集合了
         * 结果yingyong这个key对应的value集合是null
         * 遍历Map的时候还会出现空指针错误
         */
        //jiSuanJi.put("yingyong", (Map<String, String>) new HashMap().put("01", "haha"));
        //jiSuanJi.put("yingyong", (Map<String, String>) new HashMap().put("02", "xixi"));

        /*
         * 要使用下面这种方式，先把集合定义好，
         * 把映射关系设置好，再去给集合添加元素
         */
        jiSuanJi.put("ruanJian", ruanJian);
        jiSuanJi.put("wangZhan", wangZhan);

        ruanJian.put("01", "zhangsan");
        ruanJian.put("02", "lisi");

        wangZhan.put("01", "zhaoliu");
        wangZhan.put("02", "zhouqi");

        Set<String> keySet = jiSuanJi.keySet();
        for(Iterator<String> it = keySet.iterator();it.hasNext();) {
            String key = it.next();
            System.out.println(key);
            Map<String,String> map = jiSuanJi.get(key);
            Set<Map.Entry<String, String>> entrySet = map.entrySet();
            for(Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();it2.hasNext();) {
                Map.Entry<String, String> me = it2.next();
                System.out.println(me.getKey() + ".." + me.getValue());
            }
        }
    }

    /*
     * 这种把班级和学生做了映射
     * 学生类中封装了学号和姓名
     */
    public static void oneToList() {
        Map<String,List<PersonDemo>> jiSuanJi = new HashMap<String,List<PersonDemo>>();
        List<PersonDemo> ruanJian = new ArrayList<PersonDemo>();
        List<PersonDemo> wangZhan = new ArrayList<PersonDemo>();

        jiSuanJi.put("ruanJian", ruanJian);
        jiSuanJi.put("wangZhan", wangZhan);

        ruanJian.add(new PersonDemo("01","zhangsan"));
        ruanJian.add(new PersonDemo("02","lisi"));
        wangZhan.add(new PersonDemo("01","wangwu"));
        wangZhan.add(new PersonDemo("02","zhaoliu"));

        Set<String> keySet = jiSuanJi.keySet();
        for(Iterator<String> it = keySet.iterator(); it.hasNext();){
            String key = it.next();
            System.out.println(key);
            List<PersonDemo> list = jiSuanJi.get(key);
            for(Iterator<PersonDemo> it2 = list.iterator();it2.hasNext();) {
                PersonDemo pd = it2.next();
                System.out.println(pd);
            }
        }
    }

}

class PersonDemo {

    private String id;
    private String name;

    public PersonDemo(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + "..." + this.name;
    }
}