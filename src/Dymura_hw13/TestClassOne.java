package Dymura_hw13;

public class TestClassOne {
    @Test(priority = 8)
    void method3() {
        System.out.println("333-test");
    }

    @BeforeSuite
    void method1() {
        System.out.println("111-before");
    }

    //@BeforeSuite
    @Test(priority = 3)
    void method2() {
        System.out.println("222-test");
    }

    //@AfterSuite
    @Test
    void method5() {
        System.out.println("555-test");
    }

    @AfterSuite
    void method6() {
        System.out.println("666-after");
    }

    @Test(priority = 5)
    void method4() {
        System.out.println("444-test");
    }

    @Test(priority = 10)
    void method9() {
        System.out.println("999-test");
    }
}
