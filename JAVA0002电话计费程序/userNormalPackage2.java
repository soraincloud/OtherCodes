package problem5;

public class userNormalPackage2 extends userNormal
{
    public userNormalPackage2(String p,double i,double c,int m)
    {
        super(p,i,c,m);
    }
    public double payment()
    {
        pay += 50;
        if(internet > 20)
        {
            internet -= 20;
            pay += internet;
        }
        if(call > 200)
        {
            call -= 200;
            pay += call * 0.5;
        }
        if(message > 200)
        {
            message -= 200;
            pay += message * 0.3;
        }
        return pay;
    }
}
