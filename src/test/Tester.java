package test;

import java.util.List;
import mypackage.DataHandler;
import mypackage.Student;

/**
 *
 * @author Peter
 */
public class Tester {

    public static void main(String[] args) {
        
        DataHandler dh = new DataHandler();
        
        List<Student> students = dh.findAllStudents();
        
    }
    
}
