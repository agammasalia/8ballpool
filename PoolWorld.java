import greenfoot.*;
import java.awt.Color;
import java.util.*;

public class PoolWorld extends World
{
    public PoolWorld()
    {    
        super(800, 600, 1, false);
        BallFactory ballFactory = new BallFactory();

        Ball solidYellow = ballFactory.getBall("SOLID YELLOW");
        solidYellow.draw();
        addObject(solidYellow, 500, 300);

        Ball stripeYellow = ballFactory.getBall("STRIPE YELLOW");
        stripeYellow.draw();
        addObject(stripeYellow, 640, 327);

        Ball solidBlue = ballFactory.getBall("SOLID BLUE");
        solidBlue.draw();
        addObject(solidBlue, 593, 246);

        Ball stripeBlue = ballFactory.getBall("STRIPE BLUE");
        stripeBlue.draw();
        addObject(stripeBlue, 687, 408);

        Ball solidRed = ballFactory.getBall("SOLID RED");
        solidRed.draw();
        addObject(solidRed, 687, 246);

        Ball stripeRed = ballFactory.getBall("STRIPE RED");
        stripeRed.draw();
        addObject(stripeRed, 687, 192);

        Ball solidPurple = ballFactory.getBall("SOLID PURPLE");
        solidPurple.draw();
        addObject(solidPurple, 640, 273);

        Ball stripePurple = ballFactory.getBall("STRIPE PURPLE");
        stripePurple.draw();
        addObject(stripePurple, 687, 300);

        Ball solidOrange = ballFactory.getBall("SOLID ORANGE");
        solidOrange.draw();
        addObject(solidOrange, 687, 354);

        Ball stripeOrange = ballFactory.getBall("STRIPE ORANGE");
        stripeOrange.draw();
        addObject(stripeOrange, 546, 273);

        Ball solidGreen = ballFactory.getBall("SOLID GREEN");
        solidGreen.draw();
        addObject(solidGreen, 640, 381);

        Ball stripeGreen = ballFactory.getBall("STRIPE GREEN");
        stripeGreen.draw();
        addObject(stripeGreen, 593, 354);

        Ball solidBrown = ballFactory.getBall("SOLID BROWN");
        solidBrown.draw();
        addObject(solidBrown, 546, 327);

        Ball stripeBrown = ballFactory.getBall("STRIPE BROWN");
        stripeBrown.draw();
        addObject(stripeBrown, 640, 219);

        Ball whiteBall = ballFactory.getBall("WHITE");
        whiteBall.draw();
        addObject(whiteBall, 100, 300);

        Ball blackBall = ballFactory.getBall("BLACK");
        blackBall.draw();
        addObject(blackBall, 593, 300);

        addVerticalWalls(540, 300);
        addHorizontalWalls(465, 250);
        addHorizontalWalls(465, 585);
        addObject(new Pocket(40), 0, 0);
        addObject(new Pocket(40), 800, 0);
        addObject(new Pocket(40), 800, 600);
        addObject(new Pocket(40), 0, 600);
        addObject(new Pocket(40), 400, -15);
        addObject(new Pocket(40), 400, 615);
    }

    private void addVerticalWalls(int height, int centre)
    {
        addObject(new RoundWall(20), 0, centre - (height / 2));
        addObject(new VerticalWall(20, height), 10, centre);
        addObject(new RoundWall(20), 0, centre + (height / 2));    

        addObject(new RoundWall(20), 800, centre - (height / 2));
        addObject(new VerticalWall(20, height), 790, centre);
        addObject(new RoundWall(20), 800, centre + (height / 2));        
    }

    private void addHorizontalWalls(int width, int centre)
    {
        addObject(new RoundWall(20), centre - (width / 2), 0);
        addObject(new HorizontalWall(width, 20), centre, 10);
        addObject(new RoundWall(20), centre + (width / 2), 0);

        addObject(new RoundWall(20), centre - (width / 2), 600);
        addObject(new HorizontalWall(width, 20), centre, 590);
        addObject(new RoundWall(20), centre + (width / 2), 600);        
    }

