package Task_6;

import Task_6.Entity.Device;
import Task_6.Entity.Phone;
import Task_6.Entity.SocialMedia;
import Task_6.Entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create properties for Hibernate configuration
                Properties hibernateProps = new Properties();
                hibernateProps.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                hibernateProps.put(Environment.URL, "jdbc:mysql://localhost:3306/a_t_java");
                hibernateProps.put(Environment.USER, "root");
                hibernateProps.put(Environment.PASS, "uri200306");
                hibernateProps.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                hibernateProps.put(Environment.SHOW_SQL, "true");
                hibernateProps.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                hibernateProps.put(Environment.HBM2DDL_AUTO, "create");

                // Build the configuration object and register entity classes
                Configuration configuration = new Configuration();
                configuration.setProperties(hibernateProps);

                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Phone.class);
                configuration.addAnnotatedClass(Device.class);
                configuration.addAnnotatedClass(SocialMedia.class);

                // Build the ServiceRegistry and create the SessionFactory
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Throwable ex) {
                // Make sure you log the exception, as it might be swallowed
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }
}
