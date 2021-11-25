package com.company;

public class RabbitAndTurtle {

    public static void main(String[] args) {
        AnimalThread turtle = (new AnimalThread("Черепаха", 10));
        AnimalThread rabbit = (new AnimalThread(" Кролик ", 1));
        turtle.start();
        rabbit.start();
    }
}