package nseit.com.tmdb.Discover.RetroClient;

/**
 * Created by vishvendu on 11/8/17.
 */

import nseit.com.tmdb.Discover.model.MovieDetailsModel.MovieDetails;
import nseit.com.tmdb.Discover.model.DiscoverMovieModel.SOAnswersResponse;
import nseit.com.tmdb.Discover.model.DiscoverTvModel.SOTvShowResponse;
import retrofit2.Call;

import retrofit2.http.GET;

import retrofit2.http.Path;
import retrofit2.http.Query;


public interface SOService {

    @GET("discover/movie?page=1&include_video=false&include_adult=false&sort_by=popularity.desc&language=en-IN&api_key=3e404f811a7dfe8f0684bb62d6632ecf")
    Call<SOAnswersResponse> getDiscoverMovie();

    @GET("discover/tv?api_key=3e404f811a7dfe8f0684bb62d6632ecf&language=en-US&sort_by=popularity.desc&page=1&timezone=America%2FNew_York&include_null_first_air_dates=false")
    Call<SOTvShowResponse> getDiscoverTvShow();

    //https://api.themoviedb.org/3/movie/{movie_id}?api_key=<<api_key>>&language=en-US
    @GET("movie/{id}")
    Call<MovieDetails> getMovieDetails(@Path("id") int id ,
                                       @Query("api_key") String apikey
                                      );
}
