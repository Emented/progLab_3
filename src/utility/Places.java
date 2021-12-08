package utility;

import java.util.Objects;

public enum Places {
    HomeOfPyatachek ("дом пяточка", true),
    HomeOfDonkey ("дом осла Иа", true),
    Vase ("ваза", false),
    Yard ("двор", true),
    Field ("лужайка", true);

    private final boolean possibileToGetInside;
    private final String name;

    Places(String name, boolean possibileToGetInside) {
        this.name = name;
        this.possibileToGetInside = possibileToGetInside;
    }

    public boolean isPossibilityToGetInside() {
        return this.possibileToGetInside;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[place:" + name + "]";
    }
}
