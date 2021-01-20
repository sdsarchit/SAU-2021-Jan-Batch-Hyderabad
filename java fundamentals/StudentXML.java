import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.*;
class InvalidMarkException extends Exception{

    InvalidMarkException(String exceptionInfo){
        super(exceptionInfo);
    }
}
@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
class Students {

    @XmlElement(name = "student" )
    List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
class Student {
    @XmlElement(name = "roll" )
    private int Roll;
    @XmlElement(name = "marks" )
    private int Mark;
    @XmlElement(name = "subject" )
    private String Subject;

    public int getRoll() {
        return Roll;
    }

    public void setRoll(int roll) {
        Roll = roll;
    }

    public int getMark() {
        return Mark;
    }

    public void setMark(int mark) {
        Mark = mark;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
public class StudentXML{
 static void serialize(HashMap<Integer, Integer> rollTotalMarks, String fileName) throws Exception {

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(rollTotalMarks);
        objectOutputStream.close();
        fileOutputStream.close();

    }

    public static void main(String[] args)throws Exception {
        File studentXmlFile = new File("students.xml");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            Students students = (Students) jaxbUnMarshaller.unmarshal(studentXmlFile);

            HashMap<Integer, Integer> rollTotalMarks = new HashMap<>();

            for(Student s : students.getStudentList())
            {
                if(s.getMark() < 0 || s.getMark() > 100) {
                    throw new InvalidMarkException("Mark should be between 0 - 100, Student roll number: " + s.getRoll());
                }
                else
                {
                    if(rollTotalMarks.containsKey(s.getRoll()))
                        rollTotalMarks.put(s.getRoll(), (rollTotalMarks.get(s.getRoll()) + s.getMark()));
                    else
                        rollTotalMarks.put(s.getRoll(), s.getMark());
                }
            }
            serialize(rollTotalMarks, "student.txt");
            System.out.println(rollTotalMarks);
            System.out.println("Serialized to student.txt");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        catch (InvalidMarkException e)
        {
            System.out.println("Mark exception: " + e);
        }
    }
}
