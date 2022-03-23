import java.awt.MouseInfo;
import java.lang.Math;
/**
 * Write a description of class Paddle here.
 *
 * @author Gary Jackson
 * @version 10/13
 */
public class Paddle extends GameObject implements Position
{
    private Rectangle paddle;
    
    public Paddle(int x, int y, int width, int height, Color color)
    {
        this.setXPos(x);
        this.setYPos(y);
        Rectangle newPaddle = new Rectangle(x,y,width,height);
        paddle = newPaddle;
        newPaddle.setColor(color);
        newPaddle.fill();
    }
    
    public int update() {
        int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX()-120;
        this.move(mouseX,this.getXPos());
        this.setXPos(mouseX);
        return mouseX;
        /**
         * Attempting to make a method to update the position of the paddle.
         */
    }
    private void move(double newX, double oldX) {
        if(newX<1000) {
            paddle.translate(newX-oldX,0.0);
            paddle.fill();
        }
    }
}
