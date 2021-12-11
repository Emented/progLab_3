package actions;

import heroes.AbstractAnimalHero;
import heroes.AbstractFlowersKeeper;
import heroes.Pyatachok;
import places.Place;
import places.Places;

import java.util.Objects;

public class PutFlowersAction implements InterfaceOfAction {
    private final AbstractFlowersKeeper accepter;
    private final int amount;

    public PutFlowersAction(AbstractFlowersKeeper accepter, int amount) {
        this.accepter = accepter;
        this.amount = amount;
    }

    @Override
    public void tellAboutDecision(Pyatachok teller) {
        if (accepter instanceof AbstractAnimalHero) {
            System.out.println("'" + teller.getName() + "' решил дать цветы '" + ((AbstractAnimalHero) accepter).getName() + "' в количестве : " + amount);
        } else {
            System.out.println("'" + teller.getName() + "' решил положить цветы в место '" + ((Place) accepter).getPlace().getName() + "' в количестве : " + amount);
        }
    }

    @Override
    public void performAction(Pyatachok performer) {
        if (accepter instanceof AbstractAnimalHero) {
            if (((AbstractAnimalHero) accepter).getPlace().equals(performer.getPlace())) {
                performer.moveFlowersTo(accepter, amount);
            } else {
                performer.moveTo(((AbstractAnimalHero) accepter).getPlace());
                performer.moveFlowersTo(accepter, amount);
            }
        } else {
            if (((Place) accepter).getPlace().equals(Places.Vase)) {
                if (((Place) accepter).getPlace().equals(Places.HomeOfPyatachek)) {
                    performer.moveFlowersTo(accepter, amount);
                } else {
                    performer.moveTo(Places.HomeOfPyatachek);
                    performer.moveFlowersTo(accepter, amount);
                }
            } else {
                if (((Place) accepter).getPlace().equals(performer.getPlace())) {
                    performer.moveFlowersTo(accepter, amount);
                } else {
                    performer.moveTo(((Place) accepter).getPlace());
                    performer.moveFlowersTo(accepter, amount);
                }
            }
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name: передача цветов]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PutFlowersAction)) return false;
        PutFlowersAction anotherAction = (PutFlowersAction) o;
        return amount == anotherAction.amount && accepter.equals(anotherAction.accepter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accepter, amount);
    }
}
