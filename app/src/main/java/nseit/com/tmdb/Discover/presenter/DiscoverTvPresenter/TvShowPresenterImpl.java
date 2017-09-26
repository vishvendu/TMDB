package nseit.com.tmdb.Discover.presenter.DiscoverTvPresenter;

import java.util.List;

import nseit.com.tmdb.Discover.RetroClient.ApiUtils;
import nseit.com.tmdb.Discover.RetroClient.SOService;
import nseit.com.tmdb.Discover.model.DiscoverTvModel.DiscoverTvShowModelImpl;
import nseit.com.tmdb.Discover.model.DiscoverMovieModel.IDiscoverMovieModel;
import nseit.com.tmdb.Discover.model.DiscoverTvModel.ResultTvShow;
import nseit.com.tmdb.Discover.model.DiscoverTvModel.SOTvShowResponse;
import nseit.com.tmdb.Discover.view.DiscoverTvViews.IDiscoverTvShowView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vishvendu on 18/8/17.
 */

public class TvShowPresenterImpl implements ITvShowPresenter {

    private IDiscoverTvShowView iDiscoverTvShowView;
    private IDiscoverMovieModel iDiscoverMovieModel;
    private SOService mService;

    public TvShowPresenterImpl(IDiscoverTvShowView iDiscoverTvShowView) {

        this.iDiscoverTvShowView = iDiscoverTvShowView;
        iDiscoverMovieModel = new DiscoverTvShowModelImpl(this);
        mService = ApiUtils.getSOService();
    }

    @Override
    public void updateRecyclerView(List<ResultTvShow> resultTvShows) {

    }

    @Override
    public void discoverTvShow() {

        mService.getDiscoverTvShow().enqueue(new Callback<SOTvShowResponse>() {
            @Override
            public void onResponse(Call<SOTvShowResponse> call, Response<SOTvShowResponse> response) {

                if(response.isSuccessful()) {
                    System.out.println("response "+ response.body().getResults().size());
                    iDiscoverTvShowView.updateRecyclerView(response.body().getResults());

                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }


            }

            @Override
            public void onFailure(Call<SOTvShowResponse> call, Throwable t) {

            }


        });

    }
}
