package classes;

import utility.*;

public class Pyatachok extends Crew implements InterfaceOfThinking{
    private boolean isSleeping = true;
    private boolean hasAnAimToDoSmthg = false;
    private int degreeOfMem = 0;

    public Pyatachok(String name, int amountOfFlowers, Places place, Feelings feeling) {
        super(name, amountOfFlowers, place, feeling);
    }

    public void getUp(InterfaceOfTime time) {
        isSleeping = false;
        setFeeling(Feelings.HAPPYNESS);
        System.out.println("'" + getName() + "' встал '" + time.getTime() + "'");
    }

    public boolean isHasAnAimToDoSmthg() {
        return hasAnAimToDoSmthg;
    }

    public void setHasAnAimToDoSmthg(boolean hasAnAimToDoSmthg) {
        this.hasAnAimToDoSmthg = hasAnAimToDoSmthg;
    }

    public void decideToDoSmthg(String action) {
        if (!isSleeping) {
            hasAnAimToDoSmthg = true;
            System.out.println("'" + getName() + "' решил " + action);
        }
        else {
            System.out.println("'" + getName() + "' спит");
        }
    }

    public void moveTo(Place fPoint) {
        if (!isSleeping) {
            if (fPoint.getPlace().isPossibilityToGetInside()) {
                System.out.println("'" + getName() + "' побежал в место '" + fPoint.getPlace().getName() + "'");
                setPlace(fPoint.getPlace());
            } else {
                System.out.println("сюда нельзя войти");
            }
        }
        else {
            System.out.println("'" + getName() + "' спит");
        }
    }

    public void thinkAbout(Crew crewmember) {
        if (!isSleeping) {
            int amountOfFlowers = crewmember.getAmountOfFlowers();
            System.out.println("'" + getName() + "' подумал об '" + crewmember.getName() + "' и понял, что у него " + amountOfFlowers + " цветов");
            setFeeling(Feelings.COMPASSION);
            System.out.println("'" + getName() + "' испытывал '" + getFeeling().getNameOfFeeling() + "'");
        }
        else {
            System.out.println("'" + getName() + "' спит");
        }
    }

    public void thinkMore(Crew crewmember) {
        if (!isSleeping) {
            int amountOfFlowers = crewmember.getAmountOfFlowers();
            setFeeling(Feelings.BIGGERCOMPASSION);
            System.out.println("И чем больше '" + getName() + "' думал о '" + crewmember.getName() + "', тем '" + getFeeling().getNameOfFeeling() + "' он испытывал");
        }
        else {
            System.out.println("'" + getName() + "' спит");
        }
    }

    public void repeat(PhraseOfHero phrase) {
        String currentPhrase = phrase.getPhrase();
        degreeOfMem++;
        System.out.println("'" + getName() + "' повторял '" + (String) currentPhrase + "'");
        System.out.println("Уровень его запоминания увеличился на 1, теперь он составляет " + degreeOfMem);
    }

}
