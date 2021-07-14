package edu.git.wechat.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.git.wechat.model.entity.Contact;

@Dao
public interface ContactDao {

    @Insert
    void insertContact(Contact...contacts);

    @Delete
    void deleteContact(Contact...contacts);

    @Update
    void updateContact(Contact...contacts);

    @Query("DELETE FROM CONTACT")
    void deleteAllContact();

    @Query("SELECT * FROM CONTACT ORDER BY ID DESC")
    LiveData<List<Contact>> getAllContactsLive();

}
