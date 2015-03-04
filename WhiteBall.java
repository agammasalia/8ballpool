import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class WhiteBall extends Ball
{
    int radius = 25;
    public double moveX;
    public double moveY;
    protected Ball decoratedBall;
    public WhiteBall()
    {
    }

    public WhiteBall(Ball decoratedBall)
    {
        this.decoratedBall = decoratedBall;
    }

    public Color draw()
    {
        Color c = new Color(255, 255, 255);
        GreenfootImage img = new GreenfootImage(radius * 2 + 1, radius * 2 + 1);
        img.setColor(c);
        img.fillOval(0, 0, 2*radius, 2*radius);
        setImage(img);
        return null;
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

    protected double getMoveX() { return moveX; }
    protected double getMoveY() { return moveY; }
    
    public double getNewX() { return getExactX() + getMoveX(); }
    public double getNewY() { return getExactY() + getMoveY(); }
    
    // If they are both close enough to zero, will be set to zero
    protected void setMove(double vx, double vy)
    {
        moveX = vx;
        moveY = vy;
    }
    
    public String toString()
    {
        return getClass().toString() + " @ (" + getExactX() + ", " + getExactY() + ")";
    }

}
