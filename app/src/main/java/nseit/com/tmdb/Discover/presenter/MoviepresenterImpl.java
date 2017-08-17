package nseit.com.tmdb.Discover.presenter;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import nseit.com.tmdb.Discover.RetroClient.ApiUtils;

import nseit.com.tmdb.Discover.RetroClient.SOService;
import nseit.com.tmdb.Discover.model.DiscoverMovieModel;
import nseit.com.tmdb.Discover.model.DiscoverMovieModelImpl;
import nseit.com.tmdb.Discover.model.Result;
import nseit.com.tmdb.Discover.model.SOAnswersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vishvendu on 11/8/17.
 */

public class MoviepresenterImpl implements IMoviepresenter {


    IDiscoverOnScreenView mDiscoverOnScreenView;
    DiscoverMovieModel discoverMovieModel;
    private SOService mService;



    public MoviepresenterImpl(IDiscoverOnScreenView discoverMovieView) {
        this.mDiscoverOnScreenView = discoverMovieView;
        discoverMovieModel = new DiscoverMovieModelImpl(this);
        mService = ApiUtils.getSOService();
    }

    @Override
    public void fetchMoviesDiscover() {


        mService.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {

                if(response.isSuccessful()) {
                    System.out.println("response "+ response.body().getResults().size());
                    mDiscoverOnScreenView.updateRecyclerView(response.body().getResults());

                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }


            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {

            }


        });
    }

    @Override
    public void updateRecyclerView(List<Result> discoverResultList) {

      //  mDiscoverOnScreenView.showResult(discoverResultList);
    }
}
