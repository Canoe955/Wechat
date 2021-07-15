package edu.git.wechat.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    public long id;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo(name = "account")
    private String account;
    @ColumnInfo(name = "password")
    private String password;
    @ColumnInfo(name = "QQ_Email")
    private String QQEmail;

    public User( String userName, String account, String password, String QQEmail) {
        this.userName = userName;
        this.account = account;
        this.password = password;
        this.QQEmail = QQEmail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQQEmail() {
        return QQEmail;
    }

    public void setQQEmail(String QQEmail) {
        this.QQEmail = QQEmail;
    }
}
