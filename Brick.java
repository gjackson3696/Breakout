/**
 * Write a description of class Brick here.
 *
 * @author Gary Jackson
 * @version 10/13
 */
public class Brick extends GameObject
{
    private Rectangle brick;
    private boolean active;
    private int marchDistance = 10;

    /**
     * Constructor for objects of class Brick
     */
    public Brick(int x, int y, int width, int height, Color color)
    {
        this.setXPos(x);
        this.setYPos(y);
        this.setWidth(width);
        this.setHeight(height);
        active = true;
        Rectangle newBrick = new Rectangle(x,y,width,height);
        brick = newBrick;
        newBrick.setColor(color);
        newBrick.draw();
        newBrick.fill();
    }
    
    public int detectCollision(GameObject object) {
        if(active) {
            int[] objectBounds = {object.getXPos(), object.getXPos()+object.getWidth(),
                object.getYPos(), object.getYPos()+object.getHeight()};
            if(testBounds(this.getXPos(),this.getXPos()+this.getWidth(),objectBounds[0],objectBounds[1])) {
                if(testBounds(this.getYPos(),this.getYPos()+this.getHeight(),objectBounds[2],objectBounds[3])) {
                    this.destroyBrick();
                    return 1;
                }
            }
        }
        return 0;
    }
    public int detectCollision2(GameObject object) {
        if(active) {
            int[] objectBounds = {object.getXPos(), object.getXPos()+object.getWidth(),
                object.getYPos(), object.getYPos()-object.getHeight()};
        }
        return 0;
    }
    public boolean isActive() {
        return active;
    }
    public boolean march() {
        brick.translate(0,marchDistance);
        brick.fill();
        return true;
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
    private boolean testBounds2() {
        return false;
    }
    private void destroyBrick() {
        active = false;
        brick.setColor(Color.WHITE);
        brick.fill();
    }
}
