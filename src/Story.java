import utility.*;
import classes.*;


public class Story {

    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit("Кролик", Places.HomeOfPyatachek, Feelings.HAPPYNESS);
        Pyatachok pig = new Pyatachok("Пятачёк", Places.HomeOfPyatachek, Feelings.HAPPYNESS);
        Donkey donkey = new Donkey("Осел Иа", Places.HomeOfDonkey, Feelings.HAPPYNESS);
        Place homeOfP = new Place (0, Places.HomeOfPyatachek);
        Place vase = new Place (0, Places.Vase);
        Place yard = new Place (0, Places.Yard);
        Place field = new Place (100, Places.Field);
        InterfaceOfTime earlyTime = new EarlyTime();

        rabbit.goOut(yard);
        pig.getUp(earlyTime);
        pig.decideToDoSmthg("нарвать букет цветов");
        pig.moveTo(field);
        rabbit.meetAnotherHero(pig);
        pig.takeFlowersFrom(field, 5);
        pig.setHasAnAimToDoSmthg(false);
        pig.decideToDoSmthg("поставить цветы в вазу");
        pig.moveTo(homeOfP);
        pig.moveFlowersTo(vase, 5);
        pig.setHasAnAimToDoSmthg(false);
        pig.thinkAbout(donkey);
        pig.thinkMore(donkey);
        pig.decideToDoSmthg("нарвать букет цветов для Иа");
        pig.moveTo(field);
        pig.repeat(PhraseOfHero.First);
        pig.repeat(PhraseOfHero.Second);
    }
}
