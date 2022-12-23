package problem5;

public class userGold extends user
{
    public userGold(String p,double i,double c,int m)
    {
        super(p,i,c,m);
    }
    public double payment()
    {
        pay += internet * 0.4;
        pay += call * 0.2;
        pay += message * 0.1;
        return pay;
    }
}
