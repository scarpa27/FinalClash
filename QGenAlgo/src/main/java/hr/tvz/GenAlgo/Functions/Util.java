package hr.tvz.GenAlgo.Functions;

import hr.tvz.GenAlgo.Model.Unit;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Util {
    public static void printUnits(Unit... units) {
        for (Unit unit : units) {
            System.out.println(unit.toString());
        }
    }

    public static <T> T[] shuffleArray(T[] arr) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // swap
            var a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
        return arr;
    }
}
