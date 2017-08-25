package com.roll.comical.console.business.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zongqiang.hao
 */
public class ElvisReflectAttack {
    public static void main(String args[]) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> classType = Elvis.class;
        Constructor<?>  c = classType.getDeclaredConstructor(null);
        Elvis e1 = (Elvis)c.newInstance();
        Elvis e2 = Elvis.getInstance();
        System.out.println(e1==e2);
    }
}
