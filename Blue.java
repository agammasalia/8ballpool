import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class Blue extends BallDecorator
{
    public Blue()
    {
    }

    public Blue(Ball decoratedBall)
    {
        super(decoratedBall);
    }

    public Color draw() 
    {
        return new Color(0, 0 ,255);
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
