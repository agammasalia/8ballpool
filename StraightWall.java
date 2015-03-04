import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StraightWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class StraightWall extends Wall
{
    public StraightWall(int width, int height)
    {
        GreenfootImage big = getImage();
        
        int left = Greenfoot.getRandomNumber(big.getWidth() - width);
        int top = Greenfoot.getRandomNumber(big.getHeight() - height);
        
        GreenfootImage small = new GreenfootImage(width, height);
        
        small.drawImage(big, -left, -top);
        
        setImage(small);
    }
}
