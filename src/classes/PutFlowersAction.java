package classes;

import utility.AbstractAnimalHero;
import utility.AbstractFlowersKeeper;
import utility.InterfaceOfAction;
import utility.Places;

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
}
