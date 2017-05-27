package io.automation.data;


import io.automation.data.hibernate.ProcessInstance;
import io.automation.data.hibernate.User;
import io.automation.data.util.WordGenerator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {

    private static SessionFactory sessionFactory;

    public static void main(String [] args)
    {
        WordGenerator wg = new WordGenerator();
        System.out.println("It works ! " + wg.getWords().size() + " words");
        User u = new User(wg.getWord(),wg.getWord(),wg.getWord());
        create(new ProcessInstance("Credit Request", wg.getSentence(),u));
        getSessionFactory().close();
    }

    public static Integer create(ProcessInstance p) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + p.toString());
        return p.getId();

    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

}
