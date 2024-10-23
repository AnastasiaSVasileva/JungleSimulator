package ru.anvasileva.junglesimulator.entity;

public class Lion {
    private int health = 100;
    private int energy = 100;
    private final double fangs = 2.5;
    private int valueBalanced;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public double getFangs() {
        return this.fangs;
    }

    public int balanceValue(int value) {
        if (value < 0) {
            this.valueBalanced = 0;
        } else if (value > 100) {
            this.valueBalanced = 100;
        } else this.valueBalanced = value;
        return this.valueBalanced;
    }

}

