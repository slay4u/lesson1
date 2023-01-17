package Dymura_hw13;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

public class TestRunner {
    static void start(Class<?> clazz) throws InvocationTargetException, IllegalAccessException, IllegalArgumentException, InstantiationException {
        Method[] allMethods = clazz.getDeclaredMethods();
        List<Method> oneMethod = new ArrayList<>();
        Map<Method, Integer> mapTest = new HashMap<>();
        for (Method m : allMethods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                oneMethod.add(m);
            } else if (m.isAnnotationPresent(Test.class)) {
                if((m.getAnnotation(Test.class).priority() > 0) && (m.getAnnotation(Test.class).priority() < 11)) {
                    mapTest.put(m, m.getAnnotation(Test.class).priority());
                } else throw new RuntimeException("Priority has been set wrong.");
            } else if (m.isAnnotationPresent(AfterSuite.class)) {
                oneMethod.add(m);
            }
        }
        if ((oneMethod.size()) > 2 || (Objects.equals(Arrays.toString(oneMethod.get(0).getDeclaredAnnotations()), Arrays.toString(oneMethod.get(1).getDeclaredAnnotations())))) {
            throw new RuntimeException("More than 1 annotation used of each AfterSuite|BeforeSuite class.");
        }
        for (Method m : oneMethod) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                m.invoke(clazz.newInstance());
            }
        }
        mapTest = sortByValue(mapTest);
        for (Map.Entry<Method, Integer> m : mapTest.entrySet()) {
            System.out.print("Priority: " + m.getKey().getAnnotation(Test.class).priority() + " ");
            m.getKey().invoke(clazz.newInstance());
        }
        for (Method m : oneMethod) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                m.invoke(clazz.newInstance());
            }
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
