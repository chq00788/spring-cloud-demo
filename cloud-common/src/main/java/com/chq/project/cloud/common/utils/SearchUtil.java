package com.chq.project.cloud.common.utils;

import com.alibaba.fastjson.JSON;
import com.chq.project.cloud.common.exception.BusinessException;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询条件帮助类
 *
 * @author CHQ
 * @create 2018-04-28 11:20
 **/
public class SearchUtil {


    public static Map<String, Object> getSearch(Object search) {

        if (search == null) {
            return null;
        }
        Field[] fields = search.getClass().getDeclaredFields();
        Map<String, Object> searchMap = new HashMap<>();
        for (Field field : fields) {
            try {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), search.getClass());
                Object value = propertyDescriptor.getReadMethod().invoke(search);
                if (value != null) {
                    searchMap.put(field.getName(), value);
                }
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        return searchMap;
    }

    public static Map<String, Object> getSearchMap(String param) {
        if (StringUtils.isEmpty(param)) {
            return null;
        }
        Map<String, Object> searchMap;
        try {
            searchMap = JSON.parseObject(param);
            return searchMap;
        } catch (Exception e) {
            throw new BusinessException("参数解析错误");
        }
    }
}
