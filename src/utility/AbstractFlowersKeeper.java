package utility;

public abstract class AbstractFlowersKeeper {
    private int amountOfFlowers;

    public AbstractFlowersKeeper(int amountOfFlowers) {
        this.amountOfFlowers = amountOfFlowers;
    }

    public void setAmountOfFlowers(int amount) {
        this.amountOfFlowers = amount;
    }

    public int getAmountOfFlowers() {
        return amountOfFlowers;
    }
}
