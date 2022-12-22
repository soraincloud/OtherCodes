package problem5;

public class userNormal extends user
{
    public userNormal(String p,double i,double c,int m)
    {
        super(p,i,c,m);
    }
    public double payment()
    {
        pay += internet;
        pay += call * 0.5;
        pay += message * 0.3;
        return pay;
    }
}
