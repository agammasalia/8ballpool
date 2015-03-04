import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class StripeBall extends Ball
{
    int radius = 25;
    protected Ball decoratedBall;
    public StripeBall()
    {
    }

    public StripeBall(Ball decoratedBall)
    {
        this.decoratedBall = decoratedBall;
    }

    public Color draw()
    {
        Color c = decoratedBall.draw();
        GreenfootImage img = new GreenfootImage(radius * 2 + 1, radius * 2 + 1);
        img.setColor(new Color(255, 255, 255));
        img.fillOval(0, 0, 2*radius, 2*radius);
        img.setColor(c);
        img.fillRect(radius-7, 0, radius-10, radius*2);
        setImage(img);
        return null;
    }

    public void act() 
    {
        
    }
}
