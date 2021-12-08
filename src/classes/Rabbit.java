package classes;

import utility.AbstractAnimalHero;
import utility.AbstractFlowersKeeper;
import utility.Feelings;
import utility.Places;

public class Rabbit extends AbstractAnimalHero{

    public Rabbit(String name, Places place, Feelings feeling) {
        super(name, 0, place, feeling);
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

    public void meetAnotherHero(AbstractAnimalHero anotherHero) {
        if (getPlace().equals(anotherHero.getPlace())) {
            System.out.println("'" + getName() + "' втретил '" + anotherHero.getName() + "' в месте '" + getPlace().getName() + "'");
        }
        else {
            setPlace (anotherHero.getPlace());
            System.out.println("'" + getName() + "' втретил '" + anotherHero.getName() + "' в месте '" + getPlace().getName() + "'");
        }
    }
}
