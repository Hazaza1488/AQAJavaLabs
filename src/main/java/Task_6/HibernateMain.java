package Task_6;

import Task_6.Entity.User;
import org.hibernate.Session;

import static Task_6.HibernateUtil.getSessionFactory;

public class HibernateMain {
    public static void main(String[] args) {
        User user = new User(19, "Yuri");

        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Long id = (Long) session.save(user);
        System.out.println("id " + id);

        User userRead = session.get(User.class, id);
        System.out.println("userRead " + userRead);

        User userUpdate = userRead;
        userUpdate.setName("Dima");
        session.saveOrUpdate(userUpdate);
        System.out.println("userUpdate " + session.get(User.class,id));

        session.delete(user);
        session.delete(id);



        session.getTransaction().commit();
        session.close();
        System.exit(0);

    }

}
