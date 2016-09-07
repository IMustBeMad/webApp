package ua.web.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.web.common.Credentials;

@Repository
@Transactional
public class DbManager {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(Object o) {
        getSession().saveOrUpdate(o);
    }

    public Credentials getUserByName(String userName) {
        return (Credentials) getSession().createQuery("from Credentials where name = :name")
                .setParameter("name", userName)
                .uniqueResult();
    }
}
