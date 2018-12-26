
/**
 * Write a description of class Lecturer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lecturer extends Staff
{
    public Lecturer(java.lang.String name,
                java.lang.String department,
                int basicSalary)
    {
        super(name,department);
        super.basicSalary = basicSalary;
        super.uniqueId=generateId().toString();
        number++;
    }
    
    public int getSalary()
    {
        int Lecturer_salary = super.basicSalary + (super.basicSalary*30)/100+ (super.basicSalary*100)/100;
        return Lecturer_salary;
    }
    
    public java.lang.StringBuilder createRecord()
    {
        StringBuilder str = new StringBuilder();
         str.append("Lecturer:"+name+":"+super.uniqueId+":"+department+":"+getSalary()+"\n");
         return str;
    }
    
}
