package hr.tvz.GenAlgo.Model;


interface fitness {
    double getFit();
}

public class Unit {
    private String name;

    private Stater stats;

    private fitness fitness;

    Unit() {
        this.stats = new Stats();
        this.fitness = new Fit_A();
    }

    Unit(String name, int fitType, double... args) {
        if (args.length != 5)
            return;
        this.name = name;
        this.stats = new Stats(args[0], args[1], args[2], args[3], args[4]);
        this.fitness = new Fit_A();
        this.fitness = switch (fitType) {
            case 0 -> new Fit_A();
            default -> new Fit_B();
        };
    }

    Unit(Unit p1, Unit p2) {
        this.stats= new Stats(p1.getStats(), p2.getStats());
        this.fitness = new Fit_A();
    }

    public void heal() {
        this.stats.heal();
    }

    public double getFit() {
        return fitness.getFit();
    }

    public Stater getStats() {
        return stats;
    }

    public Unit mutate() {
        getStats().mutate();
        return this;
    }

    @Override
    public String toString() {
        var h = stats.damage(0);
        return "{\t\t+:" + String.format("%7.3f", h < 0 ? 0.0 : h) + "/" + String.format("%7.3f", stats.maxHealth()) +
                "\t\tv:" + String.format("%7.3f", stats.run()) +
                "\t\ts:" + String.format("%7.3f", stats.attack()) +
                "\t\tc:" + String.format("%7.3f", stats.courage()) +
                "\t\tl:" + String.format("%7.3f", stats.luck()) + "\t}" + getFit();
    }

    class Fit_A implements fitness {
        @Override
        public double getFit() {
            //  health, speed, strength, courage, luck
            var r = stats.report();
            var s = 0f;
            for (double v : r) {
                s += v;
            }
            return s / 5;
        }
    }

    class Fit_B implements fitness {
        @Override
        public double getFit() {
            return 1;
        }
    }
}

