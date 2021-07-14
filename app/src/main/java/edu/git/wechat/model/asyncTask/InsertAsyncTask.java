package edu.git.wechat.model.asyncTask;

import android.os.AsyncTask;

import edu.git.wechat.model.dao.ContactDao;
import edu.git.wechat.model.entity.Contact;

public class InsertAsyncTask extends AsyncTask<Contact,Void,Void> {
    private ContactDao contactDao;

    public InsertAsyncTask(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    protected Void doInBackground(Contact... contacts) {
        contactDao.insertContact(contacts);
        return null;
    }
}
