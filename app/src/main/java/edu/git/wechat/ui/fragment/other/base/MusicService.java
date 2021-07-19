package edu.git.wechat.ui.fragment.other.base;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MusicService {

    // https://autumnfish.cn/artist/top/song?id=6452
    @GET("artist/top/song")
    Call<Base> getSongs(@Query("id") String id);

    //https://autumnfish.cn/artist/list?type=1
    @GET("artist/list")
    Call<BaseArt> getArts(@Query("type") String type);


}
