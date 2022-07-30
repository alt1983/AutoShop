import java.util.ArrayList;
import java.util.List;

public class Shop {

    private int autowait;
    private int clientwait;
    Seller seller = new Seller(this);
    List<Auto> autos = new ArrayList<>();

    public Shop(int autowait, int clientwait) {
        this.autowait = autowait;
        this.clientwait = clientwait;
    }

    public Auto sellAuto() {
        return seller.sellAuto(clientwait);
    }

    public void acceptAuto() {
        seller.receiveAuto(autowait);
    }

    List<Auto> getAutos() {
        return autos;
    }
}
