package gridPlayer;

/**
 * Implement this interface to allow the GridPlayer to interact with your game
 */
public interface GridHandler {

    /**
     * Move the player character up
     */
    public void moveUp();

    /**
     * Move the player character down
     */
    public void moveDown();

    /**
     * Move the player character left
     */
    public void moveLeft();

    /**
     * Move the player character right
     */
    public void moveRight();

    /**
     * @return The height of the grid
     */
    public int getHeight();

    /**
     * @return The width of the grid
     */
    public int getWidth();

}
