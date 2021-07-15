package edu.git.wechat.ui.fragment.other;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.git.wechat.R;
import edu.git.wechat.ui.fragment.other.base.Base;
import edu.git.wechat.ui.fragment.other.base.MusicService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TabConAndBottomFragment extends Fragment {
    RecyclerView recyclerView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_con_and_bottom, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = getView().findViewById(R.id.recycleview_song);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        TabAdapter tabAdapter = new TabAdapter();
        recyclerView.setAdapter(tabAdapter);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://autumnfish.cn/").addConverterFactory(GsonConverterFactory.create()).build();
        MusicService service = retrofit.create(MusicService.class);
        Call<Base> songs = service.getSongs("6452");
        songs.enqueue(new Callback<Base>() {
            @Override
            public void onResponse(Call<Base> call, Response<Base> response) {
                Base body = response.body();
                tabAdapter.setData(body.getSongs());
            }
            @Override
            public void onFailure(Call<Base> call, Throwable t) {

            }
        });

    }



}