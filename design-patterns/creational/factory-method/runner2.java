import store.CarStore;
import store.QuickCarStore;

public class runner2 {
    public static void main(String[] args) {
        CarStore store = new QuickCarStore();
        store.prepareToSell("Cheap");
    }
}
