
/**
 * Write a description of class Ball here.
 *
 * @author Gary Jackson
 * @version 10/13
 */
public class Ball extends GameObject implements Position
{
    private Ellipse ball;
    private int[] direction = {1,1};
    
    public Ball(int x, int y, int diameter, Color color)
    {
        this.setXPos(x);
        this.setYPos(y);
        Ellipse newBall = new Ellipse(x,y,diameter,diameter);
        ball = newBall;
        newBall.setColor(color);
        newBall.fill();
    }
    
    public void update(){
        try
        {
            Thread.sleep(9);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
        if(this.getXPos()>=Game.maxX || this.getXPos()<1) {
            if(direction[0]==1) {
                direction[0] = -1;
            } else {
                direction[0] = 1;
            }
        }
        if(this.getYPos()>=Game.maxY || this.getYPos()<1) {
            if(direction[1]==1) {
                direction[1] = -1;
            } else {
                direction[1] = 1;
            }
        }
        this.setXPos(this.getXPos()+direction[0]);
        this.setYPos(this.getYPos()+direction[1]);
        ball.translate(direction[0],direction[1]);
        ball.fill();
        return;
    }
}
