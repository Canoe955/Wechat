package edu.git.wechat.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.git.wechat.model.dao.UserDao;
import edu.git.wechat.model.entity.User;

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase INSTANCE;

    public static synchronized UserDatabase getDatabase(Context context){
        if (INSTANCE == null){

            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class,"user_database")
                    .addMigrations() //进行数据库的版本的迁移
                    .build();
        }
        return INSTANCE;
    };

    public abstract  UserDao getUserDao();
}
