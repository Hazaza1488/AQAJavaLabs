package Task_6;

import Task_6.Entity.User;
import org.hibernate.Session;

import static Task_6.HibernateUtil.getSessionFactory;

public class HibernateMain {
    public static void main(String[] args) {
//        General:
//        Implement OneToOne, OneToMany, ManyToMany relations in your models from previous task. (add some additional tables if need)
//        Test it by CRUD.

        User user = new User(19, "Yurii");

        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Long id = (Long) session.save(user);
        System.out.println("id " + id);

        User userRead = session.get(User.class, id);
        System.out.println("userRead " + userRead);

        userRead.setName("Alan");
        session.saveOrUpdate(userRead);
        System.out.println("userUpdate " + session.get(User.class, id));

        session.delete(userRead);
        System.out.println("userDelete " + session.get(User.class, id));

        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }
}
