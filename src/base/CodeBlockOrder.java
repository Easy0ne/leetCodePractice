package base;

/**
 * @description:
 * @author: wangzk
 * @date: 2020/8/21 9:22
 */

public class CodeBlockOrder {

    public static void main(String[] args) {
        new Square();
        System.out.println("--------Next--------");
        new Circle();
    }
}


class Shape {
    public Shape() {
        System.out.println("Shape Constructor Func.");
    }

    static {
        System.out.println("Shape static code block 1.");
    }

    static {
        System.out.println("Shape static code block 2.");
    }

    {
        System.out.println("Shape constructor code block.");
    }

}

class Square extends Shape {

    public Square() {
        System.out.println("Square Constructor Func.");
    }

    static {
        System.out.println("Square static code block.");
    }

    {
        System.out.println("Square constructor code block.");
    }

}

class Circle extends Shape {

    public Circle() {
        System.out.println("Circle Constructor Func.");
    }

    static {
        System.out.println("Circle static code block.");
    }

    {
        System.out.println("Circle normal code block.");
    }

}


