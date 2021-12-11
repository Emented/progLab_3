package actions;

import heroes.AbstractAnimalHero;
import heroes.AbstractFlowersKeeper;
import heroes.PhraseOfHero;
import heroes.Pyatachok;
import places.Place;
import places.Places;

import java.util.Objects;

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

    @Override
    public String toString() {
        return getClass().getName() + "[name: сбор цветов]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CollectFlowersAction)) return false;
        CollectFlowersAction anotherAction = (CollectFlowersAction) o;
        return amount == anotherAction.amount && flowersKeeper.equals(anotherAction.flowersKeeper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowersKeeper, amount);
    }
}