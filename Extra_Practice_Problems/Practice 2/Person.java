
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person extends java.lang.Object
{
    protected java.lang.String department;
    protected java.lang.String name;
    protected static int number=100;
    protected java.lang.String uniqueId;
    
    public Person(java.lang.String name,
              java.lang.String department)
    {
        this.name = name;
        this.department = department;
        
    }
    
    public java.lang.StringBuilder generateId()
    {
        StringBuilder id = new StringBuilder();
        uniqueId = String.valueOf(number);
        id.append(uniqueId);
        return id;
    }
    
    public java.lang.String getId()
    {
        String id = generateId().toString();
        return id;
    }
    @Override
    public int hashCode()
    {
        int result = 17;
        result = 37 * result + name.hashCode();
        result = 37 * result + department.hashCode();
        return result;
    }
    @Override
    public boolean equals(java.lang.Object obj)
    {
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof Person)) {
            return false;
        }
        Person other = (Person) obj;
        return name.equals(other.name) &&
        department.equals(other.department);
    }
    
    public java.lang.StringBuilder createRecord()
    {
        return null;
    }
    
}
