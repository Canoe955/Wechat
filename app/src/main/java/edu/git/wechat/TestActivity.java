package edu.git.wechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import edu.git.wechat.adapter.MessageAdapter;
import edu.git.wechat.model.entity.Contact;
import edu.git.wechat.viewmodel.ContactViewModel;

public class TestActivity extends AppCompatActivity {
    Button buttonInsert,buttonClear;
    ContactViewModel contactViewModel;
    MessageAdapter messageAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        recyclerView = findViewById(R.id.recycleview);
        messageAdapter = new MessageAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(messageAdapter);

        buttonInsert = findViewById(R.id.buttonInsert);
        buttonClear = findViewById(R.id.buttonClear);

        contactViewModel.getAllContactsLive().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> contacts) {
                messageAdapter.setAllContacts(contacts);
                messageAdapter.notifyDataSetChanged();
            }
        });

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] contact = {
                        "深圳马",
                        "杭州马",
                        "建林兄",
                        "东哥",
                        "雷布斯",
                        "铮哥",
                        "彦宏兄",
                        "家印哥",
                        "磊哥",
                        "惠妍姐"
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
                        "又挂科了",
                        "今天辛苦了，犒劳自己一下",
                        "给大家推荐两部好看的电影，真心不错",
                        "今天天气真不错",
                        "两只都好可爱",
                        "有要打球的吗？没有我等一会儿再来问问",
                        "哪位大哥有爱奇艺会员，求借一下",
                        "风景真的好"
                };
                String[] time = {
                        "上午6:57",
                        "上午10:50",
                        "上午11:02",
                        "上午11:27",
                        "上午11:37",
                        "下午12:57",
                        "下午3:27",
                        "下午4:37",
                        "下午5:53",
                        "下午6:01"
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
        });

    }
}