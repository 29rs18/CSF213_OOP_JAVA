
/**
 * Write a description of class BitsCampus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class BitsCampus
{
    private java.util.HashMap<java.lang.String,java.util.HashSet<Person>> departments;
    
    public BitsCampus()
    {
        departments = new java.util.HashMap<java.lang.String,java.util.HashSet<Person>>();
    }
    
    public boolean addPerson(Person person)
    {
        if(departments.containsKey(person.department))
        {
            HashSet<Person> p1 = departments.get(person.department);
            int size = p1.size();
            p1.add(person);
            if(size!=p1.size())
            {
                departments.put(person.department,p1);
                return true;
            }
            else
            return false; 
        }
        HashSet<Person> p2 = new HashSet<Person>();
        p2.add(person);
        departments.put(person.department,p2);
        return true;
    }
    
    public java.lang.StringBuilder getRecords()
    {
        Set set = departments.entrySet();
        Iterator iterator = set.iterator();
        StringBuilder str = new StringBuilder();
        while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         HashSet<Person> p3 = departments.get(mentry.getKey());
         Iterator it1 = p3.iterator();
         while(it1.hasNext())
         {
             Person p1 = (Person) it1.next();
             str.append(p1.createRecord());
            }
        }
        return str;
    }
    
    public java.lang.StringBuilder getRecords(java.lang.String departmentName)
    {
        StringBuilder str = new StringBuilder();
        HashSet<Person> p3 = departments.get(departmentName);
        Iterator it1 = p3.iterator();
         while(it1.hasNext())
         {
             Person p1 = (Person) it1.next();
             str.append(p1.createRecord());
            }
         return str;
        
    }
}
