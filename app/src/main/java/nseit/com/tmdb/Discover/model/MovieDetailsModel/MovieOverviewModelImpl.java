package nseit.com.tmdb.Discover.model.MovieDetailsModel;

import nseit.com.tmdb.Discover.presenter.MovieDetailsPresenter.IMovieDetailsPresenter;

/**
 * Created by vishvendu on 22/9/17.
 */

public class MovieOverviewModelImpl implements IMovieOverviewModel {


    private IMovieDetailsPresenter iMovieDetailsPresenter;

    public MovieOverviewModelImpl(IMovieDetailsPresenter iMoviedetailsPresenter) {

        this.iMovieDetailsPresenter = iMoviedetailsPresenter;
    }

    @Override
    public void movieoverview() {



    }
}
