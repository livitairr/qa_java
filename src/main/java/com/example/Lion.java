package com.example;

import java.util.List;

public class Lion {

    private boolean hasMane;
    private Feline feline; // Убираем создание нового экземпляра Feline

    public Lion(Feline feline, String sex) throws Exception {
        this.feline = feline; // Используем переданный мок
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    public int getKittens() {
        return feline.getKittens(); // Используем переданный мок
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник"); // Используем переданный мок
    }
}
