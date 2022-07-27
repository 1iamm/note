package com.liam;

/**
 * @author Liam Li
 * @date 2022/2/6
 * @Description
 */
public class LambdaTest {
    public static void main(String[] args) {
        new Like().lambda();
    }
}

interface ILike {
    void lambda();
}

class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("i like lambda!");
    }
}