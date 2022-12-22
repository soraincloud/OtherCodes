package problem5;

public class userGoldPackage2 extends userGold
{
    public userGoldPackage2(String p,double i,double c,int m)
    {
        super(p,i,c,m);
    }
    public double payment()
    {
        pay += 50 * 0.8;
        if(internet > 20)
        {
            internet -= 20;
            pay += internet * 0.4;
        }
        if(call > 200)
        {
            call -= 200;
            pay += call * 0.2;
        }
        if(message > 200)
        {
            message -= 200;
            pay += message * 0.1;
        }
        return pay;
    }
}
