package ru.anvasileva.junglesimulator.util;

import ru.anvasileva.junglesimulator.entity.Lion;

public class EventSimulator {
    // 30% // лев поспал +10 энергии
    // 5 % // лев охотился безрезультатно - 15 энергии
    // 10 % // лев танцевал с Тимоном и Пумбой  + 5 к здоровью, - 5 энергии
    // 10 % // лев поймал рыбу + fangs * 4 к здоровью, - 6 энергии
    // 15 % // лев поймал антилопу + fangs * 7 к здоровью, - 10 энергии
    // 5 % // лев поел с Тимоном и Пумбой жуков + fangs к здоровью, - 2 энергии
    // 10 % // лев поймал буйвола fangs * 10 к здоровью, - 12 энергии
    // 5 % // лев поймал зебру fangs * 8 к здоровью, - 12 энергии
    // 3 % // на льва напал Шрам - 30 здоровье
    // 7 % // лев убегал от гиен - 20 энергии

    public void activateEvent (Lion lion){
        while (checkStatus(lion)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber <= 30) {
                sleep(lion);
            } else if (eventNumber > 30 && eventNumber <= 35) {
                hunt(lion);
            } else if (eventNumber > 35 && eventNumber <= 45) {
                dance(lion);
            } else if (eventNumber > 45 && eventNumber <= 55) {
                eatFish(lion);
            } else if (eventNumber > 55 && eventNumber <= 70) {
                eatAntilope(lion);
            } else if (eventNumber >70 && eventNumber <= 75) {
                eatBugs(lion);
            } else if (eventNumber > 75 && eventNumber <= 85) {
                eatBuffalo(lion);
            } else if (eventNumber >85 && eventNumber <= 90) {
                eatZebra(lion);
            } else if (eventNumber > 90 && eventNumber <= 93) {
                attackShram(lion);
            } else if (eventNumber > 93 && eventNumber <= 100) {
                runFromHyenas(lion);
            }
        }
        System.out.println("Наш лев умер. Плачем");
    }

    private void sleep(Lion lion){
        int energy = lion.getEnergy() + 10;
        balanceValue(energy);
        lion.setEnergy(energy);
        System.out.println ("Лев поспал + 10 энергии");
        checkEnergy(lion);
    }

    private void hunt(Lion lion){
        int energy = lion.getEnergy() - 15;
        balanceValue(energy);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println ("Лев охотился и ничего не поймал. - 15 энергии");
    }

    private void dance(Lion lion){
        int health = lion.getHealth() + 5;
        int energy = lion.getEnergy() - 5;
        balanceValue(health);
        balanceValue(energy);
        lion.setEnergy(health);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Лев танцевал с Тимоном и Пумбой. + 5 здоровье, - 5 энергии");
    }

    private void eatFish(Lion lion){
        int health = lion.getHealth() + (int) lion.getFangs()*4;
        int energy = lion.getEnergy() - 6;
        balanceValue(health);
        balanceValue(energy);
        lion.setEnergy(health);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Лев поймал и съел рыбу. + " + health + " здоровье, - 6 энергии");
    }

    private void eatAntilope(Lion lion) {
        int health = lion.getHealth() +  (int) lion.getFangs()*7;
        int energy = lion.getEnergy() - 10;
        balanceValue(health);
        balanceValue(energy);
        lion.setEnergy(health);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Лев поймал и съел антилопу. + " + health + " здоровье, - 10 энергии");
    }

    private void eatBugs (Lion lion) {
        int health = lion.getHealth () + (int) lion.getFangs();
        int energy = lion.getEnergy() - 2;
        balanceValue(health);
        balanceValue(energy);
        lion.setEnergy(health);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Лев вместе с Тимоном и Пумбой ел жуков. + " + health + " здоровье, - 2 энергии");
    }

    private void eatBuffalo(Lion lion) {
        int health = lion.getHealth() + (int) lion.getFangs()*10;
        int energy = lion.getEnergy() - 12;
        balanceValue(health);
        balanceValue(energy);
        lion.setHealth(health);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Лев поймал и съел буйвола. +" + health + " здоровье, - 12 энергии");
    }

    private void eatZebra(Lion lion) {
        int health = lion.getHealth() + (int) lion.getFangs()*8;
        int energy = lion.getEnergy() - 12;
        balanceValue(health);
        balanceValue(energy);
        lion.setHealth(health);
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Лев поймал и съел буйвола. +" + health + " здоровье, - 12 энергии");
    }

    private void attackShram(Lion lion){
        int health = lion.getHealth() - 30;
        lion.setHealth(health);
        checkEnergy(lion);
        System.out.println("Льва аттаковал Шрам. - 30 здоровья");
    }

    private void runFromHyenas(Lion lion){
        int energy = lion.getEnergy() - 20;
        lion.setEnergy(energy);
        checkEnergy(lion);
        System.out.println("Лев убегал от гиен. - 20 энергии");
    }

    private int balanceValue(int value) {
        if (value > 100) {
            value = 100;
        } else if (value < 0 ){
            value = 0;
        }
        return value;
    }

    // true - Лев жив, false - Лев ушел на радугу
    private boolean checkStatus (Lion lion){
        if (lion.getHealth() <= 0) {
           return false;
        } else {
            return true;
        }
    }

    private void checkEnergy(Lion lion) {
        if (lion.getEnergy() <= 0 ) {
            int health = lion.getHealth() - 5;
            balanceValue(health);
            lion.setHealth(health);
        }
    }
}
