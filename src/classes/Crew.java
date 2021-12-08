package classes;

import utility.AbstractAnimalHero;
import utility.Feelings;
import utility.Places;

public class Crew extends AbstractAnimalHero {
    public Crew(String name, int amountOfFlowers, Places place, Feelings feeling) {
        super(name, amountOfFlowers, place, feeling);
        getIntoFairyTail();
    }

    private void getIntoFairyTail() {
        System.out.println("'" + getName() + "' присоединился к сказке");
    }
}
