package problem5;

public class userSliverPackage2 extends userSliver
{
    public userSliverPackage2(String p,double i,double c,int m)
    {
        super(p,i,c,m);
    }
    public double payment()
    {
        pay += 50 * 0.9;
        if(internet > 20)
        {
            internet -= 20;
            pay += internet * 0.6;
        }
        if(call > 200)
        {
            call -= 200;
            pay += call * 0.3;
        }
        if(message > 200)
        {
            message -= 200;
            pay += message * 0.2;
        }
        return pay;
    }
}
