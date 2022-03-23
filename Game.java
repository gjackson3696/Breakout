
/**
 * Write a description of class Game here.
 *
 * @author Gary Jackson
 * @version 10/13
 */
public class Game
{
    public static final int maxX = 1000;
    public static final int maxY = 500;
    private Field playingField;
    private Wall wall;
    private Paddle paddle;
    private Ball ball;

    public Game() throws InterruptedException
    {
        playingField = new Field();
        while (playingField.update()) {
            playingField.update();
        }
    }

    public int sampleMethod(int y)
    {
        return 0;
    }
}
