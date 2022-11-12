package panel.sdk.repository;

import org.springframework.stereotype.Repository;
import panel.sdk.model.User;

import java.sql.*;
import java.time.LocalDateTime;

@Repository
public class UserRepository {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/lenovo-zk/Desktop/person.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return conn;
    }

    public boolean InsertUser(User user){
        String sql = "INSERT INTO persons(personID, role, name, psw, cardNo, createdAt) VALUES(?,?,?,?,?,?)";

        boolean result = false;
        Connection conn = null;
        try{
            conn = this.connect();
            if(conn==null)return false;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserID());
            if(user.getUserRole()!=null){
                pstmt.setInt(2, user.getUserRole());
            }else{
                pstmt.setNull(2, Types.INTEGER);
            }
            pstmt.setString(3, user.getUserName());
            if(user.getUserPassword()!=null){
                pstmt.setString(4, user.getUserPassword());
            }else{
                pstmt.setNull(4, Types.NVARCHAR);
            }
            if(user.getUserCardNo()!=null){
                pstmt.setString(5, user.getUserCardNo());
            }else{
                pstmt.setNull(5, Types.NVARCHAR);
            }
            pstmt.setString(6, LocalDateTime.now().toString());

            pstmt.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    public User getUserByCardNo(String cardNo){
        String sql = "SELECT * FROM persons where cardNo=?";

        Connection conn = null;
        try {
            conn = this.connect();
            if(conn==null) return null;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cardNo);
            ResultSet rs    = pstmt.executeQuery();

            // loop through the result set
            if(!rs.next()){
                System.out.println("Card No Not Found");
                return null;
            }else{
              User user = new User();
              user.setUserID(rs.getString("personID"));
                user.setUserRole(rs.getInt("role"));
                user.setUserName(rs.getString("name"));
                user.setUserPassword(rs.getString("psw"));
                user.setUserCardNo(rs.getString("cardNo"));
                String dateTime = rs.getString("createdAt");
                System.out.println("createdAt: "+dateTime + " Person name: "+rs.getString("name"));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            System.out.println(e.getMessage());
            return null;
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
//                System.out.println(ex.getMessage());
            }
        }
    }

}
