package com.base;

import java.lang.reflect.Field;
/**
 * @author <a href="#">Allen.zww</a>
 * @version v1.0
 * @since GenericRepository.java v1.0 2024年09月26日 13:20 Allen.zww
 */
public class GenericRepository<T> {

    // 泛型方法，保存实体时，打印实体的属性和值
    public void save(T entity) {
        Class<?> clazz = entity.getClass();  // 获取泛型实体的运行时类型
        Field[] fields = clazz.getDeclaredFields();  // 获取实体的所有字段

        System.out.println("Saving entity: " + clazz.getSimpleName());
        for (Field field : fields) {
            field.setAccessible(true);  // 如果字段是 private，需要设置可访问
            try {
                Object value = field.get(entity);  // 获取字段的值
                System.out.println("Field: " + field.getName() + ", Value: " + value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

