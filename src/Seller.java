public class Seller {
    private Shop shop;

    public Seller(Shop shop) {
        this.shop = shop;
    }

    public synchronized void receiveAuto(int i) {
        try {
            Thread.sleep(i);
            shop.getAutos().add(new Auto());
            System.out.println("Производитель " + Thread.currentThread().getName() + " выпустил 1 авто");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Auto sellAuto(int i) {
        try {
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
            while (shop.getAutos().size() == 0) {
                System.out.println("Машин нет");
                wait();
            }
            Thread.sleep(i);
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return shop.getAutos().remove(0);
    }

}
