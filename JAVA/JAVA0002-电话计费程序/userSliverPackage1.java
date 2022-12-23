package problem5;

public class userSliverPackage1 extends userSliver
{
    public userSliverPackage1(String p,double i,double c,int m)
    {
        super(p,i,c,m);
    }
    public double payment()
    {
        pay += 30 * 0.9;
        if(internet > 10)
        {
            internet -= 10;
            pay += internet * 0.6;
        }
        if(call > 100)
        {
            call -= 100;
            pay += call * 0.3;
        }
        if(message > 100)
        {
            message -= 100;
            pay += message * 0.2;
        }
        return pay;
    }
}
