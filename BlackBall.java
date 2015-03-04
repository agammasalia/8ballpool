import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class BlackBall extends Ball
{
    int radius = 25;
    protected Ball decoratedBall;
    public BlackBall()
    {
    }

    public BlackBall(Ball decoratedBall)
    {
        this.decoratedBall = decoratedBall;
    }

    public Color draw()
    {
        Color c = new Color(0, 0, 0);
        GreenfootImage img = new GreenfootImage(radius * 2 + 1, radius * 2 + 1);
        img.setColor(c);
        img.fillOval(0, 0, 2*radius, 2*radius);
        setImage(img);
        return null;
    }

    public void act() 
    {
        super.act();
    }

}
