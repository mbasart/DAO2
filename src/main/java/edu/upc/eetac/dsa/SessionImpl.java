package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.util.ObjectHelper;
import edu.upc.eetac.dsa.util.QueryHelper;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class SessionImpl implements Session {

    //mostra informacio amb log4j
    final Logger log = Logger.getLogger(EmployeeDAOImpl.class);

    private final Connection conn;

    public SessionImpl(Connection conn) {

        this.conn = conn;
    }

    public void save(Object entity) {

        String insertQuery = QueryHelper.createQueryINSERT(entity);
        log.info(insertQuery); //"INSERT INTO Employee (ID, name, surname, salary) VALUES (?,?,?,?)"

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            pstm.setObject(1, 0);
            int i = 2;

            //"INSERT INTO Employee (ID, name, surname, salary) VALUES (0,'Juan','lopez',33333333)"

            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }

            log.info(pstm.toString()); //vull veure si dona el insert amb els valors introduits

            //pstm.executeQuery();
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InvocationTargetException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    public void close() {

    }

    public Object get(Class theClass, int ID) {

        return null;
    }

    public void update(Object object) {

    }

    public void delete(Object object) {

    }

    public List<Object> findAll(Class theClass) {

        return null;
    }

    public List<Object> findAll(Class theClass, HashMap params) {

        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {

        return null;
    }
}
