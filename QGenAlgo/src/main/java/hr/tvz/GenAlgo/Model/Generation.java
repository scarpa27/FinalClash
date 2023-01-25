package hr.tvz.GenAlgo.Model;

import static hr.tvz.GenAlgo.Functions.Fight.fightB;
import static hr.tvz.GenAlgo.Functions.Util.printUnits;
import static hr.tvz.GenAlgo.Functions.Util.shuffleArray;

public class Generation {
    public static final int SIZE = 128 * 2;

    public Unit[] units;

    Generation() {
        this.units = populate();
    }

    Generation(Generation g) {
        this.units = g.units;
        repopulate();
    }

    private static Unit[] populate() {
        var gen = new Unit[SIZE];
        for (int i = 0; i < SIZE; i++) {
            gen[i] = new Unit();
        }
        return gen;
    }

    private void repopulate() {
        shuffleArray(this.units);
        Unit[] full = new Unit[SIZE];

        for (var i = 0; i < SIZE; i += 4) {
            var parent1 = this.units[i];
            var parent2 = this.units[i+1];
            var child1 = new Unit(parent1, parent2);
            var child2 = new Unit(parent1, parent2);

            full[i] = parent1;
            full[i+1] = parent2;
            full[i+2] = child1;
            full[i+3] = child2;
        }

        this.units = full;
    }

    public static void healAll(Unit[] units) {
        for (Unit u : units) {
            u.heal();
        }
    }

    public static Unit[] battle(Unit[] units) {
        var len = units.length;

        var div1 = new Unit[len / 2];
        var div2 = new Unit[len / 2];

        var survive = new Unit[len / 2];

        for (var i = 0; i < len / 2; i++) {
            div1[i] = units[2 * i];
            div2[i] = units[2 * i + 1];
        }

        for (var i = 0; i < len / 2; i++) {
            Unit u1 = div1[i], u2 = div2[i];
            survive[i] = fightB(u1, u2) ? u1 : u2;

            System.out.println("ˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇ\n");
            printUnits(u1, u2);
            survive[i].heal();
            printUnits(survive[i]);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
        }

        return survive;
    }


}
