package com.uudaddy.SpringBootReact.demo.beer;
// https://medium.com/groupon-eng/dependency-injection-in-java-9e9438aa55ae
public class ClassMainSetterDI {
    public static void main(String... args) {
        ClassASetterDI classA = new ClassASetterDI();
        /*
        ClassB classB = new ClassB();
        classA.setClassB(classB);
        */
        ImprovedClassB improvedClassB = new ImprovedClassB();
        classA.setClassB(improvedClassB);


        System.out.println("Ten Percent: " + classA.tenPercent());

        ClassASetterDI classA2 = new ClassASetterDI();
/* We are hiding the ClassB dependency in ClassA because by reading the constructor signature, we cannot identify
its dependencies right away. The code below causes a NullPointerException on runtime:
 */
        System.out.println("Ten Percent: " + classA2.tenPercent()); // NullPointerException here
    }
}