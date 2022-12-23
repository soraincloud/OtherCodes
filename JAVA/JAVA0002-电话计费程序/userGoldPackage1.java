package problem5;

public class userGoldPackage1 extends userGold
{
    public userGoldPackage1(String p,double i,double c,int m)
    {
        super(p,i,c,m);
    }
    public double payment()
    {
        pay += 30 * 0.8;
        if(internet > 10)
        {
            internet -= 10;
            pay += internet * 0.4;
        }
        if(call > 100)
        {
            call -= 100;
            pay += call * 0.2;
        }
        if(message > 100)
        {
            message -= 100;
            pay += message * 0.1;
        }
        return pay;
    }
}
