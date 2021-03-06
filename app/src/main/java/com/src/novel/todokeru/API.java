package com.src.novel.todokeru;

import com.src.novel.todokeru.model.Message;
import com.src.novel.todokeru.model.User;
import com.src.novel.todokeru.post.MessagePost;
import com.src.novel.todokeru.post.UserPost;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by pdc-k-kamiya on 2017/12/03.
 */

public interface API {

    String BASE_URL = "https://7c3uy6hf0h.execute-api.ap-northeast-1.amazonaws.com/prod/app/wear-need/";

    @GET("search")
    Call<User> getSearch(@Query("tag_name") String tag_name);

    @GET("top")
    Call<User> getTop();

    @POST("top")
    Call<User> postTop(@Body UserPost userPost);

    @GET("message")
    Call<Message> getMessage(@Query("user_id") float user_id);

    @POST("message")
    Call<User> postMessage(@Body MessagePost messagePost);

    @POST("tags")
    Call<User> getTags();
}
