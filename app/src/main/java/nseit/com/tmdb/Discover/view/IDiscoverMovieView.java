package nseit.com.tmdb.Discover.view;

import java.util.List;

import nseit.com.tmdb.Discover.model.Result;


/**
 * Created by vishvendu on 11/8/17.
 */

public interface IDiscoverMovieView {

    void showProgress();
    void hideProgress();
    void updateRecyclerView(List<Result> list);
    void showMessage(String message);

}
