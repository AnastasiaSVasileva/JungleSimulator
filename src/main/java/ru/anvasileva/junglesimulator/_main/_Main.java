package ru.anvasileva.junglesimulator._main;

import ru.anvasileva.junglesimulator.entity.Lion;
import ru.anvasileva.junglesimulator.util.EventSimulator;

public class _Main {
    // Саванна
    // Лев ест антилоп, зебр, буйволов, жирафов, насекомых (с Тимоном и Пумбой), рыбу
    public static void main(String[] args) {
        Lion lion = new Lion();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.activateEvent(lion);
    }
}