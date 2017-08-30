/*
 * Copyright 2017 Vladyslav Pohrebniakov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package vladyslavpohrebniakov.depressingthoughts.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TwitterApiClient {

    String BASE_URL = "https://api.twitter.com/";
    String CLIENT_CREDENTIALS = "client_credentials";
    int USER_ID = 214677229;
    int COUNT = 200;

    @FormUrlEncoded
    @POST("oauth2/token")
    Call<OAuthToken> postCredentials(
            @Field("grant_type") String grantType
    );

    @GET("/1.1/statuses/user_timeline.json?exclude_replies=true&include_rts=false")
    Call<List<Tweet>> getTweet(
            @Query("user_id") int userId,
            @Query("count") int count
    );
}
