package ru.anvasileva.junglesimulator.util;

import ru.anvasileva.junglesimulator.entity.Lion;

public class EventSimulator {
    // лев поспал +10 энергии
    // лев охотился безрезультатно - 15 энергии
    // лев танцевал с Тимоном и Пумбой  + 5 к здоровью, - 5 энергии
    // лев поймал рыбу + 10 к здоровью, - 6 энергии
    // лев поймал антилопу + 20 к здоровью, - 10 энергии
    // лев поймал жирафа + 22 к здоровью, - 12 энергии
    // лев поел с Тимоном и Пумбой жуков + 5 к здоровью, - 2 энергии
    // лев поймал буйвола + 25 к здоровью, - 12 энергии
    // лев поймал зебру + 20 к здоровью, - 12 энергии
    // на льва напал Шрам - 30 здоровье
    // лев убегал от гиен - 20 энергии

    public void activateEvent (){

    }

    private void sleep(Lion lion){
        int energy = lion.getEnergy() + 10;
        reduceValue(energy);
        lion.setEnergy(energy);
        System.out.println ("Лев поспал + 10 энергии");
    }

    private void hunt(Lion lion){
        int energy = lion.getEnergy() - 15;
        reduceValue(energy);
        lion.setEnergy(energy);
        System.out.println ("Лев охотился и ничего не поймал. - 15 энергии");
    }

    private void dance(Lion lion){
        int health = lion.getHealth() + 5;
        int energy = lion.getEnergy() - 5;
        reduceValue(health);
        reduceValue(energy);
        lion.setEnergy(health);
        lion.setEnergy(energy);
        System.out.println("Лев танцевал с Тимоном и Пумбой. + 5 здоровье, - 5 энергии");
    }

    private void eatFish(Lion lion){
        int health = lion.getHealth() + 10;
        int energy = lion.getEnergy() - 6;
        reduceValue(health);
        reduceValue(energy);
        lion.setEnergy(health);
        lion.setEnergy(energy);
        System.out.println("Лев поймал и съел рыбу. + 10 здоровье, - 6 энергии");
    }

    private void eatAntilope(Lion lion) {
        int health = lion.getHealth() + 20;
        int energy = lion.getEnergy() - 10;
        reduceValue(health);
        reduceValue(energy);
        lion.setEnergy(health);
        lion.setEnergy(energy);
        System.out.println("Лев поймал и съел антилопу. + 20 здоровье, - 10 энергии");
    }

    private void eatGiraffe (Lion lion) {
        int health = lion.getHealth() + 22;
        int energy = lion.getEnergy() - 12;
        reduceValue(health);
        reduceValue(energy);
        lion.setEnergy(health);
        lion.setEnergy(energy);
        System.out.println("Лев поймал и съел жирафа. + 22 здоровье, - 12 энергии");
    }

    private void eatBugs (Lion lion) {
        int health = lion.getHealth () + 5;
        int energy = lion.getEnergy() - 2;
        reduceValue(health);
        reduceValue(energy);
        lion.setEnergy(health);
        lion.setEnergy(energy);
        System.out.println("Лев вместе с Тимоном и Пумбой ел жуков. + 5 здоровье, - 2 энергии");
    }

    private void eatBuffalo(Lion lion) {
        int health = lion.getHealth() + 25;
        int energy = lion.getEnergy() - 12;
        reduceValue(health);
        reduceValue(energy);
        lion.setHealth(health);
        lion.setEnergy(energy);
        System.out.println("Лев поймал и съел буйвола. + 25 здоровье, - 12 энергии");
    }

    private void eatZebra(Lion lion) {
        int health = lion.getHealth() + 25;
        int energy = lion.getEnergy() - 12;
        reduceValue(health);
        reduceValue(energy);
        lion.setHealth(health);
        lion.setEnergy(energy);
        System.out.println("Лев поймал и съел буйвола. + 20 здоровье, - 12 энергии");
    }

    private void attackShram(Lion lion){
        int health = lion.setHealth() - 30;
        lion.setHealth(health);
        System.out.println("Льва аттаковал Шрам. - 30 здоровья");
    }

    private void runFromHyens(Lion lion){
        int energy = lion.getEnergy() - 20;
        lion.setEnergy(energy);
        System.out.println("Лев убегал от гиен. - 20 энергии");
    }

    private void reduceValue(int value) {
        if (value > 100) {
            value = 100;
        }
        return value;
    }
}
