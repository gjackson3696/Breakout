
/**
 * Write a description of class Ball here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ball extends GameObject implements Position
{    
    public Ball(int x, int y, int width, int height, Color color)
    {
        this.setXPos(x);
        this.setYPos(y);
        Ellipse ball = new Ellipse(x,y,width,height);
        ball.setColor(color);
        ball.fill();
    }
}
