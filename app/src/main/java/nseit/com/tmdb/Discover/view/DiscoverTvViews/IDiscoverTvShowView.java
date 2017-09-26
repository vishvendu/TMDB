package nseit.com.tmdb.Discover.view.DiscoverTvViews;

import java.util.List;

import nseit.com.tmdb.Discover.model.DiscoverTvModel.ResultTvShow;

/**
 * Created by vishvendu on 18/8/17.
 */

public interface IDiscoverTvShowView {
    void showProgress();
    void hideProgress();
    void updateRecyclerView(List<ResultTvShow> list);
}
