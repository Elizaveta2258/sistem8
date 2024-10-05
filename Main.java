class ChickenOrEgg {

    public static void main(String[] args) {
        Thread chickenThread = new Thread(new ChickenRunnable());
        Thread eggThread = new Thread(new EggRunnable());

        // Запуск потоков
        chickenThread.start();
        eggThread.start();

        try {
            // Ждем, пока оба потока завершатся
            chickenThread.join();
            eggThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Проверяем, какой поток закончил последним
        if (chickenThread.isAlive()) {
            System.out.println("Курица победила!");
        } else {
            System.out.println("Яйцо победило!");
        }
    }

    static class ChickenRunnable implements Runnable {
        @Override
        public void run() {
            // Имитация некоторой работы потока
            try {
                Thread.sleep(500); // Небольшая задержка
                System.out.println("Курица");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class EggRunnable implements Runnable {
        @Override
        public void run() {
            // Имитация некоторой работы потока
            try {
                Thread.sleep(500); // Небольшая задержка
                System.out.println("Яйцо");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
