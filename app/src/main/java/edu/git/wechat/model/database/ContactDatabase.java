package edu.git.wechat.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.git.wechat.model.dao.ContactDao;
import edu.git.wechat.model.entity.Contact;


@Database(entities = {Contact.class},version = 1,exportSchema = false)
public abstract class ContactDatabase extends RoomDatabase {
    private static ContactDatabase INSTANCE;

    public static synchronized ContactDatabase getDatabase(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),ContactDatabase.class,"contact_database")
                    .addMigrations() //进行数据库的版本的迁移
                    .build();
        }
        return INSTANCE;
    };

    //用于获取返回Dao对象
    public abstract ContactDao getContactDao();


}
