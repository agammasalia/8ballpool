import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public abstract class BallDecorator extends Ball
{
    int radius = 25;
    private double moveX;
    private double moveY;
    protected Ball decoratedBall;
    public BallDecorator()
    {
    }

    public BallDecorator(Ball decoratedBall)
    {
        this.decoratedBall = decoratedBall;
    }

    public Color draw()
    {
        decoratedBall.draw();
        return null;
    }

    public void act() 
    {
        setExactLocation(getExactX() + moveX, getExactY() + moveY);
    }
    
    protected double getMoveX() { return moveX; }
    protected double getMoveY() { return moveY; }
    
    public double getNewX() { return getExactX() + getMoveX(); }
    public double getNewY() { return getExactY() + getMoveY(); }
    
    // If they are both close enough to zero, will be set to zero
    protected void setMove(double vx, double vy)
    {
        moveX = vx;
        moveY = vy;
    }
    
    public String toString()
    {
        return getClass().toString() + " @ (" + getExactX() + ", " + getExactY() + ")";
    }

}
