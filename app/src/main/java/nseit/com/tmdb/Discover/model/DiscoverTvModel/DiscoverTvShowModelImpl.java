package nseit.com.tmdb.Discover.model.DiscoverTvModel;

import nseit.com.tmdb.Discover.model.DiscoverMovieModel.IDiscoverMovieModel;
import nseit.com.tmdb.Discover.presenter.DiscoverTvPresenter.ITvShowPresenter;

/**
 * Created by vishvendu on 18/8/17.
 */

public class DiscoverTvShowModelImpl implements IDiscoverMovieModel {

    ITvShowPresenter iTvShowPresenter;

    public DiscoverTvShowModelImpl(ITvShowPresenter iTvShowPresenter) {

        this.iTvShowPresenter = iTvShowPresenter;
    }

    @Override
    public void DiscoverMovieModel() {

    }
}
