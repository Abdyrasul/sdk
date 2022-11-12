package panel.sdk.model;

import java.time.LocalDateTime;

public class User {
    private Integer id;
    private String userID;
    private Integer userRole;
    private String userName;
    private String userPassword;
    private String userCardNo;
    private LocalDateTime createdAt;

    public User() {
    }

    public User(Integer id, String userID, Integer userRole, String userName, String userPassword, String userCardNo, LocalDateTime createdAt) {
        this.id = id;
        this.userID = userID;
        this.userRole = userRole;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userCardNo = userCardNo;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserCardNo() {
        return userCardNo;
    }

    public void setUserCardNo(String userCardNo) {
        this.userCardNo = userCardNo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
