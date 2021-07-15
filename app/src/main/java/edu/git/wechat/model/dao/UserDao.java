package edu.git.wechat.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.git.wechat.model.entity.User;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User...users);

    @Delete
    void deleteUser(User...users);

    @Query("SELECT * FROM USER")
    LiveData<List<User>> getAllUsers();

   /* @Query("SELECT account FROM USER WHERE ACCOUNT=(:account)")
    String getAccount(String[] account);*/
    @Query(("SELECT * From USER WHERE ACCOUNT=(:account)"))
    User getAccount(String[] account);


    @Ignore
    @Query("SELECT * FROM USER WHERE PASSWORD=(:password)")
    User getPassword(String[] password);

    @Query(("SELECT * From USER WHERE ACCOUNT=(:account)"))
    LiveData<List<User>> getLiveDataAccount(String account);

}
