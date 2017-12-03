package com.src.novel.todokeru;

import com.src.novel.todokeru.model.Message;
import com.src.novel.todokeru.model.User;
import com.src.novel.todokeru.post.MessagePost;
import com.src.novel.todokeru.post.UserPost;

import java.util.HashMap;
import java.util.Objects;

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
    Call<User> postTop(@Body HashMap<String, Object> post);

    @GET("message")
    Call<Message> getMessage(@Query("user_id") int user_id);

    @POST("message")
    Call<User> postMessage(@Body HashMap<String, String> post);

    @POST("tags")
    Call<User> getTags();
}
