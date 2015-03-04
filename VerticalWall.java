import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VerticalWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VerticalWall extends StraightWall
{
    public VerticalWall(int width, int height)
    {
        super(width, height);
    }

    public boolean intersectsCircle(double x, double y, int radius)
    {
        int halfWidth = getImage().getWidth() / 2;
        int halfHeight = getImage().getHeight() / 2;
        return y + radius >= getY() - halfHeight && y - radius <= getY() + halfHeight &&
               !(x + radius <= getX() - halfWidth || x - radius >= getX() + halfWidth);
    }
    
    public int getNormalAngle(double x, double y, int radius)
    {
        return 0;
    }
}
