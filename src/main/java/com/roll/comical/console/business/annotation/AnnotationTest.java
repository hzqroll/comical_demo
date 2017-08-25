package com.roll.comical.console.business.annotation;

import java.lang.reflect.Field;

/**
 * @author zongqiang.hao
 */
public class AnnotationTest {
    public static void main(String args[]) {
        for (Field f : UserPojo.class.getDeclaredFields()) {
            System.out.println(f.getName() + " ," + f.isAnnotationPresent(IdAnnotation.class));
            if (f.isAnnotationPresent(IdAnnotation.class)) {
                System.out.println(( f.getAnnotation(IdAnnotation.class)).type());
            }
        }
    }
}
