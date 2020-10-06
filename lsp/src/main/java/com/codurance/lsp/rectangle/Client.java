package com.codurance.lsp.rectangle;

public class Client {

    static void clientMethod(Rectangle rec) {
        rec.setWidth(5);
        rec.setHeight(4);
        assert (rec.area() == 20);
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        clientMethod(rect);
    }
}
