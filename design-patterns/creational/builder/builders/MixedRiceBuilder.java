package builders;

import food.MixedRice;

public class MixedRiceBuilder implements FoodBuilder {
    
    private MixedRice mx;

    public void newInstance() {
        this.mx = new MixedRice();
    }

    public void addNoodles() {

    }

    public void addRice() {

    } 

    public void addSides() {

    }
}
