package solo.soaniaina.dao;


import org.apache.logging.log4j.Level;
import org.hibernate.Session;
import org.hibernate.Transaction;
import solo.soaniaina.models.Student;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

import static solo.soaniaina.config.HibernateConfig.*;
import static solo.soaniaina.servlets.ServletMethods.*;
public class StudentDAO extends UpdateAndSave<Student> {

    private static Transaction transaction = null;
    private static List<Student> studentList = new ArrayList<>();
    private static Student student = null;

    @Override
    public boolean save(Student obj) {
        return super.save(obj);
    }

    @Override
    public boolean update(Student obj) {
        return super.update(obj);
    }

    /**
     * REMOVE AN RESOURCE
     */
    public static boolean remove(Object id) {
        int x = 0;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            int idU = (int)id;
            Student student1 = session.get(Student.class, idU);
            if (student1 != null) {
                LOGGER.log(Level.WARN, "STUDENT'S FULLNAME : {} WITH HIS ID : {}",student1.getFirstname()+" "+student1.getLastname(), idU);
                session.delete(student1);
                x++;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return x > 0;
    }

    public static Student findById(Object id) {
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            int idU = (int)id;
            student = session.get(Student.class, idU);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;
    }

    public static List<Student> findAll() {
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
            criteriaQuery.from(Student.class);
            studentList = session.createQuery(criteriaQuery).getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

}
