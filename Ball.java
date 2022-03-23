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
        this.setWidth(diameter);
        this.setHeight(diameter);
        Ellipse newBall = new Ellipse(x,y,diameter,diameter);
        ball = newBall;
        newBall.setColor(color);
        newBall.fill();
    }
    
    public void update(){
        try
        {
            Thread.sleep(8);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
        if(this.getXPos()+this.getWidth()>=Game.maxX || this.getXPos()<=0) {
            this.reverseXDirection();
        }
        if(this.getYPos()<1) {
            this.reverseYDirection();
        }
        this.setXPos(this.getXPos()+direction[0]);
        this.setYPos(this.getYPos()+direction[1]);
        ball.translate(direction[0],direction[1]);
        ball.fill();
        return;
    }
    
    public int detectCollision2(GameObject object) {
        if(this.getYPos()>=500) {
            if(object.detectCollision(this)==1) {
                this.reverseYDirection();
                return 1;
            } else {//,........43333333333333333333333333333e
                return 2;
            }
        } else if(object.detectCollision(this) != 0) {
            this.reverseYDirection();
            return object.detectCollision(this);
        }
        return 0;
    }
    public int detectCollision(GameObject object) {
        switch(object.detectCollision(this)) {
            case 1: this.reverseYDirection();
                    return 1;
            case 2: return 2;
        }
        return 0;
    }
    public int detectCollision3(GameObject object) {
        return 0;
    }
    
    private void reverseXDirection() {
        if(direction[0]==1) {
            direction[0] = -1;
        } else {
            direction[0] = 1;
        }
    }
    private void reverseYDirection() {
        if(direction[1]==1){
            direction[1] = -1;
        } else {
            direction[1] = 1;
        }
    }
}
