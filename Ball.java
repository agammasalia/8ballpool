import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public abstract class Ball extends Actor
{
    int radius;
    double x;
    double y;
    double moveX;
    double moveY;

    abstract public Color draw();

    protected void setMove(double vx, double vy)
    {
        moveX = vx;
        moveY = vy;
    }

    protected double getMoveX()
    {
        return moveX;
    }

    protected double getMoveY()
    {
        return moveY;
    }

    public double getNewX()
    {
        return getExactX() + getMoveX();
    }

    public double getNewY()
    {
        return getExactY() + getMoveY();
    }

    public void act()
    {
        setExactLocation(getExactX() + moveX, getExactY() + moveY);
    }

    public String toString()
    {
        return getClass().toString() + " @ (" + getExactX() + ", " + getExactY() + ")";
    }

    public int getRadius()
    {
        return radius;
    }

    public double getExactX()
    {
        return x;
    }

    public double getExactY()
    {
        return y;
    }

    public void setExactLocation(double x, double y)
    {
        this.x = x;
        this.y = y;
        super.setLocation((int)x, (int) y);
    }

    public void setLocation(int x, int y)
    {
        setExactLocation(x, y);
    }

}
