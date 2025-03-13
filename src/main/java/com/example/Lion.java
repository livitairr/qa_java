package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    Feline feline;  // Убираем создание нового объекта Feline здесь

    public Lion(Feline feline, String sex) throws Exception {
        this.feline = feline;  // Присваиваем переданный объект Feline

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
