
/**
 * Write a description of class Professor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Professor extends Staff
{
    

public Professor(java.lang.String name,
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
     int Professor_salary = super.basicSalary + (super.basicSalary *50)/100+ (super.basicSalary*120)/100;
     return Professor_salary;
 }
 
 public java.lang.StringBuilder createRecord()
 {
     StringBuilder str = new StringBuilder();
     str.append("Professor:"+name+":"+super.uniqueId+":"+department+":"+getSalary()+"\n");
     return str;
 }
}
