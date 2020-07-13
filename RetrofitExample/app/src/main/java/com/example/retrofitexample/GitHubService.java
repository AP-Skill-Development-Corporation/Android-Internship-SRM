package com.example.retrofitexample;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubService {

    @GET("users/mastan511/repos")
    Call<String> getRepos();

}
