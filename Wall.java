
/**
 * Write a description of class Wall here.
 *
 * @author Gary Jackson
 * @version V3
 */
public class Wall
{
    private Brick[][] wall;
    private int numBricks;
    private int columns;
    private int rows;
    private int brickWidth;
    private int brickHeight;
    private int yBounds;
    private int marchingTimer;
    private int marchingTimerLimit = 1000;

    /**
     * Constructor for objects of class Wall
     */
    public Wall(int numColumns, int numRows, Color color)
    {
        marchingTimer = 0;
        columns = numColumns;
        rows = numRows;
        numBricks = columns*rows;
        wall = new Brick[columns][rows];
        brickWidth = Game.maxX/columns;
        brickHeight = brickWidth/3;
        yBounds = brickHeight*rows;
        for(int i=0; i<rows; i++) {
            int y = i*brickHeight;
            for(int j=0; j<columns; j++) {
                int x = j*brickWidth;
                wall[j][i] = new Brick(x,y,brickWidth,brickHeight,color);
            }
        }
    }
    
    public int update() {
        if(marchingTimer < marchingTimerLimit) {
            marchingTimer++;
        } else {
            marchingTimer = 0;
            for(Brick[] brickArray : wall) {
                for(Brick brick : brickArray) {
                    brick.march();
                }
            }
        }
        return 1;
    }
    public int detectCollision(GameObject ball) {
        if(ball.getYPos() <= yBounds) {
            int row = (ball.getXPos()/brickWidth);
            int column = (ball.getYPos()/brickHeight)-1;
            if(column < 0) {
                column = 0;
            }
            if(wall[row][column] != null) {
                return ball.detectCollision(wall[row][column]);
                //return wall[row][column].detectCollision(ball);
            }
        }
        return 0;
    }
    public int detectCollision2(GameObject ball) {
        return 0;
    }
}
