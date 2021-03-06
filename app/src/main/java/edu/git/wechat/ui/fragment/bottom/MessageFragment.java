package edu.git.wechat.ui.fragment.bottom;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import edu.git.wechat.R;
import edu.git.wechat.adapter.MessageAdapter;
import edu.git.wechat.model.entity.Contact;
import edu.git.wechat.viewmodel.ContactViewModel;

public class MessageFragment extends Fragment {

    Button buttonInsert,buttonClear;
    ContactViewModel contactViewModel;
    MessageAdapter messageAdapter;
    RecyclerView recyclerView;

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.message_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        recyclerView = getView().findViewById(R.id.recycle_fragment_view);
        messageAdapter = new MessageAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(messageAdapter);

        contactViewModel.getAllContactsLive().observe(getActivity(), new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                messageAdapter.setAllContacts(contacts);
                messageAdapter.notifyDataSetChanged();
            }
        });

        /*buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] contact = {
                        "?????????",
                        "?????????",
                        "?????????",
                        "??????",
                        "?????????",
                        "??????",
                        "?????????",
                        "?????????",
                        "??????",
                        "?????????"
                };
                Integer[] image ={
                        R.drawable.profile_photo,
                        R.drawable.touxiang1,
                        R.drawable.touxiang2,
                        R.drawable.touxiang3,
                        R.drawable.touxiang4,
                        R.drawable.touxiang5,
                        R.drawable.touxiang6,
                        R.drawable.touxiang7,
                        R.drawable.touxiang8,
                        R.drawable.touxiang9
                };
                String[] message = {
                        "hello",
                        "world",
                        "????????????",
                        "????????????????????????????????????",
                        "???????????????????????????????????????????????????",
                        "?????????????????????",
                        "??????????????????",
                        "??????????????????????????????????????????????????????",
                        "?????????????????????????????????????????????",
                        "???????????????"
                };
                String[] time = {
                        "??????6:57",
                        "??????10:50",
                        "??????11:02",
                        "??????11:27",
                        "??????11:37",
                        "??????12:57",
                        "??????3:27",
                        "??????4:37",
                        "??????5:53",
                        "??????6:01"
                };
                for (int i = 0 ; i < contact.length ; i++){
                    contactViewModel.insertContacts(new Contact(contact[i],message[i],image[i],time[i]));
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactViewModel.deleteAllContacts();
            }
        });*/
    }


}