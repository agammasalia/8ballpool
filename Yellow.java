import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Yellow extends BallDecorator
{
    double moveX;
    double moveY;

    public Yellow()
    {
    }

    public Yellow(Ball decoratedBall)
    {
        super(decoratedBall);
    }

    public Color draw() 
    {
        return new Color(255, 255 ,0);
    }

    public void act() 
    {
        setExactLocation(getExactX() + moveX, getExactY() + moveY);
    }

    protected double getMoveX()
    {
        return moveX;
    }

    protected double getMoveY()
    {
        return moveY;
    }


}
