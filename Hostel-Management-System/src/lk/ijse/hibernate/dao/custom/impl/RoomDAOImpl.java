package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.RoomDAO;
import lk.ijse.hibernate.entity.Room;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room dto) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(dto);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.load(Room.class,s);

        session.delete(room);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room dto) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(dto);

        transaction.commit();
        session.close();
        return  true;
    }

    @Override
    public List search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<Room> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();

        String hql = "FROM Room ";
        Query query = session.createQuery(hql);
        List<Room> roomList = query.list();
        return roomList;

    }
}
