package nseit.com.tmdb.Discover.presenter;

import java.util.List;

import nseit.com.tmdb.Discover.model.Result;


/**
 * Created by vishvendu on 11/8/17.
 */

public interface IDiscoverOnScreenView {

    void showProgress();
    void hideProgress();
    void updateRecyclerView(List<Result> list);

}
