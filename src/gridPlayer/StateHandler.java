package gridPlayer;

import java.util.List;
import java.util.Map;

/**
 * An abstract class if extended will integrate the GridPlayer into the game and give it
 * access to the state
 */
public abstract class StateHandler {

    private StateObserver observer;

    public void setObserver(StateObserver observer){
        System.out.println("SETTING OBSERVER");
        this.observer = observer;
    }

    public boolean isObserverSet(){
        if(observer!=null){
            return true;
        } else {
            return false;
        }
    }

    public abstract Location getCurrentLoc();

    public abstract Location getCurrentGoal();

    public abstract Map<Location, List<Location>> getValidMoveList();

    public void updateNotify(){
        observer.runNotify();
    }

    public void updateSuccess() {observer.notifySuccess(); }

}
