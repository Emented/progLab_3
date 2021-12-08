package classes;

import utility.AbstractFlowersKeeper;
import utility.Places;

import java.util.Objects;

public class Place extends AbstractFlowersKeeper {
    Places place;

    public Place(int amountOfFlowers, Places place) {
        super(amountOfFlowers);
        this.place = place;
    }

    public Places getPlace() {
        return place;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[place: " + place.getName() + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(place.getName());
    }

    @Override
    public boolean equals(Object anotherObj) {
        if (this == anotherObj) return true;
        if (anotherObj == null) return false;
        if (getClass() != anotherObj.getClass()) return false;
        Place anotherAbstactPlace = (Place) anotherObj;
        return place.getName().equals(anotherAbstactPlace.place.getName());
    }
}
