
/**
 * Write a description of class Staff here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Staff extends Person
{
    protected int basicSalary;
    
    public Staff(java.lang.String name,
             java.lang.String department)
    {
        super(name,department);
    }
    protected int getSalary()
    {
        return 0;
    }
}
