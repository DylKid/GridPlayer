package gridPlayer;

/**
 * A simple observer interface to integrade GridPlayer with the libGDX game 
 */
public interface StateObserver {
    /**
     * Call this to run another step in the GridPlayer search
     */
    public void runNotify();

    /**
     * Call this to notify the GridPlayer of success
     */
    public void notifySuccess();
}
