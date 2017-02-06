package jervis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jervis on 4/2/2017.
 */
public class FeedbackDAO {

        Connection con;
        // Database configuration
        public static String url = "jdbc:mysql://localhost/jedp";
        public static String dbdriver = "com.mysql.jdbc.Driver";
        public static String username = "root";
        public static String password = "IT1639";

        // constructor to load the jdbc driver, exception will be thrown if database driver is not found
        public FeedbackDAO() throws Exception {
            Class.forName(dbdriver);
            con = DriverManager.getConnection(url, username, password);
        }
        // this is to make sure that connection is not null when you used it
        public void getConnection() throws SQLException {
            if (con == null) con = DriverManager.getConnection(url, username, password);
        }

        // Retrieve book details based on bookId, null is returned if book is not found
        public FeedbackDetails getFeedbackDetails(String feedbackID) {
            String sql = "select * from feedback where id = ?";
            FeedbackDetails fb = null;
            try {
                getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1,feedbackID);
                ResultSet rs = pstmt.executeQuery();
                if (rs != null) {
                    rs.next();
                    fb = new FeedbackDetails();
                    fb.setFeedbackID(rs.getString("feedbackId"));
                    fb.setName(rs.getString("name"));
                    fb.setEmail(rs.getString("email"));
                    fb.setMobile(rs.getString("mobile"));
                    fb.setFeedback(rs.getString("feedback"));
                }
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return fb;
        }

        public List<FeedbackDetails> getAllFeedback() {
            String sql = "select * from feedback";
            ArrayList<FeedbackDetails> list = new ArrayList<FeedbackDetails>();
            try {
                getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while (rs != null && rs.next()) {
                    FeedbackDetails f = new FeedbackDetails();
                    f.setFeedbackID(rs.getString("feedbackId"));
                    f.setName(rs.getString("name"));
                    f.setEmail(rs.getString("email"));
                    f.setMobile(rs.getString("mobile"));
                    f.setFeedback(rs.getString("feedback"));
                    list.add(f);
                }
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        }


    public boolean add( String name, String email , String mobile , String feedback ) throws Exception{
            boolean status =false;
            System.out.println(status);
            String sqlQuery = null;
            ResultSet rs = null;
            int id = 1;
            boolean success = false;
            PreparedStatement pstmt;

            FeedbackDAO fb = new FeedbackDAO();
            fb.getConnection();

            sqlQuery = "SELECT MAX(feedbackId) FROM  feedback;";
            pstmt = fb.getPreparedStatement(sqlQuery);
            try {
                    rs = pstmt.executeQuery();
                if (rs.next()) {
                    id = rs.getInt(1) + 1;
                }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            sqlQuery = "INSERT INTO feedback(feedbackId, name, email, mobile, feedback)" +"VALUES(?, ?, ?, ?, ?)";

            pstmt = fb.getPreparedStatement(sqlQuery);
             try{
                 pstmt.setInt(1, id);
                 pstmt.setString(2, name);
                 pstmt.setString(3, email);
                 pstmt.setString(4, mobile);
                 pstmt.setString(5,feedback);
                 pstmt.executeUpdate();
                 pstmt.close();
             }
             catch(Exception e)
            {
                 e.printStackTrace();
            }

            fb.terminate();
            return status;
    }

    private void terminate() {
            try{
                con.close();
                System.out.println("Connection is closed");
            }
            catch (Exception e){
                e.printStackTrace();
            }
    }

    private PreparedStatement getPreparedStatement(String dbquery) {
        PreparedStatement pstmt = null;
        System.out.println("DB prepare statement: " +  dbquery);
        try{
            pstmt = con.prepareStatement(dbquery);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return pstmt;
    }





}

