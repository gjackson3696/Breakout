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
        this.setWidth(width);
        this.setHeight(height);
        Rectangle newPaddle = new Rectangle(x,y,width,height);
        paddle = newPaddle;
        newPaddle.setColor(color);
        newPaddle.fill();
    }
    
    public int update() {
        int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX()-120;
        if(mouseX>0 && mouseX+this.getWidth()<Game.maxX) {
            this.move(mouseX,this.getXPos());
            this.setXPos(mouseX);
        }
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
    private boolean testBounds(int aMin, int aMax, int bMin, int bMax) {
        if(bMin >= aMin) {
            if(bMin <= aMax) {
                return true;
            }
        } else if(bMax >= aMin) {
            if(bMax <= aMax) {
                return true;
            }
        }
        return false;
    }

    public int detectCollision2(GameObject ball) {
        int ballCenter = ball.getXPos() + (ball.getWidth()/2);
        if(ballCenter >= this.getXPos()) {
            if(ballCenter <= this.getXPos()+this.getWidth()) {
                return 1;
            }
        }
        return 0;
    }
    public int detectCollision(GameObject ball)  {
        int[] ballBounds = {ball.getXPos(), ball.getXPos()+ball.getWidth(),
            ball.getYPos()+ball.getHeight()};
        if(ballBounds[2] >= 500) {
            if(testBounds(this.getXPos(),this.getXPos()+this.getWidth(),ballBounds[0],ballBounds[1])) {
                return 1;
            } else {
                return 2;
            }
        }
        return 0;
    }
}
