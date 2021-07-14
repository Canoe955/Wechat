package edu.git.wechat.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


import edu.git.wechat.model.dao.ContactDao;
import edu.git.wechat.model.database.ContactDatabase;
import edu.git.wechat.model.entity.Contact;
import edu.git.wechat.model.repository.ContactRepository;

public class ContactViewModel extends AndroidViewModel {

    private ContactDao contactDao;
    private LiveData<List<Contact>> allContactsLive;
    private ContactRepository contactRepository;

    public ContactViewModel(@NonNull Application application) {
        super(application);
        ContactDatabase contactDatabase = ContactDatabase.getDatabase(application);
        contactDao = contactDatabase.getContactDao();
        contactRepository = new ContactRepository(application);
        allContactsLive = contactRepository.getAllContactsLive();
    }

    //获取全部数据
    public LiveData<List<Contact>> getAllContactsLive() {
        return allContactsLive;
    }

    public void insertContacts(Contact contact){
        contactRepository.insertContacts(contact);
    }
    public void deleteContacts(Contact contact){
        contactRepository.deleteContacts(contact);
    }
    public void updateContacts(Contact contact){
        contactRepository.updateContacts(contact);
    }
    public void deleteAllContacts(){
        contactRepository.deleteAllContacts();
    }

}
