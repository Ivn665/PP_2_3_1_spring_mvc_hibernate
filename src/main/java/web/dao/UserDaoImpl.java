package web.dao;


import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;


    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
        addUser(new User("Jackie", "Chan", (byte) 69, 100));
        addUser(new User("Bruce", "Lee", (byte) 32, -100));
        addUser(new User("Steven", "Seagal", (byte) 71, 10));
        addUser(new User("Gordon", "Liu", (byte) 72, -200));
    }

    @Override
    public List<User> allUsers() {
        Query query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public void deleteUser(long id) {
        sessionFactory.getCurrentSession()
                .createQuery("delete from User where id = :id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public void editUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User getById(long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }
}
