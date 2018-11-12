package com.aekc;

public class Main {

    public Main main;

    /**
     * 对象的作用域仅在当前方法中有效，不发生逃逸
     */
    public void userMain() {

        Main main = new Main();
    }
}
