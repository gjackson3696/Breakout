import java.awt.MouseInfo;
/**
 * Write a description of class Field here.
 *
 * @author Gary Jackson
 * @version 8/25
 */
public class Field extends GameObject implements Position
{
    private Canvas canvas;
    private Brick brick;
    private Wall wall;
    private Paddle paddle;
    private Ball ball;
    private boolean playing;

    /**
     * Constructor for objects of class Field
     */
    public Field()
    {
        canvas = Canvas.getInstance();
        wall = new Wall(10,5,Color.BLUE);
        paddle = new Paddle(0,500,250,5,Color.GREEN);
        ball = new Ball(Game.maxX/2,Game.maxY/2,10,Color.RED);
        playing = true;
    }
    
    /**
     * Updates all objjects on the playing field.
     */
    public boolean update() {
        paddle.update();
        ball.update();
        wall.update();
        detectCollisions();
        canvas.repaint();
        return playing;
    }
    public Canvas getCanvas()
    {
        return canvas;
    }
    public int detectCollisions() {
        if(ball.detectCollision(paddle)==2) {
            playing = false;
            return 2;
        } else {
            wall.detectCollision(ball);
        }
        return 0;
    }
}
