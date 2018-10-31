package gridPlayer;

/**
 * A simple observer interface to integrade GridPlayer with the libGDX game 
 */
public interface StateObserver {
    public void runNotify();
    public void notifySuccess();
}
