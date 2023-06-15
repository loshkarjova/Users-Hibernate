package app.repositories;

import app.entities.User;
import app.utils.Constants;
import app.utils.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserUpdateRepository {
    @SuppressWarnings("deprecation")
    public String updateUser(User user){

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "UPDATE User SET phone = :phone WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("phone", user.getPhone());
            query.setParameter("id", user.getId());
            query.executeUpdate();
            transaction.commit();
            return Constants.DATA_UPDATE_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}
