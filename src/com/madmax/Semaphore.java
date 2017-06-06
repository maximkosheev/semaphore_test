package com.madmax;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MadMax on 05.06.2017.
 * Класс реализующий работу светофора
 */
public class Semaphore implements ISwitchable {
    // список состояний светофора
    protected List<Light> lights;

    // управляющая переменная
    private int currentLight;

    Semaphore() {
        lights = new ArrayList<>();
        currentLight = 0;
    }

    /**
     * Добавляет новое состояние светофора
     * @param color - цвет состояния
     * @param actionPeriod - время работы
     */
    public void addLight(Colors color, long actionPeriod) {
        lights.add(new Light(color, actionPeriod));
    }

    @Override
    public void doSwitch() {
        Light light = lights.get(currentLight);
        light.activate();
        try {
            Thread.sleep(light.actionPeriod);
        }
        catch (InterruptedException e) {
            System.err.println("Thread interrupted");
        }
        currentLight += 1;
        if (currentLight >= lights.size())
            currentLight = 0;
    }
}
