package classes;

import utility.*;

import java.util.Objects;

public class Pyatachok extends AbstractAnimalHero implements InterfaceOfThinking {
    private boolean isSleeping = true;
    private boolean hasAnAimToDoSmthg = false;
    private int degreeOfMem = 0;
    private InterfaceOfAction link;

    public Pyatachok(String name, Places place, Feelings feeling) {
        super(name, 0, place, feeling);
    }

    public void getUp(InterfaceOfTime time) {
        isSleeping = false;
        setFeeling(Feelings.HAPPYNESS);
        System.out.println("'" + getName() + "' встал '" + time.getTime() + "'");
    }

    public void setHasAnAimToDoSmthg(boolean hasAnAimToDoSmthg) {
        this.hasAnAimToDoSmthg = hasAnAimToDoSmthg;
    }

    public void decideToDoSmthg(InterfaceOfAction action) {
        if (!isSleeping) {
            hasAnAimToDoSmthg = true;
            action.tellAboutDecision(Pyatachok.this);
            link = action;
        } else {
            System.out.println("'" + getName() + "' спит");
        }
    }

    public void performDecidedAction() {
        if (hasAnAimToDoSmthg && !isSleeping) {
            link.performAction(Pyatachok.this);
            hasAnAimToDoSmthg = false;
        } else if (isSleeping) {
            System.out.println("'" + getName() + "' спит");
        } else {
            System.out.println("У '" + getName() + "' нет цели");
        }
    }

    public void moveTo(Place fPoint) {
        if (!isSleeping) {
            if (fPoint.getPlace().isPossibileToGetInside()) {
                System.out.println("'" + getName() + "' побежал в место '" + fPoint.getPlace().getName() + "'");
                setPlace(fPoint.getPlace());
            } else {
                System.out.println("сюда нельзя войти");
            }
        } else {
            System.out.println("'" + getName() + "' спит");
        }
    }

    public void moveTo(Places fPoint) {
        if (!isSleeping) {
            if (fPoint.isPossibileToGetInside()) {
                System.out.println("'" + getName() + "' побежал в место '" + fPoint.getName() + "'");
                setPlace(fPoint);
            } else {
                System.out.println("сюда нельзя войти");
            }
        } else {
            System.out.println("'" + getName() + "' спит");
        }
    }

    @Override
    public void thinkAbout(AbstractAnimalHero crewmember) {
        if (!isSleeping) {
            int amountOfFlowers = crewmember.getAmountOfFlowers();
            System.out.println("'" + getName() + "' подумал об '" + crewmember.getName() + "' и понял, что у него " + ((amountOfFlowers == 0) ? "не было" : amountOfFlowers) + " цветов");
            crewmember.checkFlowers();
            setFeeling(Feelings.COMPASSION);
            System.out.println("'" + getName() + "' испытывал '" + getFeeling().getNameOfFeeling() + "'");
        } else {
            System.out.println("'" + getName() + "' спит");
        }
    }

    @Override
    public void thinkMore(AbstractAnimalHero crewmember) {
        if (!isSleeping) {
            setFeeling(Feelings.BIGGERCOMPASSION);
            System.out.println("И чем больше '" + getName() + "' думал об '" + crewmember.getName() + "', тем '" + getFeeling().getNameOfFeeling() + "' он испытывал");
        } else {
            System.out.println("'" + getName() + "' спит");
        }
    }

    public void repeat(PhraseOfHero phrase) {
        if (!isSleeping && hasAnAimToDoSmthg) {
            String currentPhrase = phrase.getPhrase();
            degreeOfMem++;
            System.out.println("'" + getName() + "' повторял '" + currentPhrase + "'");
            System.out.println("Уровень его запоминания увеличился на 1, теперь он составляет " + degreeOfMem);
        } else if (isSleeping) {
            System.out.println("'" + getName() + "' спит");
        } else {
            System.out.println("у '" + getName() + "' нет цели, ему нечего запоминать");
        }
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) return true;
        if (!(anotherObject instanceof Pyatachok)) return false;
        if (!super.equals(anotherObject)) return false;
        Pyatachok anotherPyatachok = (Pyatachok) anotherObject;
        return isSleeping == anotherPyatachok.isSleeping && hasAnAimToDoSmthg == anotherPyatachok.hasAnAimToDoSmthg && degreeOfMem == anotherPyatachok.degreeOfMem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isSleeping, hasAnAimToDoSmthg, degreeOfMem);
    }
}
