package nseit.com.tmdb.Discover.view;

import java.util.List;

import nseit.com.tmdb.Discover.model.Result;
import nseit.com.tmdb.Discover.model.ResultTvShow;

/**
 * Created by vishvendu on 18/8/17.
 */

public interface IDiscoverTvShowView {
    void showProgress();
    void hideProgress();
    void updateRecyclerView(List<ResultTvShow> list);
}
