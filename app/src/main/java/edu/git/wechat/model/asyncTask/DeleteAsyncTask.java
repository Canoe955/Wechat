package edu.git.wechat.model.asyncTask;

import android.os.AsyncTask;

import edu.git.wechat.model.dao.ContactDao;
import edu.git.wechat.model.entity.Contact;

public class DeleteAsyncTask extends AsyncTask<Contact,Void,Void> {
    private ContactDao contactDao;

    public DeleteAsyncTask(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    protected Void doInBackground(Contact... contacts) {
        contactDao.deleteContact(contacts);
        return null;
    }
}
