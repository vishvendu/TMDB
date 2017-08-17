package nseit.com.tmdb.Discover.RetroClient;

/**
 * Created by vishvendu on 11/8/17.
 */

import java.util.List;

import nseit.com.tmdb.Discover.model.SOAnswersResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SOService {

    @GET("discover/movie?page=1&include_video=false&include_adult=false&sort_by=popularity.desc&language=en-IN&api_key=3e404f811a7dfe8f0684bb62d6632ecf")
    Call<SOAnswersResponse> getAnswers();

    /*@GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<Result> getAnswers(@Query("tagged") String tags);*/
}
