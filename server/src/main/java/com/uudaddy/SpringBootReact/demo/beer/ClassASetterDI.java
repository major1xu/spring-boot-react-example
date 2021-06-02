package com.uudaddy.SpringBootReact.demo.beer;

public class ClassASetterDI  {

    ClassB classB;

    /* Setter Injection */
    void setClassB(ClassB injected) {
        classB = injected;
    }

    double tenPercent() {
        return classB.calculate() * 0.1d;
    }
}
