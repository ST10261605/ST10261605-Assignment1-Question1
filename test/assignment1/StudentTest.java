/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Sami
 */
public class StudentTest {
    
    @Test
    public void testSaveStudent() {
        Student st = new Student();
        
        st.setStID(100);
        st.setStName("John");
        st.setStAge(18);
        st.setStEmail("John@gmail.com");
        st.setStCourse("English");
           
          st.saveStudent();
        
        assertEquals(100, st.getStID());
        assertEquals("John", st.getStName());
        assertEquals(18, st.getStAge());
        assertEquals("John@gmail.com", st.getStEmail());
        assertEquals("English", st.getStCourse());
    }

    @Test
    public void testSearchStudent() {
        Student st = new Student();
        
        st.setStID(100);
        st.searchStudent();
        assertEquals(100, st.getStID());
    }

     @Test
    public void testSearchStudent_StudentNotFound() {
       Student st = new Student(scanner);
        
       st.setStID(100);
       st.searchStudent();
       assertEquals(11, st.getStID());
    } 

    @Test
    public void testDeleteStudent() {
        Student st = new Student();
        
        st.setStID(100);
        st.deleteStudent();
        assertEquals(100, st.getStID());     
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
       Student st = new Student();
       
        st.setStID(100);
        st.deleteStudent();
        assertEquals(11, st.getStID());
    } 

    @Test
    public void testStudentAge_StudentAgeValid() {
        Student st = new Student();
        
        st.setStAge(18);
        st.ageValidation();
        assertEquals(18, st.getStAge());
    }

    @Test
    public void testStudentAge_StudentAgeInvalid() {
        Student st = new Student();
        
        st.setStAge(12);
        st.ageValidation();
        assertEquals(18, st.getStAge());
    }
    
    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        Student st = new Student();

        st.setStAge(18);
        st.ageValidation();
        assertEquals("c", st.getStAge());
    }
    
}
