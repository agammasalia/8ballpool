import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RoundWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoundWall extends Wall
{
    private int radius;

    public RoundWall(int radius)
    {
        this.radius = radius;
        GreenfootImage big = getImage();
        
        int left = Greenfoot.getRandomNumber(big.getWidth() - 2*radius);
        int top = Greenfoot.getRandomNumber(big.getHeight() - 2*radius);
        
        GreenfootImage small = new GreenfootImage(2 * radius, 2 * radius);
        
        // Copy out a circle:
        for (int x = 0; x < 2 * radius; x++)
        {
            for (int y = 0; y < 2 * radius; y++)
            {
                if (Math.hypot(x - radius, y - radius) <= radius)
                {
                    small.setColorAt(x, y, big.getColorAt(left + x, top + y));
                }
            }
        }
        
        setImage(small);
    }

    public boolean intersectsCircle(double x, double y, int radius)
    {
        return Math.hypot(getX() - x, getY() - y) <= radius + this.radius;
    }
    
    public int getNormalAngle(double x, double y, int radius)
    {
        return (int)Math.toDegrees(Math.atan2(y - getY(), x - getX()));
    }  
}
