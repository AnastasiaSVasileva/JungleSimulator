package ru.anvasileva.junglesimulator.entity;

public class Lion {
    private int health = 100;
    private int energy = 100;
    private final double fangs = 2.5;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth(){
        return this.health;
    }

    public void setEnergy (int energy){
        this.energy = energy;
    }

    public int getEnergy (){
        return this.energy;
    }

    public double getFangs () {
        return this.fangs;
    }
}
