
/**
 * Abstract class GameObject - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class GameObject implements Position, CollisionDetection
{
    // instance variables - replace the example below with your own
    private int xPos;
    private int yPos;

    public int getXPos()
    {
        return xPos;
    }
    public int getYPos()
    {
        return yPos;
    }
    public int setXPos(int x)
    {
        int oldX = xPos;
        xPos = x;
        return oldX;
    }
    public int setYPos(int y)
    {
        int oldY = yPos;
        yPos = y;
        return oldY;
    }
    public int[] getPosition()
    {
        int[] pos = {xPos,yPos};
        return pos;
    }
    public int[] setPosition(int x, int y)
    {
        int[] oldPos = {xPos,yPos};
        xPos = x;
        yPos = y;
        return oldPos;
    }
    public int detectCollision(GameObject objA, GameObject objB)
    {
        return 0;
    }
}
