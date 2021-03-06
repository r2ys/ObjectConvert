package com.immortal.test;

import com.immortal.util.objectutil.ObjectUtil;
import com.immortal.util.objectutil.filed.converter.ValueConverter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Immortal
 * @version V1.0
 * @since 2016-3-30
 */
class Src {
    private String name;
    private int age;
    private int score;
    private Date time;

    public Src(String name, int age, int score, Date time) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Src{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", score=").append(score);
        sb.append(", time=").append(time);
        sb.append('}');
        return sb.toString();
    }
}

class Target {
    private String name;
    private int age;
    private String value;
    private String time;

    public Target() {
    }

    public Target(String name, int age, String value, String time) {
        this.name = name;
        this.age = age;
        this.value = value;
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Target{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", value='").append(value).append('\'');
        sb.append(", time='").append(time).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

public class TestObjectUtil {

    public static void main(String[] args) {

        Src src = new Src("src", 1, 2, new Date());
        Target target = new Target();
        target.setTime("----------");
        target = ObjectUtil.object2Object(src, target);
        System.out.println("简单的转换");
        System.out.println(src.toString());
        System.out.println(target.toString());

        // 定义映射,把score的值设置到value上
        Map<String, String> map = new HashMap<String, String>();
        map.put("score", "value");
        // 由于score与value的类型不同,score是int,value是字符串,想要转换要加ValueConvert,
        // 上面测试的转换time的类型不同,转换后taeget的time依然是null,

        // int -> String的值转换
        ObjectUtil.addValueConvert(new ValueConverter<Integer, String>() {
            @Override
            public String convert(Integer integer) {
                return String.valueOf(integer);
            }
        });

        // Date -> String的值转换  lamdba必须调用3个参数的addValueConvert来添加
        ObjectUtil.addValueConvert(date -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date),
                Date.class, String.class);


        target = ObjectUtil.object2Object(src, target, map);
        System.out.println("自定义字段的转换");
        System.out.println(src.toString());
        System.out.println(target.toString());

    }

}
