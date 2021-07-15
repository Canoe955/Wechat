package edu.git.wechat.model.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.git.wechat.model.asyncTask.DeleteAllAsyncTask;
import edu.git.wechat.model.asyncTask.DeleteAsyncTask;
import edu.git.wechat.model.asyncTask.InsertAsyncTask;
import edu.git.wechat.model.asyncTask.UpdateAsyncTask;
import edu.git.wechat.model.dao.ContactDao;
import edu.git.wechat.model.database.ContactDatabase;
import edu.git.wechat.model.entity.Contact;

public class ContactRepository {

    private LiveData<List<Contact>> allContactsLive;
    private ContactDao contactDao;

    // 使用构造方法创建database、contactDao
    public ContactRepository(Context context) {
        ContactDatabase contactDatabase = ContactDatabase.getDatabase(context.getApplicationContext());
        contactDao = contactDatabase.getContactDao();
        allContactsLive = contactDao.getAllContactsLive();

    }

    public LiveData<List<Contact>> getAllContactsLive() {

        return allContactsLive;
    }

    //创建执行的操作的方法
    public void insertContacts(Contact contact){
        new InsertAsyncTask(contactDao).execute(contact);
    }
    public void deleteContacts(Contact contact){
        new DeleteAsyncTask(contactDao).execute(contact);
    }
    public void updateContacts(Contact contact){
        new UpdateAsyncTask(contactDao).execute(contact);
    }
    public void deleteAllContacts(){
        new DeleteAllAsyncTask(contactDao).execute();
    }
}
