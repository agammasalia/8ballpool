import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HorizontalWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HorizontalWall extends StraightWall
{
    public HorizontalWall(int width, int height)
    {
        super(width, height);
    }

    public boolean intersectsCircle(double x, double y, int radius)
    {
        int halfWidth = getImage().getWidth() / 2;
        int halfHeight = getImage().getHeight() / 2;
        return x + radius >= getX() - halfWidth && x - radius <= getX() + halfWidth &&
               !(y + radius <= getY() - halfHeight || y - radius >= getY() + halfHeight);
    }
    
    public int getNormalAngle(double x, double y, int radius)
    {
        return 90;
    }
}
