package app.utils;

import app.database.DBConn;
import app.entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class IdChecker {

    public static boolean isIdExists(User user) {

        try {
            String query = "SELECT COUNT(id) FROM " + Constants.TABLE_USER + " WHERE id = ?";
            PreparedStatement pst = DBConn.connection().prepareStatement(query);
            pst.setInt(1, user.getId());

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
