package car;

public class RacingCar implements Car {
    private boolean premium;
    private boolean isFast;

    public RacingCar() {
        this.premium = true;
        this.isFast = true;
    }

    public void drive() {
        System.out.println("Driving the race car!");
    }

    public void polish() {
        System.out.println("Polishing the race car");
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
