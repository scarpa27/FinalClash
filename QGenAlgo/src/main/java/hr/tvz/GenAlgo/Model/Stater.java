package hr.tvz.GenAlgo.Model;

public interface Stater {
    double damage(double dmg);

    double maxHealth();

    double run();

    double attack();

    double courage();

    double luck();

    double[] report();

    void heal();

    Stater mutate();
}
