import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class SolidBall extends Ball
{
    int radius = 25;
    protected Ball decoratedBall;
    public SolidBall()
    {
    }

    public SolidBall(Ball decoratedBall)
    {
        this.decoratedBall = decoratedBall;
    }

    public Color draw()
    {
        Color c = decoratedBall.draw();
        GreenfootImage img = new GreenfootImage(radius * 2 + 1, radius * 2 + 1);
        img.setColor(c);
        img.fillOval(0, 0, 2*radius, 2*radius);
        setImage(img);
        return null;
    }

    public void act() 
    {
    }
}
