package solo.soaniaina.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import static solo.soaniaina.config.HibernateConfig.*;
public class UpdateAndSave<T> {

    private static Transaction transaction = null;

    /**
     * SAVE AN RESOURCE
     */
    public boolean save(T obj) {
        int x = 0;
        try(Session session = getSession()) {
            transaction = session.beginTransaction();
            session.persist(obj);
            x++;
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return x > 0;
    }

    /**
     * UPDATE AN RESOURCE
     */
    public boolean update(T obj) {
        int x = 0;

        try(Session session = getSession()) {
            transaction = session.beginTransaction();
            session.merge(obj);
            x++;
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return x > 0;
    }

}
