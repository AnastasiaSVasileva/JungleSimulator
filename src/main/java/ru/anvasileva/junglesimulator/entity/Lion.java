package ru.anvasileva.junglesimulator.entity;

public class Lion {
    private int health = 100;
    private int energy = 100;
    private final double Fangs = 2.5;
    private int valueBalanced;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public double getFangs() {
        return Fangs;
    }

    public int balanceValue(int value) {
        if (value < 0) {
            valueBalanced = 0;
        } else if (value > 100) {
            valueBalanced = 100;
        } else valueBalanced = value;
        return valueBalanced;
    }

}

