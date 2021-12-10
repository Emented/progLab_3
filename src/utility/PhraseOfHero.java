package utility;

public enum PhraseOfHero {
    First("Иа, фиалки"), Second("Фиалки, Иа-Иа");

    private final String phrase;

    PhraseOfHero(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[phrase:" + phrase + "]";
    }
}
