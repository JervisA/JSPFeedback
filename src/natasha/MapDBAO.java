package natasha;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Natasha on 11/12/2016.
 */
public class MapDBAO {

    Connection con;
    // Database configuration
    public static String url = "jdbc:mysql://localhost/jedp";
    public static String dbdriver = "com.mysql.jdbc.Driver";
    public static String username = "root";
    public static String password = "root";

    // constructor to load the jdbc driver, exception will be thrown if database driver is not found
    public MapDBAO() {
        try {
            Class.forName(dbdriver);
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // this is to make sure that connection is not null when you used it
    public void getConnection() throws SQLException {
        if (con == null) con = DriverManager.getConnection(url, username, password);
    }

    public MapDetails getMapDetails(String userLocation, String destination) {
        String sql = "select userLocation, destination, imageLink from map where userLocation = ? and destination = ?";
        MapDetails mapDetails = null;
        try {
            getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userLocation);
            pstmt.setString(2, destination);
            ResultSet rs = pstmt.executeQuery();
            if (rs != null && rs.next()) {
                mapDetails = new MapDetails();

                mapDetails.setUserLocation(rs.getString("userLocation"));
                mapDetails.setDestination(rs.getString("destination"));
                mapDetails.setImageLink(rs.getString("imageLink"));
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapDetails;
    }

}

