/**
 * BackEnd for the String compare app
 * User: Robin
 * Date: 1/22/13
 * Time: 1:57 AM
 */
public class BackEnd {
    private String first;
    private String second;

    public BackEnd()
    {
        first=null;
        second=null;
    }

    //Get Operations
    public String getFirst ()
    {
        return first;
    }

    public String getSecond ()
    {
        return second;
    }

    //Compare Methods
    public boolean CompareIgnoreCase()
    {
        //Check to make sure not null
        if (((first!=null) && first.length()>0) && ((second!=null) && second.length()>0))
        {
            //Ignoring case since LDAP is case insensitive
            return first.equalsIgnoreCase(second);
        }
        return false;
    }

    public boolean Compare()
    {
        //Check to make sure not null
        if (((first!=null) && first.length()>0) && ((second!=null) && second.length()>0))
        {
            //case sensitive
            return first.equals(second);
        }
        return false;
    }

    //Set Methods
    public void setFirstString (String f)
    {
        first=f;
    }

    public void setSecondString (String s)
    {
        second=s;
    }

}
