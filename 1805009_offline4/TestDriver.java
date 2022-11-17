import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
public class TestDriver{ 
    gradecalc obj;
    @Before
    public void initialize()
    {obj=new gradecalc();
    }

    @Test
    public void test_for_mark_to_test_each_grade()
    {
        assertEquals("A",obj.grade(300,3));
        assertEquals("B",obj.grade(220,3));
        assertEquals("C",obj.grade(195,3));
        assertEquals("F",obj.grade(150,3));
        assertEquals("A",obj.grade(350,4));
        assertEquals("B",obj.grade(290,4));
        assertEquals("C",obj.grade(250,4));
        assertEquals("F",obj.grade(200,4));
    }
    @Test
    public void test_for_boundary_values_for_each_grade()
    {
        assertEquals("A",obj.grade(239.5,3));
        assertEquals("A",obj.grade(400,4));
        assertEquals("B",obj.grade(209.4,3));
        assertEquals("B",obj.grade(239,3));
        assertEquals("C",obj.grade(179.00001,3));
        assertEquals("C",obj.grade(209,3));
        assertEquals("F",obj.grade(179,3));
        assertEquals("F",obj.grade(0,3));
        assertEquals("A",obj.grade(319.001,4));
        assertEquals("A",obj.grade(400,4));
        assertEquals("B",obj.grade(279.8,4));
        assertEquals("B",obj.grade(319,4));
        assertEquals("C",obj.grade(239.6,4));
        assertEquals("C",obj.grade(279,4));
        assertEquals("F",obj.grade(239,4));
        assertEquals("F",obj.grade(0,4));
    }
    @Test
    public void test_for_invalid_numbers_that_exceed_lower_and_upper_bound()
    {
        assertEquals("invalid marks not between 0-400",obj.grade(400.5,3));
        assertEquals("invalid marks not between 0-400",obj.grade(420,3));
        assertEquals("invalid marks not between 0-400",obj.grade(-0.5,3));
        assertEquals("invalid marks not between 0-400",obj.grade(-10,3));
        assertEquals("invalid marks not between 0-400",obj.grade(400.5,4));
        assertEquals("invalid marks not between 0-400",obj.grade(420,4));
        assertEquals("invalid marks not between 0-400",obj.grade(-0.5,4));
        assertEquals("invalid marks not between 0-400",obj.grade(-10,4));
       
    }
    @Test
    public void test_for_non_number_input()
    {
        assertEquals("Not a number,marks and credit should be number",obj.grade("sas333",3));
        assertEquals("Not a number,marks and credit should be number",obj.grade("121eee",4));
    }
    @Test
    public void test_for_invalid_credit()
    {
        assertEquals("invalid credit, not 3 or 4",obj.grade(300,0));
        assertEquals("invalid credit, not 3 or 4",obj.grade(300,-2));
        assertEquals("Not a number,marks and credit should be number",obj.grade(320,"e22"));
    }
    @Test
    public void test_for_too_many_digits_after_decimal_point()
    {
        assertEquals("too many digits after decimal point",obj.grade(239.000000001,3));
    }
}