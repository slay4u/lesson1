package Dymura_hw13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

public class TestRunner {
    static void start(Class<?> clazz) throws InvocationTargetException, IllegalAccessException, IllegalArgumentException, InstantiationException {
        Method[] allMethods = clazz.getDeclaredMethods();
        Method before = null;
        int beforeCount = 0;
        Method after = null;
        int afterCount = 0;
        Map<Method, Integer> mapTest = new HashMap<>();
        for (Method m : allMethods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                before = m;
                beforeCount++;
            } else if (m.isAnnotationPresent(Test.class)) {
                if((m.getAnnotation(Test.class).priority() > 0) && (m.getAnnotation(Test.class).priority() < 11)) {
                    mapTest.put(m, m.getAnnotation(Test.class).priority());
                } else throw new RuntimeException("Priority has been set wrong.");
            } else if (m.isAnnotationPresent(AfterSuite.class)) {
                after = m;
                afterCount++;
            }
        }
        if (beforeCount > 1 || afterCount > 1) {
            throw new RuntimeException("More than 1 annotation used of each AfterSuite|BeforeSuite class.");
        }
        if (before != null) {
            before.invoke(clazz.newInstance());
        }
        mapTest = sortByValue(mapTest);
        for (Map.Entry<Method, Integer> m : mapTest.entrySet()) {
            System.out.print("Priority: " + m.getKey().getAnnotation(Test.class).priority() + " ");
            m.getKey().invoke(clazz.newInstance());
        }
        if (after != null) {
            after.invoke(clazz.newInstance());
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        Map<K,V> result = new LinkedHashMap<>();
        Stream <Map.Entry<K,V>> st = map.entrySet().stream();
        st.sorted(Map.Entry.comparingByValue())
                .forEach(e ->result.put(e.getKey(),e.getValue()));
        return result;
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, IllegalArgumentException, InstantiationException {
        start(TestClassOne.class);
    }
}
