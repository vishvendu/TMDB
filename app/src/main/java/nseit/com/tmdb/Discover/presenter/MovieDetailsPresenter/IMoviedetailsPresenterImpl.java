package nseit.com.tmdb.Discover.presenter.MovieDetailsPresenter;

import android.support.v4.app.FragmentActivity;

import nseit.com.tmdb.Discover.RetroClient.ApiUtils;
import nseit.com.tmdb.Discover.RetroClient.SOService;
import nseit.com.tmdb.Discover.model.MovieDetailsModel.IMovieOverviewModel;
import nseit.com.tmdb.Discover.model.MovieDetailsModel.MovieDetails;
import nseit.com.tmdb.Discover.model.MovieDetailsModel.MovieOverviewModelImpl;
import nseit.com.tmdb.Discover.view.MovieDetailsViews.IMovieDeatilsView;
import nseit.com.tmdb.Discover.view.MovieDetailsViews.IMovieOverview_view;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static nseit.com.tmdb.Common.Constant.TMDB_API;

/**
 * Created by vishvendu on 18/9/17.
 */

public class IMoviedetailsPresenterImpl implements IMovieDetailsPresenter {

    private IMovieOverview_view iMovieOverview_view;

    private IMovieDeatilsView iMovieDeatilsView;

    private IMovieOverviewModel iMovieOverviewModel;
    private SOService mService;


    public IMoviedetailsPresenterImpl(IMovieOverview_view iMovieDeatilsView_view) {

        this.iMovieOverview_view = iMovieDeatilsView_view;
        iMovieOverviewModel = new MovieOverviewModelImpl(this);
        mService = ApiUtils.getSOService();
    }

  /*  public IMoviedetailsPresenterImpl(IMovieDeatilsView iMovieDeatilsView) {

        this.iMovieDeatilsView = iMovieDeatilsView;
        iMovieOverviewModel = new MovieOverviewModelImpl(this);
        mService = ApiUtils.getSOService();
    }*/


    @Override
    public void loaddata(int MovieId) {

        System.out.println("MOvie ID "+ MovieId);

        mService.getMovieDetails(MovieId,TMDB_API).enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(Call<MovieDetails> call, Response<MovieDetails> response) {

                if(response.isSuccessful()) {

                    System.out.println("getOverview "+ response.body().getOverview());

                    iMovieOverview_view.getBackDropPath(response.body().getBackdropPath());
                    iMovieOverview_view.updateOverView(response.body().getOverview());
                    iMovieOverview_view.updateTitle(response.body().getTitle());

                }else {

                    int statusCode  = response.code();

                }

            }

            @Override
            public void onFailure(Call<MovieDetails> call, Throwable t) {
                System.out.println("onFailure "+ call.toString());
            }


        });


    }
}
