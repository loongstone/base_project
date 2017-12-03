package com.loongstone.commonlibrary.utils;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonNull;
import com.google.gson.JsonSyntaxException;

import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * JSON解析封装
 *
 * @author loongstone
 * @date 2017/12/1 14:43
 */
public class JsonUtils {

    /**
     * 单例模式
     */
    private static Gson gson = new Gson();

    private JsonUtils() {
    }

    /**
     * 将对象转为JSON串，此方法能够满足大部分需求
     *
     * @param src :将要被转化的对象
     * @return :转化后的JSON串
     */
    public static String toJson(Object src) {
        return JSON.toJSONString(src);
    }

    /**
     * 用来将JSON串转为对象，但此方法不可用来转带泛型的集合
     *
     * @param json     JSON串
     * @param classOfT 对象类型
     * @return 转化的对象
     */
    public static <T> Object fromJson(String json, Class<T> classOfT) {
        return JSON.parseObject(json, classOfT);
    }

    /**
     * 用来将JSON串转为对象，此方法可用来转带泛型的集合，如：Type为 new
     * TypeToken<List<T>>(){}.getType()
     * 其它类也可以用此方法调用，就是将List<T>替换为你想要转成的类
     *
     * @param json
     * @param typeOfT
     * @return
     */
    public static Object fromJson(String json, Type typeOfT) {
        try {
            return gson.fromJson(json, typeOfT);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取json中的某个值
     *
     * @param json
     * @param key
     * @return
     */
    public static String getValue(String json, String key) {
        try {
            JSONObject object = new JSONObject(json);
            return object.getString(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取json中的list值
     *
     * @param json
     * @return
     */
    public static String getListValue(String json) {
        try {
            JSONObject object = new JSONObject(json);
            return object.getString("list");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Double getDoubleValue(String json, String key) {
        try {
            JSONObject object = new JSONObject(json);
            return object.getDouble(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getIntValue(String json, String key) {
        try {
            JSONObject object = new JSONObject(json);
            return object.getInt(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}

