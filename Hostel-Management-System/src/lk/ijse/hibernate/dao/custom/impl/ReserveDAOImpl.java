package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.ReserveDAO;
import lk.ijse.hibernate.entity.Reserve;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class ReserveDAOImpl implements ReserveDAO {
    @Override
    public boolean save(Reserve entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

       session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Reserve> getAllReserve() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        String hql = "FROM Reserve ";
        Query query = session.createQuery(hql);
        List<Reserve> reserveList = query.getResultList();
        return reserveList;
    }

}
