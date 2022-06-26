package car;

public class CheapFastCar implements Car {
    private boolean premium;
    private boolean isFast;

    public CheapFastCar() {
        this.premium = false;
        this.isFast = true;
    }

    public void drive() {
        System.out.println("Driving the Cheap Fast Car!");
    }

    public void polish() {
        System.out.println("Polishing the Cheap Fast car");
    }

    public int derivePrice() {
        if (this.premium && this.isFast) {
            return 500;
        } else if (this.premium) {
            return 300;
        } else if (this.isFast) {
            return 200;
        } else {
            return 0;
        }
    }
}
