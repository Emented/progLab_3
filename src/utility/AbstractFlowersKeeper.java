package utility;

public abstract class AbstractFlowersKeeper {
    private int amountOfFlowers;

    public void setAmountOfFlowers(int amount) {
        this.amountOfFlowers = amount;
    }

    public int getAmountOfFlowers() {
        return amountOfFlowers;
    }
}
