package edu.git.wechat.ui.fragment.other;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.git.wechat.R;
import edu.git.wechat.ui.fragment.other.base.Artist;
import edu.git.wechat.ui.fragment.other.base.Song;

public class TabAdapter extends RecyclerView.Adapter<TabAdapter.TabViewHolder> {
    private List<Song> list;
    public void setData(List<Song> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TabViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_song,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TabViewHolder holder, int position) {
        holder.textViewId.setText(String.valueOf(position+1));
        holder.textViewName.setText(list.get(position).getName());
        List<Artist> ar = list.get(position).getAr();
        StringBuilder str = new StringBuilder();
        for (int i = 0 ; i < ar.size() ; i++){
            str.append(ar.get(i).getName());
        }
        holder.textViewAr.setText(str.toString());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class TabViewHolder extends RecyclerView.ViewHolder {
        TextView textViewId,textViewName,textViewAr;
        public TabViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textView_id);
            textViewName = itemView.findViewById(R.id.textView_name);
            textViewAr = itemView.findViewById(R.id.textView_ar);

        }
    }
}
