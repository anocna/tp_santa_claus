import java.util.concurrent.Semaphore;

public class SantaClausProblem {
    // Semáforos para controlar las condiciones
    private static Semaphore renosVacaciones = new Semaphore(0);
    private static Semaphore duendesAyuda = new Semaphore(0);
    private static Semaphore santaDurmiendo = new Semaphore(0);

    public static void main(String[] args) {
        // Crear hilos para los renos y los duendes
        Thread[] renos = new Thread[9];
        Thread[] duendes = new Thread[3];

        for (int i = 0; i < 9; i++) {
            renos[i] = new Thread(new Reno(i));
            renos[i].start();
        }

        for (int i = 0; i < 3; i++) {
            duendes[i] = new Thread(new Duende(i));
            duendes[i].start();
        }

        // Santa Claus está durmiendo hasta que se cumplan las condiciones
        try {
            santaDurmiendo.acquire();
            System.out.println("Santa Claus ha despertado!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Realizar acciones cuando Santa Claus se despierte
        System.out.println("Santa Claus está ayudando a los renos o duendes.");
        // ...

        // Finalizar los hilos de los renos y los duendes
        for (int i = 0; i < 9; i++) {
            try {
                renos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 3; i++) {
            try {
                duendes[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Reno implements Runnable {
        private int id;

        public Reno(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            // Simular la vuelta de vacaciones del reno
            System.out.println("El reno " + id + " ha vuelto de vacaciones.");

            // Incrementar el contador de renos
            renosVacaciones.release();

            // Comprobar si se cumplen las condiciones para despertar a Santa Claus
            if (renosVacaciones.availablePermits() == 9) {
                santaDurmiendo.release();
            }
        }
    }

    static class Duende implements Runnable {
        private int id;

        public Duende(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            // Simular la necesidad de ayuda del duende
            System.out.println("El duende " + id + " necesita ayuda.");

            // Incrementar el contador de duendes
            duendesAyuda.release();

            // Comprobar si se cumplen las condiciones para despertar a Santa Claus
            if (duendesAyuda.availablePermits() == 3) {
                santaDurmiendo.release();
            }
        }
    }
}
