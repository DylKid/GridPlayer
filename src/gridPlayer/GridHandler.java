package gridPlayer;

/**
 * Implement this interface to allow the GridPlayer to interact with your game
 */
public interface GridHandler {

    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();
    public int getHeight();
    public int getWidth();

}
