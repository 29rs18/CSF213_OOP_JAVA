
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student extends Person
{
    private java.lang.String codeForThesisOrPs;
    private java.lang.String departmentCode;
    private java.lang.String year;
    
    public Student(java.lang.String name,
               java.lang.String department,
               java.lang.String year,
               java.lang.String departmentCode,
               java.lang.String codeForThesisOrPs)
    {
        super(name,department);
        this.year = year;
        this.departmentCode = departmentCode;
        this.codeForThesisOrPs = codeForThesisOrPs;
        StringBuilder str = new StringBuilder();
        str.append(year);
        str.append(departmentCode);
        str.append(codeForThesisOrPs);
        str.append(number);
        str.append("G");
        uniqueId = str.toString();
        number++;
    }
    
    public java.lang.StringBuilder generateId()
    {
        return new StringBuilder(uniqueId);
    }
    
    public java.lang.String getId()
    {
        return generateId().toString();
    }
    
    public java.lang.StringBuilder createRecord()
    {
        StringBuilder str1 = new StringBuilder();
        str1.append("Student:"+name+":"+getId()+":"+department+"\n");
        return str1;
    }
}
