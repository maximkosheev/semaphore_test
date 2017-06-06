package com.madmax;

/**
 * Created by MadMax on 06.06.2017.
 * Класс описывающий одно состояние светофора
 */
public class Light {
    // цвет состояния
    public Colors color;
    // время "работы" состояния
    public long actionPeriod;

    Light(Colors color, long actionPeriod) {
        this.color = color;
        this.actionPeriod = actionPeriod;
    }

    public void activate() {
        System.out.println(color);
    }
}
