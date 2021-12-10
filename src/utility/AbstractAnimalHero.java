package utility;

import classes.Place;

import java.util.Objects;

public abstract class AbstractAnimalHero extends AbstractFlowersKeeper {
    private final String name;
    private Places place;
    private Feelings feeling;

    public AbstractAnimalHero(String name, int amountOfFlowers, Places place, Feelings feeling) {
        setAmountOfFlowers(amountOfFlowers);
        this.name = name;
        this.place = place;
        this.feeling = feeling;
    }

    public Feelings getFeeling() {
        return feeling;
    }

    public void setFeeling(Feelings feeling) {
        this.feeling = feeling;
    }

    public Places getPlace() {
        return place;
    }

    public void setPlace(Places place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void takeFlowersFrom(AbstractFlowersKeeper giver, int amount) {
        if (giver.getAmountOfFlowers() - amount >= 0) {
            giver.setAmountOfFlowers(giver.getAmountOfFlowers() - amount);
            setAmountOfFlowers(getAmountOfFlowers() + amount);
        } else {
            System.out.println("недосточное количество цветов");
        }
        if (giver instanceof AbstractAnimalHero) {
            System.out.println("'" + getName() + "' взял у '" + ((AbstractAnimalHero) giver).getName() + "' " + amount + " цветов");
        } else {
            System.out.println("'" + getName() + "' сорвал в месте '" + ((Place) giver).getPlace().getName() + "' " + amount + " цветов");
        }
    }

    public void moveFlowersTo(AbstractFlowersKeeper accepter, int amount) {
        if (getAmountOfFlowers() - amount >= 0) {
            setAmountOfFlowers(getAmountOfFlowers() - amount);
            accepter.setAmountOfFlowers(accepter.getAmountOfFlowers() + amount);
        } else {
            System.out.println("недостаточное количество цветов");
        }
        if (accepter instanceof AbstractAnimalHero) {
            System.out.println("'" + getName() + "' отдал герою '" + ((AbstractAnimalHero) accepter).getName() + "' " + amount + " цветов");
        } else {
            System.out.println("'" + getName() + "' положил в место '" + ((Place) accepter).getPlace().getName() + "' " + amount + " цветов");
        }
    }

    public void checkFlowers() {
        if (getAmountOfFlowers() == 0) {
            setFeeling(Feelings.SADNESS);
            System.out.println("У '" + getName() + "' не было цветов, он чувствовал '" + getFeeling().getNameOfFeeling() + "'");
        } else {
            setFeeling(Feelings.HAPPYNESS);
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name:" + name + "]";
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) return true;
        if (!(anotherObject instanceof AbstractAnimalHero)) return false;
        AbstractAnimalHero anotherHero = (AbstractAnimalHero) anotherObject;
        return name.equals(anotherHero.name) && place == anotherHero.place && feeling == anotherHero.feeling && getAmountOfFlowers() == anotherHero.getAmountOfFlowers();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, place, feeling, getAmountOfFlowers());
    }
}
