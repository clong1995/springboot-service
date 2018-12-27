package com.example.demo.utils;

import lombok.Getter;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class DynamicBean {
    //缓存bean的字段类型
    @Getter
    private static final Map<String, Map<String, Class<?>>> classesMap = new ConcurrentHashMap<>();

    //生成bean
    @Getter
    private Object object;

    //bean的字段值
    @Getter
    private BeanMap valueMap;

    //bean的类型
    @Getter
    private Map<String, Class<?>> classMap;

    public DynamicBean(Map<String, Class<?>> classMap) {
        this.classMap = classMap;
        BeanGenerator generator = new BeanGenerator();
        BeanGenerator.addProperties(generator, classMap);
        this.object = generator.create();
        this.valueMap = BeanMap.create(this.object);
    }

    @SuppressWarnings("unchecked")
    public <T> T getValue(String propertyName) {
        return (T) valueMap.get(propertyName);
    }

    public DynamicBean setValue(String propertyName, Object value) {
        valueMap.put(propertyName, value);
        return this;
    }

    @SuppressWarnings("unchecked")
    private boolean isEmpty() {
        return CollectionUtils.isEmpty(valueMap) || valueMap.values().stream().allMatch(Objects::isNull);
    }
}
