package natasha;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natasha on 13/12/2016.
 */
public class FaqDBAO {
    Connection con;
    // Database configuration
    public static String url = "jdbc:mysql://localhost/jedp";
    public static String dbdriver = "com.mysql.jdbc.Driver";
    public static String username = "root";
    public static String password = "IT1639";

    // constructor to load the jdbc driver, exception will be thrown if database driver is not found
    public FaqDBAO() {
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

    // Retrieve all the maps from database
    public List<FaqDetails> getAllFaq() {
        String sql = "select * from faq";
        ArrayList<FaqDetails> list = new ArrayList<FaqDetails>();
        try {
            getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs != null && rs.next()) {
                FaqDetails faqDetails = new FaqDetails();
                faqDetails.setId(rs.getString("id"));
                faqDetails.setQuestion(rs.getString("question"));
                faqDetails.setAnswer(rs.getString("answer"));
                faqDetails.setCategory(rs.getString("category"));
                list.add(faqDetails);
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<FaqDetails> getFaqByCategory(String category) {
        String sql = "select question, answer, category from faq where category = ?";
        ArrayList<FaqDetails> faqList = new ArrayList<FaqDetails>();
        try {
            getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,category);
            ResultSet rs = pstmt.executeQuery();
            while (rs != null && rs.next()) {
                FaqDetails faqDetails = new FaqDetails();

                faqDetails.setQuestion(rs.getString("question"));
                faqDetails.setAnswer(rs.getString("answer"));
                faqDetails.setCategory(rs.getString("category"));
                faqList.add(faqDetails);
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return faqList;
    }
}
