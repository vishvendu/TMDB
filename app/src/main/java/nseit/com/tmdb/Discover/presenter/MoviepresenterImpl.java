package nseit.com.tmdb.Discover.presenter;

import android.util.Log;

import nseit.com.tmdb.Discover.RetroClient.ApiUtils;
import nseit.com.tmdb.Discover.RetroClient.Result;
import nseit.com.tmdb.Discover.RetroClient.SOService;
import nseit.com.tmdb.Discover.view.DiscoverMovieView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vishvendu on 11/8/17.
 */

public class MoviepresenterImpl implements IMoviepresenter {


    DiscoverOnScreenView mDiscoverOnScreenView;
    private SOService mService;

    public MoviepresenterImpl(DiscoverOnScreenView discoverMovieView) {

        mService = ApiUtils.getSOService();
    }

    @Override
    public void fetchMoviesDiscover() {


        mService.getAnswers().enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                if(response.isSuccessful()) {

                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

                Log.d("MainActivity", "error loading from API");

            }
        });
    }
}
