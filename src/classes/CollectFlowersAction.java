package classes;

import utility.*;

public class CollectFlowersAction implements InterfaceOfAction {
    private final AbstractFlowersKeeper flowersKeeper;
    private final int amount;

    public CollectFlowersAction(AbstractFlowersKeeper flowersKeeper, int amount) {
        this.flowersKeeper = flowersKeeper;
        this.amount = amount;
    }

    @Override
    public void tellAboutDecision(Pyatachok teller) {
        if (flowersKeeper instanceof AbstractAnimalHero) {
            System.out.println("'" + teller.getName() + "' решил сорвать цветы для героя '" + ((AbstractAnimalHero) flowersKeeper).getName() + "' в количестве : " + amount);
        } else {
            System.out.println("'" + teller.getName() + "' решил сорвать цветы в месте '" + ((Place) flowersKeeper).getPlace().getName() + "' в количестве : " + amount);
        }
    }

    @Override
    public void performAction(Pyatachok performer) {
        if (flowersKeeper instanceof AbstractAnimalHero) {
            if (performer.getPlace() != Places.Field) {
                performer.moveTo(Places.Field);
                performer.repeat(PhraseOfHero.First);
                performer.repeat(PhraseOfHero.Second);
            }
        } else {
            if (((Place) flowersKeeper).getPlace().equals(performer.getPlace())) {
                performer.takeFlowersFrom(flowersKeeper, amount);
            } else {
                performer.moveTo(((Place) flowersKeeper));
                performer.takeFlowersFrom(flowersKeeper, amount);
            }
        }
    }
}