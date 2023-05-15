package Task_6.Task_7;

import Task_6.Entity.Device;
import Task_6.Entity.Phone;
import Task_6.Entity.SocialMedia;
import Task_6.Entity.User;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static Task_6.HibernateUtil.getSessionFactory;

public class Hibernate7 {
    public static void main(String[] args) {
        User user = new User(19, "Yuri");

        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();

        user.setPhone(new Phone("0672976295"));
        Long id = (Long) session.save(user);
        System.out.println(session.get(User.class, id));

        user.setDevices(new HashSet<>(Arrays.asList(new Device("iPhone"), new Device("Redmo note 8"))));
        session.saveOrUpdate(user);
        user.getDevices().forEach(session::save);
        System.out.println(session.get(User.class, id));



        User user2 = new User(21, "Dima");
        SocialMedia instagram = new SocialMedia("instagram");
        SocialMedia twitter = new SocialMedia("twitter");
        Long id2 = (Long) session.save(user2);


        session.save(instagram);
        session.save(twitter);
        user.setSocialMedia(Arrays.asList(instagram));
        user2.setSocialMedia(Arrays.asList(instagram, twitter));


        session.saveOrUpdate(user);
        session.save(user2);


        session.getTransaction().commit();
        session.close();
        System.exit(0);

    }

}
