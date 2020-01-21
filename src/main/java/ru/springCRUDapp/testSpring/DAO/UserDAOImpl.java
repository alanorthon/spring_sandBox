package ru.springCRUDapp.testSpring.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.springCRUDapp.testSpring.model.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(user);
    }

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public void deleteUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getUserById(id));
    }

    @Override
    public boolean isExistingUser(String login) {
        Session session = sessionFactory.getCurrentSession();
        return !session.createQuery("FROM User where login = '" + login + "'").getResultList().isEmpty();
    }

}
