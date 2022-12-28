package solo.soaniaina.config;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import solo.soaniaina.models.Student;

import java.util.Properties;

public class HibernateConfig {

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();

        // Hibernate settings equivalent to hibernate.cfg.xml's properties
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/crud_jsp_2?createDatabaseIfNotExist=true&useSSL=false");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "Étudiant314");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.ORDER_UPDATES, "true");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        settings.put(Environment.HBM2DDL_AUTO, "create");

        configuration.setProperties(settings);
        configuration.addAnnotatedClass(Student.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        System.out.println("\n********** Hibernate Java Config serviceRegistry created ***********\n");
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static Session getSession() {
        return HibernateConfig.getSessionFactory().openSession();
    }

}
