package JDBC.Service;

import JDBC.Dao.AdminDao;

public class AdminService {
    private AdminDao dao = new AdminDao();

    public boolean login(String username, String password) {

        Object count = dao.scalar("select count(*) from admin where username=? and password=?", username, password);
        return Integer.parseInt(count + "") > 0;

    }

}
