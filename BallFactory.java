public class BallFactory
{
    public Ball getBall(String ballType){
        if(ballType == null){
            return null;
        }

        if(ballType.equalsIgnoreCase("SOLID YELLOW"))
        {
            return new SolidBall(new Yellow());
        }
        else if(ballType.equalsIgnoreCase("STRIPE YELLOW"))
        {
            return new StripeBall(new Yellow());
        }
        else if(ballType.equalsIgnoreCase("SOLID BLUE"))
        {
            return new SolidBall(new Blue());
        }
        else if(ballType.equalsIgnoreCase("STRIPE BLUE"))
        {
            return new StripeBall(new Blue());
        }
        else if(ballType.equalsIgnoreCase("SOLID RED"))
        {
            return new SolidBall(new Red());
        }
        else if(ballType.equalsIgnoreCase("STRIPE RED"))
        {
            return new StripeBall(new Red());
        }
        else if(ballType.equalsIgnoreCase("SOLID PURPLE"))
        {
            return new SolidBall(new Purple());
        }
        else if(ballType.equalsIgnoreCase("STRIPE PURPLE"))
        {
            return new StripeBall(new Purple());
        }
        else if(ballType.equalsIgnoreCase("SOLID ORANGE"))
        {
            return new SolidBall(new Orange());
        }
        else if(ballType.equalsIgnoreCase("STRIPE ORANGE"))
        {
            return new StripeBall(new Orange());
        }
        else if(ballType.equalsIgnoreCase("SOLID GREEN"))
        {
            return new SolidBall(new Green());
        }
        else if(ballType.equalsIgnoreCase("STRIPE GREEN"))
        {
            return new StripeBall(new Green());
        }
        else if(ballType.equalsIgnoreCase("SOLID BROWN"))
        {
            return new SolidBall(new Brown());
        }
        else if(ballType.equalsIgnoreCase("STRIPE BROWN"))
        {
            return new StripeBall(new Brown());
        }
        else if(ballType.equalsIgnoreCase("WHITE"))
        {
            return new WhiteBall();
        }
        else if(ballType.equalsIgnoreCase("BLACK"))
        {
            return new BlackBall();
        }
        return null;
    }
}
