package edu.git.wechat.model.asyncTask;

import android.os.AsyncTask;

import edu.git.wechat.model.dao.ContactDao;

public class DeleteAllAsyncTask extends AsyncTask<Void,Void,Void> {
    private ContactDao contactDao;

    public DeleteAllAsyncTask(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        contactDao.deleteAllContact();
        return null;
    }
}
