package JDBC.JavaBean;

import JDBC.Utils.JDBCUtils;
import JDBC.Utils.JDBCUtilsByDurid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Boys {
    private int id;
    private String boyName;
    private int userCp;

    public Boys() {
    }

    public Boys(int id, String boyName, int userCp) {
        this.id = id;
        this.boyName = boyName;
        this.userCp = userCp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBoyName() {
        return boyName;
    }

    public void setBoyName(String boyName) {
        this.boyName = boyName;
    }

    public int getUserCp() {
        return userCp;
    }

    public void setUserCp(int userCp) {
        this.userCp = userCp;
    }


}
