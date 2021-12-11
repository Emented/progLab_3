import classes.*;
import utility.*;


public class Story {

    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit("Кролик", Places.HomeOfPyatachek, Feelings.HAPPYNESS);
        Pyatachok pig = new Pyatachok("Пятачёк", Places.HomeOfPyatachek, Feelings.HAPPYNESS);
        Donkey donkey = new Donkey("Осел Иа", Places.HomeOfDonkey, Feelings.HAPPYNESS);
        Place homeOfP = new Place(0, Places.HomeOfPyatachek);
        Place vase = new Place(0, Places.Vase);
        Place yard = new Place(0, Places.Yard);
        Place field = new Place(100, Places.Field);
        InterfaceOfTime earlyTime = new EarlyTime();

        rabbit.goOut(yard);
        pig.getUp(earlyTime);
        pig.decideToDoSmthg(new CollectFlowersAction(field, 5));
        pig.performDecidedAction();
        rabbit.meetAnotherHero(pig);
        pig.decideToDoSmthg(new PutFlowersAction(vase, 5));
        pig.performDecidedAction();
        pig.thinkAbout(donkey);
        pig.thinkMore(donkey);
        pig.decideToDoSmthg(new CollectFlowersAction(donkey, 5));
        pig.performDecidedAction();
    }
}
