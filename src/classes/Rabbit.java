package classes;

import utility.AbstractFlowersKeeper;
import utility.Feelings;
import utility.Places;

public class Rabbit extends Crew{

    public Rabbit(String name, int amountOfFlowers, Places place, Feelings feeling) {
        super(name, amountOfFlowers, place, feeling);
    }

    public void goOut(Place toPlace) {
        if (toPlace.getPlace().isPossibilityToGetInside()) {
            System.out.println("'" + getName() + "' ушел из места '" + getPlace().getName() + "' в место: '" + getPlace().getName() + "'");
            setPlace(toPlace.getPlace());
        }
        else {
            System.out.println("сюда нельзя войти");
        }
    }

    public void meetAnotherHero(Crew anotherHero) {
        if (getPlace().equals(anotherHero.getPlace())) {
            System.out.println("'" + getName() + "' втретил '" + anotherHero.getName() + "' в месте '" + getPlace().getName() + "'");
        }
        else {
            setPlace (anotherHero.getPlace());
            System.out.println("'" + getName() + "' втретил '" + anotherHero.getName() + "' в месте '" + getPlace().getName() + "'");
        }
    }
}
