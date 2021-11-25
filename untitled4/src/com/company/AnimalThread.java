package com.company;
/**
 * Класс наследник Thread , для работы с потоками
 */
public class AnimalThread extends Thread {
    String PersonName;
    int priorityThread;
    final int distance = 11;
    /**
     * Конструктор потоков
     *
     * @param PersonName - название потока
     * @param priorityThread - приоритет потока
     */
    public AnimalThread(String PersonName, int priorityThread) {
        this.PersonName = PersonName;
        this.priorityThread = priorityThread;
    }
    /**
     * Метод испольнитель потока
     */
    @Override
    public void run() {
        Thread.currentThread().setPriority(priorityThread);
        Thread.currentThread().setName(PersonName);
        //устанавливаем скорость персонажа
        int timeToStep = 1000 / (Thread.currentThread().getPriority());
        for (int i = 0; i < distance; i++){
            try {
                Thread.sleep(timeToStep);
                System.out.println(getName() + (" - ")+(i*100) + " м ");
            } catch (InterruptedException e) {
                /*
                 *поток в ожидании,мб спит
                 */
                e.printStackTrace();
            }
            if (i == distance / 2) {

                if (Thread.currentThread().getPriority() == 1) {
                    Thread.currentThread().setPriority(10);
                } else {
                    Thread.currentThread().setPriority(1);
                }
                timeToStep = 1000 / (Thread.currentThread().getPriority());
            }
            if (i == distance - 10 ) {
            }

        }
        System.out.println("«Финиш»");
        System.out.println("Победитель: черепаха");
    }
}