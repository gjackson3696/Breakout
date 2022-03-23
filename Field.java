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
    private Paddle paddle;
    private Ball ball;

    /**
     * Constructor for objects of class Field
     */
    public Field()
    {
        canvas = Canvas.getInstance();
        paddle = new Paddle(0,500,25,5,Color.GREEN);
        ball = new Ball(50,50,5,Color.RED);
    }
    
    /**
     * Updates all objjects on the playing field.
     */
    public void update() {
        paddle.update();
        ball.update();
        canvas.repaint();
    }
    public Canvas getCanvas()
    {
        return canvas;
    }
}
