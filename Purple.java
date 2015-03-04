import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Purple extends BallDecorator
{
    public Purple()
    {
    }

    public Purple(Ball decoratedBall)
    {
        super(decoratedBall);
    }

    public Color draw() 
    {
        return new Color(85, 10 ,150);
    }

    public void act() 
    {
        super.act();
        MouseInfo info = Greenfoot.getMouseInfo();
        if (info != null && Greenfoot.mouseClicked(null))
        {
            double angle = Math.atan2(info.getY() - getY(), info.getX() - getX());
            double cueSpeed = 8;
            setMove(Math.cos(angle) * cueSpeed, Math.sin(angle) * cueSpeed);
        }
    }
}
