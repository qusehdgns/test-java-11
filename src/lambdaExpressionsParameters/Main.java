package lambdaExpressionsParameters;

import java.util.concurrent.atomic.AtomicReference;

/**
 * https://velog.io/@qusehdgns/Java-%EB%9E%8C%EB%8B%A4%EC%8B%9D-%EB%A7%A4%EA%B0%9C%EB%B3%80%EC%88%98-%EA%B5%AC%ED%98%84with.-%EB%A9%94%EC%86%8C%EB%93%9C-%EC%B2%B4%EC%9D%B4%EB%8B%9D
 */
public class Main {
    public static void main(String[] args) {
        SampleClass<String> sampleClass = new SampleClass<>("A");

        sampleClass.onA((value) -> {
            System.out.println("TEST1");
        }).onB(() -> {
            System.out.println("TEST2");
        }).onLast(() -> {
            System.out.println("TEST3");
        });

        AtomicReference<String> temp = new AtomicReference<>();

        SampleLombokClass sampleLombokClass = new SampleLombokClass();
        sampleLombokClass.setA("A");
        sampleLombokClass.setB("B");

        sampleLombokClass.onA((value) -> {
            System.out.println("TEST1");
            temp.set("123");
        }).onB(() -> {
            System.out.println("TEST2");
        }).onLast(() -> {
            System.out.println("TEST3");
        });

        sampleLombokClass.setA("C");

        System.out.println(temp.get());


        sampleLombokClass.onA((value) -> {
            System.out.println("TEST1");
        }).onB(() -> {
            System.out.println("TEST2");
            temp.set("123456");
        }).onLast(() -> {
            System.out.println("TEST3");
        });

        System.out.println(temp.get());
    }
}
