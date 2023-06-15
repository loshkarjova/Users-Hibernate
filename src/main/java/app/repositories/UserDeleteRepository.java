package app.repositories;

import app.entities.User;
import app.utils.Constants;
import app.utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDeleteRepository {
    @SuppressWarnings("deprecation")
    public String deleteUser(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = session.get(User.class, user.getId());

            if (user != null) {
                String hql = "DELETE FROM User WHERE id = :id";
                Query query = session.createQuery(hql);
                query.setParameter("id", user.getId());
                query.executeUpdate();
            }
            transaction.commit();
            return Constants.DATA_DELETE_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}
