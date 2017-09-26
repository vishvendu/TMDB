package nseit.com.tmdb.Discover.presenter.DiscoverMoviePresenter;

import java.util.List;

import nseit.com.tmdb.Discover.RetroClient.ApiUtils;

import nseit.com.tmdb.Discover.RetroClient.SOService;
import nseit.com.tmdb.Discover.model.DiscoverMovieModel.IDiscoverMovieModel;
import nseit.com.tmdb.Discover.model.DiscoverMovieModel.DiscoverMovieModelImpl;
import nseit.com.tmdb.Discover.model.DiscoverMovieModel.Result;
import nseit.com.tmdb.Discover.model.DiscoverMovieModel.SOAnswersResponse;
import nseit.com.tmdb.Discover.view.DiscoverMovieView.IDiscoverMovieView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vishvendu on 11/8/17.
 */

public class MoviepresenterImpl implements IMoviepresenter {


    IDiscoverMovieView mDiscoverOnScreenView;
    IDiscoverMovieModel discoverMovieModel;
    private SOService mService;



    public MoviepresenterImpl(IDiscoverMovieView discoverMovieView) {
        this.mDiscoverOnScreenView = discoverMovieView;
        discoverMovieModel = new DiscoverMovieModelImpl(this);
        mService = ApiUtils.getSOService();
    }

    @Override
    public void fetchMoviesDiscover() {


        mService.getDiscoverMovie().enqueue(new Callback<SOAnswersResponse>() {
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