    public void act()
    {
        //List balllll = (java.util.List<Ball>)getObjects(Ball.class);
        //for(int i = 0; i<balllll.size(); i++)
        //    System.out.println(balllll.get(i));
        for (Ball b : (java.util.List<Ball>)getObjects(Ball.class))
        {
//             System.out.println(b);
            applyFriction(b);
        }
        
        boolean playBall = false;
        boolean playWall = false;
        
        boolean altered = true;
        while (altered)
        {
            altered = false;
            for (Ball b : (java.util.List<Ball>)getObjects(Ball.class))
            {
                boolean ball = collideBalls(b);
                boolean wall = collideWalls(b);
                altered |= ball | wall;
                playBall |= ball;
                playWall |= wall;
            }
        }
        
        if (playBall)
        {
            Greenfoot.playSound("click.wav");
        }
        if (playWall)
        {
            Greenfoot.playSound("tock-quiet.wav");
        }
    }
    
    public void applyFriction(Ball b)
    {
        double vx = b.getMoveX() * 0.99;
        double vy = b.getMoveY() * 0.99;
        if (Math.hypot(vx, vy) < 0.05)
        {
            b.setMove(0, 0);
        }
        else
        {
            b.setMove(vx, vy);
        }
    }
    
    public boolean collideWalls(Ball b)
    {
        double newX = b.getNewX();
        double newY = b.getNewY();
        
        double vx = b.getMoveX();
        double vy = b.getMoveY();
        
        boolean bounced = false;
        
        for (Wall w : (java.util.List<Wall>)getObjects(Wall.class))
        {
        
            if (w.intersectsCircle((int)newX, (int)newY, b.getRadius()))
            {
                //Bounce:
                double angle = Math.toDegrees(Math.atan2(vy, vx));
                angle = 2 * w.getNormalAngle((int)newX, (int)newY, b.getRadius()) - 180 - angle;
                double mag = 0.9 * Math.hypot(vx, vy);
                
                vx = Math.cos(Math.toRadians(angle)) * mag;
                vy = Math.sin(Math.toRadians(angle)) * mag;
                bounced = true;
                break; // Make sure we don't double bounce where walls join
            }
        }
        
        if (bounced)
        {
            b.setMove(vx, vy);
        }
        
        return bounced;
    }
    
    // Returns true if moveX or moveY was altered
    public boolean collideBalls(Ball b)
    {
        if (b.getMoveX() == 0 && b.getMoveY() == 0)
            return false; //stationary ball
        
        double newX = b.getNewX();
        double newY = b.getNewY();
        
        for (Ball c : (java.util.List<Ball>)getObjects(Ball.class))
        {
            if (c == b){
                continue; // Don't collide with yourself
            }

            double distX = c.getNewX() - newX;
            double distY = c.getNewY() - newY;
            double dist = Math.sqrt(distX * distX + distY * distY);
            if (dist <= b.getRadius() + c.getRadius())
            {
                // distX, distY is normal
                
                distX = distX / dist;
                distY = distY / dist;
                
                double towardsThem = distAlong(b.getMoveX(), b.getMoveY(), distX, distY);
                double towardsMe = distAlong(c.getMoveX(), c.getMoveY(), distX, distY);
                
                double myOrtho = distAlong(b.getMoveX(), b.getMoveY(), distY, -distX);
                double theirOrtho = distAlong(c.getMoveX(), c.getMoveY(), distY, -distX);
                System.out.println("B"+b);
                System.out.println("C"+c);
                b.setMove(towardsMe * distX + myOrtho * distY, towardsMe * distY + myOrtho * -distX);
                c.setMove(towardsThem * distX + theirOrtho * distY, towardsThem * distY + theirOrtho * -distX);
                
                return true;
            }
        }
        return false;
    }
    
    private double distAlong(double x, double y, double xAlong, double yAlong)
    {
        return (x * xAlong + y * yAlong) / Math.hypot(xAlong, yAlong);
    }
}
