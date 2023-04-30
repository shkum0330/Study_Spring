package hello;

import hello.boot.MySpringApplication;
import hello.boot.MySpringBootAnnotation;

@MySpringBootAnnotation
public class MySpringBootMain {
    public static void main(String[] args) {
        MySpringApplication.run(MySpringBootMain.class,args);
    }
}
