package nseit.com.tmdb.Discover.presenter.DiscoverMoviePresenter;

import java.util.List;

import nseit.com.tmdb.Discover.model.DiscoverMovieModel.Result;


/**
 * Created by vishvendu on 11/8/17.
 */

public interface IMoviepresenter {


    void updateRecyclerView(List<Result> list);
    void fetchMoviesDiscover();

}
