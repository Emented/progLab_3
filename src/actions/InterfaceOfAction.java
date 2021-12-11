package actions;

import heroes.Pyatachok;

public interface InterfaceOfAction {
    void tellAboutDecision(Pyatachok teller);

    void performAction(Pyatachok performer);
}
