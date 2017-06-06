package com.madmax;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int red = 0;
        int yellow = 0;
        int green = 0;

        try {
            while (red <= 0) {
                System.out.print("Укажите время работы красного сигнала: ");
                try {
                    red = Integer.parseInt(reader.readLine()) * 1000;
                    if (red <= 0)
                        throw new NumberFormatException();
                }
                catch (NumberFormatException e) {
                    System.out.println("Укажите целое числовое значение больше нуля");
                }
            }
            while (yellow <= 0) {
                System.out.print("Укажите время работы желтого сигнала: ");
                try {
                    yellow = Integer.parseInt(reader.readLine()) * 1000;
                    if (yellow <= 0)
                        throw new NumberFormatException();
                }
                catch (NumberFormatException e) {
                    System.out.println("Укажите целое числовое значение больше нуля");
                }
            }
            while (green <= 0) {
                System.out.print("Укажите время работы зеленого сигнала: ");
                try {
                    green = Integer.parseInt(reader.readLine()) * 1000;
                    if (green <= 0)
                        throw new NumberFormatException();
                }
                catch (NumberFormatException e) {
                    System.out.println("Укажите целое числовое значение больше нуля");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Semaphore semaphore = new Semaphore();

	    semaphore.addLight(Colors.Red, red);
        semaphore.addLight(Colors.Yellow, yellow);
        semaphore.addLight(Colors.Green, green);

        while(true) {
            semaphore.doSwitch();
        }
    }
}
