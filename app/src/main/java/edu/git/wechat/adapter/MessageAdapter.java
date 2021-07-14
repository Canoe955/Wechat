package edu.git.wechat.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.git.wechat.R;
import edu.git.wechat.model.entity.Contact;


public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    List<Contact> contacts = new ArrayList<>();
    public void  setAllContacts(List<Contact> contacts){
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MessageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.textView_name.setText(contact.getContactName());
        holder.textView_message.setText(contact.getMessage());
        holder.textView_time.setText(contact.getTime());
        holder.imageView.setImageResource(contact.getImage());
    }

    @Override
    public int getItemCount() {
        return contacts == null ? 0 : contacts.size();
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView_name;
        TextView textView_message;
        TextView textView_time;
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_image);
            textView_name = itemView.findViewById(R.id.tv_name);
            textView_message = itemView.findViewById(R.id.tv_message);
            textView_time = itemView.findViewById(R.id.tv_time);
        }
    }

}
