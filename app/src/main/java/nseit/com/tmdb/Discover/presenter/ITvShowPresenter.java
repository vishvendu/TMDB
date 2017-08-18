package nseit.com.tmdb.Discover.presenter;

import java.util.List;

import nseit.com.tmdb.Discover.model.ResultTvShow;

/**
 * Created by vishvendu on 18/8/17.
 */

public interface ITvShowPresenter {

    void updateRecyclerView(List<ResultTvShow> resultTvShows);
    void discoverTvShow();

}
