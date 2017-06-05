package com.madmax;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MadMax on 05.06.2017.
 * Класс реализующий работу светофора
 */
public class Semaphore implements ISwitchable {
    public final String red = "Red";
    public final String yellow = "Yellow";
    public final String green = "Green";

    // список цветов светофора
    protected List<String> lights;

    // управляющая переменная
    private int currentLight;

    Semaphore() {
        lights = new ArrayList<String>(3);
        lights.add(red);
        lights.add(yellow);
        lights.add(green);
        currentLight = 0;
    }

    @Override
    public void doSwitch() {
        System.out.println(lights.get(currentLight));
        currentLight += 1;
        if (currentLight > 2)
            currentLight = 0;
    }
}
