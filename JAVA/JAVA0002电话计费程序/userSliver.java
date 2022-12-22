package problem5;

public class userSliver extends user
{
    public userSliver(String p,double i,double c,int m)
    {
        super(p,i,c,m);
    }
    public double payment()
    {
        pay += internet * 0.6;
        pay += call * 0.3;
        pay += message * 0.2;
        return pay;
    }
}