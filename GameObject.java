
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
    private int height;
    private int width;

    public int getXPos()
    {
        return xPos;
    }
    public int getYPos()
    {
        return yPos;
    }
    public int getHeight()
    {
        return height;
    }
    public int getWidth()
    {
        return width;
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
    public void setHeight(int h)
    {
        height = h;
    }
    public void setWidth(int w)
    {
        width = w;
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
    public int detectCollision(GameObject object)
    {
        return 0;
    }
}
