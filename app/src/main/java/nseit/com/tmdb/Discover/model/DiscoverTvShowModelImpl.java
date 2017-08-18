package nseit.com.tmdb.Discover.model;

import nseit.com.tmdb.Discover.presenter.IMoviepresenter;
import nseit.com.tmdb.Discover.presenter.ITvShowPresenter;
import nseit.com.tmdb.Discover.presenter.TvShowPresenterImpl;

/**
 * Created by vishvendu on 18/8/17.
 */

public class DiscoverTvShowModelImpl implements IDiscoverMovieModel{

    ITvShowPresenter iTvShowPresenter;

    public DiscoverTvShowModelImpl(ITvShowPresenter iTvShowPresenter) {

        this.iTvShowPresenter = iTvShowPresenter;
    }

    @Override
    public void DiscoverMovieModel() {

    }
}
