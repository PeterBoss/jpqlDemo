package mypackage;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Peter
 */
public class DataHandler {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpqlDemoPU");

    @PersistenceContext
    public List<Student> findAllStudents() {
        List<Student> students;
        EntityManager em = emf.createEntityManager();

        students = em.createNamedQuery("Student.findAll").getResultList();
        
        em.close();
        return students;
    }

    @PersistenceContext
    public List<Student> findStudentsByFirstName(String name) {
        List<Student> students;
        EntityManager em = emf.createEntityManager();

        students = em.createNamedQuery("Student.findByFirstname").setParameter("firstname", name).getResultList();
        
        em.close();
        return students;
    }

    @PersistenceContext
    public List<Student> findStudentsByLastName(String name) {
        List<Student> students;
        EntityManager em = emf.createEntityManager();

        students = em.createNamedQuery("Student.findByLastname").setParameter("lastname", name).getResultList();
        
        em.close();
        return students;
    }

    @PersistenceContext
    public int getStudypointSumById(int id) {
        Student stu;
        int sum = 0;
        EntityManager em = emf.createEntityManager();
        
        stu = (Student) em.createNamedQuery("Student.findById").setParameter("id", id).getSingleResult();
        
        List<Studypoint> points = stu.getStudypointList();
        
        for (Studypoint p : points) {
            sum += p.getScore();
        }
        em.close();
        return sum;
    }
    
    public void createStudent(Student student) {
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
        
    }
}
