package edu.git.wechat.viewmodel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.git.wechat.model.dao.UserDao;
import edu.git.wechat.model.database.UserDatabase;
import edu.git.wechat.model.entity.User;
import edu.git.wechat.model.repository.UserRepository;

public class UserViewModel extends AndroidViewModel {
    private UserDao userDao ;
    private UserRepository userRepository;
    private LiveData<List<User>> getLoginAccount;
    private String account;

    public void setAccount(String account) {
        this.account = account;
    }

    public UserViewModel(@NonNull Application application) {
        super(application);
        UserDatabase database = UserDatabase.getDatabase(application);
        userDao = database.getUserDao();
        userRepository = new UserRepository(application,account);
        getLoginAccount = userRepository.getGetLoginAccount();
    }

    public LiveData<List<User>> getGetLoginAccount() {
        return getLoginAccount;
    }

    public void insertUser(User user){
        userRepository.insertUser(user);
    }

    public AsyncTask<String, Void, User> queryUserUser(String  strings){
        return userRepository.queryUserUser(strings);
    }

    public AsyncTask<String, Void, User> queryPasswordUser(String  strings){
        return userRepository.queryPasswordUser(strings);
    }
}
