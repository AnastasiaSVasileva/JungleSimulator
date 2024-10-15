package ru.anvasileva.junglesimulator.util;

import ru.anvasileva.junglesimulator.entity.Lion;

public class EventSimulator {
    // лев поспал +10 энергии
    // лев охотился безрезультатно - 15 энергии
    // лев танцевал с Тимоном и Пумбой - 5 энергии, + 5 к здоровью
    // лев поймал рыбу - 6 энергии, + 10 к здоровью
    // лев поймал антилопу - 10 энергии, + 20 к здоровью
    // лев поймал жирафа - 12 энергии, + 22 к здоровью
    // лев поел с Тимоном и Пумбой жуков - 2 энергии, + 5 к здоровью
    // лев поймал буйвола - 12 энергии, + 25 к здоровью
    // лев поймал зебру - 12 энергии, + 20 к здоровью
    // на льва напал Шрам - 30 здоровье
    // лев убегал от гиен - 20 энергии

    public void activateEvent (){

    }

    private void sleep(Lion lion){
        int energy = lion.getEnergy() + 10;
        checkAndReduceValue(energy);
        lion.setEnergy(energy);
        System.out.println ("Лев поспал + 10 энергии");
    }

    private void hunt(Lion lion){
        int energy = lion.getEnergy() - 15;
        checkAndReduceValue(energy);
        lion.setEnergy(energy);
        System.out.println ("Лев охотился и ничего не поймал - 15 энергии");
    }

    private void dance(Lion lion){
        int energy = lion.getEnergy() - 5;
        int health = lion.getHealth() + 5;
        checkAndReduceValue(energy);
        checkAndReduceValue(health);
    }



    private void checkAndReduceValue(int value) {
        if (value > 100) {
            value = 100;
        }
        return value;
    }
}
