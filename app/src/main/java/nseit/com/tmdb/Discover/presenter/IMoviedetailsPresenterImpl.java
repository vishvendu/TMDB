package nseit.com.tmdb.Discover.presenter;

import android.widget.Toast;

import nseit.com.tmdb.Discover.view.IMovieDeatilsView;
import nseit.com.tmdb.Discover.view.MovieDetailsView;

/**
 * Created by vishvendu on 18/9/17.
 */

public class IMoviedetailsPresenterImpl implements IMovieDetailsPresenter {


    public IMoviedetailsPresenterImpl(IMovieDeatilsView iMovieDeatilsView) {

    }

    @Override
    public void loaddata(int MovieId) {

        System.out.println("MOvie ID "+ MovieId);
    }
}
