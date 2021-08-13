
/**
 * Write a description of class Field here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Field extends GameObject implements Position
{
    private int x;
    private int y;
    private Canvas canvas;

    /**
     * Constructor for objects of class Field
     */
    public Field()
    {
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    public Canvas getCanvas()
    {
        return canvas;
    }
}
