package nseit.com.tmdb.Discover.presenter.DiscoverTvPresenter;

import java.util.List;

import nseit.com.tmdb.Discover.model.DiscoverTvModel.ResultTvShow;

/**
 * Created by vishvendu on 18/8/17.
 */

public interface ITvShowPresenter {

    void updateRecyclerView(List<ResultTvShow> resultTvShows);
    void discoverTvShow();

}
