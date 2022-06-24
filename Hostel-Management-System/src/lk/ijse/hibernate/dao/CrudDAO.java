package lk.ijse.hibernate.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO <T,Id> extends SuperDAO{
    boolean save(T dto) throws SQLException, ClassNotFoundException;
    boolean delete(Id id) throws SQLException, ClassNotFoundException;
    boolean update(T dto) throws SQLException, ClassNotFoundException;
    T search(Id id)throws SQLException,ClassNotFoundException;
    boolean exist(Id id) throws SQLException, ClassNotFoundException;
    List<T> getAll() throws SQLException,ClassNotFoundException;
}
