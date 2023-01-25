package hr.tvz.GenAlgo.Model;

import java.util.Random;

public class Stats implements Stater {
    private double health;
    private double maxHealth;
    private double speed;
    private double strength;
    private double courage;
    private double luck;

    private double energy;

    Stats() {
        init();
    }

    Stats(double maxHealth, double speed, double strength, double courage, double luck) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.speed = speed;
        this.strength = strength;
        this.courage = courage;
        this.luck = luck;
    }

    // TODO
    Stats(Stater p1, Stater p2) {
        init();
    }

    static double mut(double og, double f) {
        return og * f;
    }

    @Override
    public void heal() {
        this.health = maxHealth;
    }

    private void init() {
        var r = new Random();
        var l = r.nextGaussian(1.0, 0.02);
        this.luck = l;

        this.maxHealth = 100 * r.nextGaussian(1.0, 0.03) * l;
        this.heal();
        this.speed = r.nextGaussian(1.0, 0.02) * l;
        this.strength = r.nextGaussian(1.0, 0.03) * l;
        this.courage = r.nextGaussian(1.0, 0.03) * l;
    }

    @Override
    public double damage(double dmg) {
        this.health = this.health - dmg;
        return this.health;
    }

    @Override
    public double maxHealth() {
        return this.maxHealth;
    }

    @Override
    public double run() {
        return speed;
    }

    @Override
    public double attack() {
        return strength;
    }

    @Override
    public double courage() {
        return courage;
    }

    @Override
    public double luck() {
        return luck;
    }

    @Override
    public double[] report() {
        return new double[]{maxHealth, speed, strength, courage, luck};
    }

    @Override
    public Stater mutate() {
        var f = this.luck;
        this.maxHealth = mut(this.maxHealth, f);
        this.speed = mut(this.speed, f);
        this.strength = mut(this.strength, f);
        this.courage = mut(this.courage, f);
        this.luck = mut(this.luck, f);
        return this;
    }
}

