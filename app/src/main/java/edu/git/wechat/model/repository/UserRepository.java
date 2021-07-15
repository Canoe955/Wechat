package edu.git.wechat.model.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.git.wechat.model.dao.UserDao;
import edu.git.wechat.model.database.UserDatabase;
import edu.git.wechat.model.entity.User;

public class UserRepository {
    private UserDao userDao ;
    private LiveData<List<User>> getLoginAccount;

    public UserRepository(Context context , String account) {
        UserDatabase userDatabase = UserDatabase.getDatabase(context);
        userDao = userDatabase.getUserDao();
        getLoginAccount =  userDao.getLiveDataAccount(account);
    }

    public LiveData<List<User>> getGetLoginAccount() {
        return getLoginAccount;
    }

    public void insertUser(User user){
        new InsertAsyncTask(userDao).execute(user);
    }

    public AsyncTask<String, Void, User> queryUserUser(String  strings){
       return new QueryAccountAsyncTask(userDao).execute(strings);
    }

    public AsyncTask<String, Void, User> queryPasswordUser(String  strings){
        return new QueryPasswordAsyncTask(userDao).execute(strings);
    }


    class InsertAsyncTask extends AsyncTask<User,Void,Void> {
        private UserDao userDao ;
        public InsertAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }
        @Override
        protected Void doInBackground(User... users) {
            userDao.insertUser(users);
            return null;
        }
    }

    class QueryAccountAsyncTask extends AsyncTask<String,Void,User> {
        private UserDao userDao ;
        public QueryAccountAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }
        @Override
        protected User doInBackground(String... strings) {
            return userDao.getAccount(strings);

        }
    }
    class QueryPasswordAsyncTask extends AsyncTask<String,Void,User> {
        private UserDao userDao ;
        public QueryPasswordAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }
        @Override
        protected User doInBackground(String... strings) {
            return userDao.getPassword(strings);
        }
    }

}
