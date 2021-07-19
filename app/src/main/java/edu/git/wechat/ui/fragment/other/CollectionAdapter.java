package edu.git.wechat.ui.fragment.other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import edu.git.wechat.R;
import edu.git.wechat.ui.fragment.other.base.Singer;
import edu.git.wechat.ui.fragment.other.base.Song;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.TabViewHolder> {
    private List<Singer> list;
    private Context context;

    public CollectionAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<Singer> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TabViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_art,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TabViewHolder holder, int position) {
        holder.textViewName.setText(list.get(position).getName());
        String img1v1Url = list.get(position).getImg1v1Url();
        Glide.with(context).load(img1v1Url).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class TabViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        ImageView imageView;
        public TabViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView_name);
            imageView = itemView.findViewById(R.id.imageView_art);
        }
    }
}
