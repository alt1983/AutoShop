
public class Main {
    public static void main(String[] args) {
        int AUTOWAIT = 3000;
        int CLIENTWAIT = 1000;
        final int THREADSNUMBER = 10;
        final Shop shop = new Shop(AUTOWAIT, CLIENTWAIT);
        for (int i = 1; i <= THREADSNUMBER; i++) {
            new Thread(null, shop::sellAuto, "Покупатель" + i).start();
            new Thread(null, shop::acceptAuto, "Toyota").start();
        }
    }
}

