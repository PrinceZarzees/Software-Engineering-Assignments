public class gradecalc {
    public String grade(Object m,Object c)
    {
        try{ 
        double marks=Double.valueOf(m.toString());
        double credit=Double.valueOf(c.toString());
        if (marks>=0)
        marks=Math.ceil(marks);
        int temp=m.toString().indexOf('.');
        if (temp!=-1)
        {
            if(m.toString().length()-temp-1>8)
            return "too many digits after decimal point";
        }
        if (credit==3)
        {
            if (marks>=240 && marks<=400)
            return "A";
            else if (marks>=210 && marks<=239)
            return "B";
            else if (marks>=180 && marks<=209)
            return "C";
            else if (marks>=0 && marks<=179)
            return "F";

            return "invalid marks not between 0-400";
        }
        if (credit==4)
        {   
            if (marks>=320 && marks<=400)
            return "A";
            else if (marks>=280 && marks<=319)
            return "B";
            else if (marks>=240 && marks<=279)
            return "C";
            else if (marks>=0 && marks<=239)
            return "F";

            return "invalid marks not between 0-400";

        }
        return "invalid credit, not 3 or 4";
        }
        catch(Exception e)
        {
        return "Not a number,marks and credit should be number";
        }
        
    }
    
}
