package problem5;

public class userNormalPackage1 extends userNormal
{
    public userNormalPackage1(String p,double i,double c,int m)
    {
        super(p,i,c,m);
    }
    public double payment()
    {
        pay += 30;
        if(internet > 10)
        {
            internet -= 10;
            pay += internet;
        }
        if(call > 100)
        {
            call -= 100;
            pay += call * 0.5;
        }
        if(message > 100)
        {
            message -= 100;
            pay += message * 0.3;
        }
        return pay;
    }
}
