package ru.anvasileva.junglesimulator.util;

import ru.anvasileva.junglesimulator.entity.Lion;

public class EventSimulator {
    // 20 % // лев поспал +10 энергии
    // 22 % // лев охотился безрезультатно - 25 энергии
    // 3 % // лев танцевал с Тимоном и Пумбой  + 1 к здоровью, - 10 энергии
    // 10 % // лев поймал рыбу + fangs * 4 к здоровью, - 15 энергии
    // 11 % // лев поймал антилопу + fangs * 7 к здоровью, - 20 энергии
    // 5 % // лев поел с Тимоном и Пумбой жуков + fangs к здоровью, - 2 энергии
    // 10 % // лев поймал буйвола fangs * 10 к здоровью, - 20 энергии
    // 2 % // лев поймал зебру fangs * 8 к здоровью, - 20 энергии
    // 7 % // на льва напал Шрам - 60 здоровье
    // 10 % // лев убегал от гиен - 55 энергии

    public void activateEvent(Lion lion) {
        while (checkStatus(lion)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber <= 20) {
                sleep(lion);
            } else if (eventNumber > 20 && eventNumber <= 42) {
                hunt(lion);
            } else if (eventNumber > 42 && eventNumber <= 45) {
                dance(lion);
            } else if (eventNumber > 45 && eventNumber <= 55) {
                eatFish(lion);
            } else if (eventNumber > 55 && eventNumber <= 66) {
                eatAntilope(lion);
            } else if (eventNumber > 66 && eventNumber <= 71) {
                eatBugs(lion);
            } else if (eventNumber > 71 && eventNumber <= 81) {
                eatBuffalo(lion);
            } else if (eventNumber > 81 && eventNumber <= 83) {
                eatZebra(lion);
            } else if (eventNumber > 83 && eventNumber <= 90) {
                attackShram(lion);
            } else if (eventNumber > 90 && eventNumber <= 100) {
                runFromHyenas(lion);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Наш лев умер. Плачем");
    }

    private void sleep(Lion lion) {
        int energy = lion.getEnergy() + 10;
        int energyBalanced = lion.balanceValue(energy);
        lion.setEnergy(energyBalanced);
        System.out.println("Лев поспал + 10 энергии");
        checkEnergy(lion);
    }

    private void hunt(Lion lion) {
        int energy = lion.getEnergy() - 25;
        int energyBalanced = lion.balanceValue(energy);
        lion.setEnergy(energyBalanced);
        checkEnergy(lion);
        System.out.println("Лев охотился и ничего не поймал. - 25 энергии");
    }

    private void dance(Lion lion) {
        int health = lion.getHealth() + 1;
        int energy = lion.getEnergy() - 10;
        int healthBalanced = lion.balanceValue(health);
        int energyBalanced = lion.balanceValue(energy);
        lion.setHealth(healthBalanced);
        lion.setEnergy(energyBalanced);
        checkEnergy(lion);
        System.out.println("Лев танцевал с Тимоном и Пумбой. + 1 здоровье, - 10 энергии");
    }

    private void eatFish(Lion lion) {
        int health = lion.getHealth() + (int) (lion.getFangs() * 4);
        int energy = lion.getEnergy() - 15;
        int healthBalanced = lion.balanceValue(health);
        int energyBalanced = lion.balanceValue(energy);
        lion.setHealth(healthBalanced);
        lion.setEnergy(energyBalanced);
        checkEnergy(lion);
        System.out.println("Лев поймал и съел рыбу. + " + (int) (lion.getFangs() * 4) + " здоровье, - 15 энергии");
    }

    private void eatAntilope(Lion lion) {
        int health = lion.getHealth() + (int) (lion.getFangs() * 7);
        int energy = lion.getEnergy() - 20;
        int healthBalanced = lion.balanceValue(health);
        int energyBalanced = lion.balanceValue(energy);
        lion.setHealth(healthBalanced);
        lion.setEnergy(energyBalanced);
        checkEnergy(lion);
        System.out.println("Лев поймал и съел антилопу. + " + (int) (lion.getFangs() * 7) + " здоровье, - 20 энергии");
    }

    private void eatBugs(Lion lion) {
        int health = lion.getHealth() + (int) (lion.getFangs());
        int energy = lion.getEnergy() - 2;
        int healthBalanced = lion.balanceValue(health);
        int energyBalanced = lion.balanceValue(energy);
        lion.setHealth(healthBalanced);
        lion.setEnergy(energyBalanced);
        checkEnergy(lion);
        System.out.println("Лев вместе с Тимоном и Пумбой ел жуков. + " + (int) (lion.getFangs()) + " здоровье, - 2 энергии");
    }

    private void eatBuffalo(Lion lion) {
        int health = lion.getHealth() + (int) (lion.getFangs() * 10);
        int energy = lion.getEnergy() - 20;
        int healthBalanced = lion.balanceValue(health);
        int energyBalanced = lion.balanceValue(energy);
        lion.setHealth(healthBalanced);
        lion.setEnergy(energyBalanced);
        checkEnergy(lion);
        System.out.println("Лев поймал и съел буйвола. + " + (int) (lion.getFangs() * 10) + " здоровье, - 20 энергии");
    }

    private void eatZebra(Lion lion) {
        int health = lion.getHealth() + (int) (lion.getFangs() * 8);
        int energy = lion.getEnergy() - 20;
        int healthBalanced = lion.balanceValue(health);
        int energyBalanced = lion.balanceValue(energy);
        lion.setHealth(healthBalanced);
        lion.setEnergy(energyBalanced);
        checkEnergy(lion);
        System.out.println("Лев поймал и съел буйвола. +" + (int) (lion.getFangs() * 8) + " здоровье, - 20 энергии");
    }

    private void attackShram(Lion lion) {
        int health = lion.getHealth() - 60;
        int healthBalanced = lion.balanceValue(health);
        lion.setHealth(healthBalanced);
        checkEnergy(lion);
        System.out.println("Льва аттаковал Шрам. - 60 здоровья");
    }

    private void runFromHyenas(Lion lion) {
        int energy = lion.getEnergy() - 55;
        int energyBalanced = lion.balanceValue(energy);
        lion.setEnergy(energyBalanced);
        checkEnergy(lion);
        System.out.println("Лев убегал от гиен. - 55 энергии");
    }

    // true - Лев жив, false - Лев ушел на радугу
    private boolean checkStatus(Lion lion) {
        System.out.println("Здоровье: " + lion.getHealth() + ". Энергия: " + lion.getEnergy());
        if (lion.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private void checkEnergy(Lion lion) {
        if (lion.getEnergy() <= 0) {
            int health = lion.getHealth() - 5;
            int healthBalanced = lion.balanceValue(health);
            lion.setHealth(healthBalanced);
        }
    }
}
