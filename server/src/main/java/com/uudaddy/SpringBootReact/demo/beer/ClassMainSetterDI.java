package com.uudaddy.SpringBootReact.demo.beer;
// https://medium.com/groupon-eng/dependency-injection-in-java-9e9438aa55ae
public class ClassMainSetterDI {
    public static void main(String... args) {
        ClassASetterDI classA = new ClassASetterDI();
        ClassB classB = new ClassB();

        classA.setClassB(classB);

        System.out.println("Ten Percent: " + classA.tenPercent());
    }
}