package hr.tvz.GenAlgo.Functions;

import hr.tvz.GenAlgo.Model.Stater;
import hr.tvz.GenAlgo.Model.Unit;

public class Fight {
    public static boolean fightA(Unit a, Unit b) {
        var as = a.getStats();
        var bs = b.getStats();
        var aatt = as.attack();
        var batt = bs.attack();

        // true if B died
        boolean flag;

        do {
            if (as.damage(batt) < 0) {
                flag = false;
                break;
            }

            if (bs.damage(aatt) < 0) {
                flag = true;
                break;
            }
        } while (true);

        return flag;
    }

    public static boolean fightB(Unit a, Unit b) {
        return fightB(a.getStats(), b.getStats());
    }

    // unit with higher courage always attacks first
    // higher the unit's speed, more frequently it attacks
    private static boolean fightB(Stater a, Stater b) {
        // to reduce code swap A and B if B has higher courage
        var swapped = a.courage() < b.courage();
        if (swapped) {
            var temp = a;
            a = b;
            b = temp;
        }

        var aAtt = a.attack();
        var bAtt = b.attack();
        // convert higher speed stat to shorter interval time
        var aSpd = 2 - a.run();
        var bSpd = 2 - b.run();

        // true if B died
        boolean flag;

        // race simulates current elapsed time, whereas
        // CurrTs represent units' next attack timestamp and are always factors of unit's Spd
        double race = 0;
        var aCurrT = aSpd;
        var bCurrT = bSpd;

        do {
            // check whether A attacks next
            if ((aCurrT - race) < (bCurrT - race)) {
                // set elapsed time to A's attack timestamp and increase timestamp by 1 Spd factor
                race = aCurrT;
                aCurrT += aSpd;
                // damage B and break if health lower than 0
                if (b.damage(aAtt) < 0) {
                    flag = true;
                    break;
                }
            } else {
                race = bCurrT;
                bCurrT += bSpd;
                if (a.damage(bAtt) < 0) {
                    flag = false;
                    break;
                }
            }
        } while (true);

        /*   |F0 F1    XOR
           S0| 0  1
           S1| 1  0 */
        return swapped ^ flag;
    }
}
