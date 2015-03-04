import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Wall extends Actor
{
    public abstract boolean intersectsCircle(double x, double y, int radius);
    
    public abstract int getNormalAngle(double x, double y, int radius);

}
