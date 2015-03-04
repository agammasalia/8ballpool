import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pocket extends Actor
{
    private int radius;

    public Pocket(int radius)
    {
        this.radius = radius;
        GreenfootImage circle = new GreenfootImage(2*radius, 2*radius);
        circle.setColor(java.awt.Color.BLACK);
        circle.fillOval(0, 0, 2*radius, 2*radius);
        setImage(circle);
    }

    public void act() 
    {
        for (Ball b : (java.util.List<Ball>)getWorld().getObjects(Ball.class))
        {            
            if (Math.hypot(b.getX() - getX(), b.getY() - getY()) <= radius)
            {
                getWorld().removeObject(b);
            }
        }
    }
}
