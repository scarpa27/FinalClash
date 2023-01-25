package hr.tvz.GenAlgo.Model;

import static hr.tvz.GenAlgo.Model.Generation.*;

public class Worker {
    public static void SimulateGen() {
        var gen = new Generation();

        while (gen.units.length > 1) {
            gen.units = battle(gen.units);
            healAll(gen.units);
        }
    }
}
