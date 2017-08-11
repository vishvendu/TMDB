package nseit.com.tmdb.Discover.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nseit.com.tmdb.Discover.presenter.DiscoverOnScreenView;
import nseit.com.tmdb.Discover.presenter.IMoviepresenter;
import nseit.com.tmdb.Discover.presenter.MoviepresenterImpl;
import nseit.com.tmdb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverMovieView extends Fragment implements DiscoverOnScreenView{

    private View v;
    private IMoviepresenter iMoviepresenter;

    public DiscoverMovieView() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_discover_view, container, false);
        intiFragment(v);
        return v;
    }

    public static DiscoverMovieView newInstance(String text) {

        DiscoverMovieView f = new DiscoverMovieView();
        return f;
    }

    private void intiFragment(View v) {


        iMoviepresenter = new MoviepresenterImpl(this);
        iMoviepresenter.fetchMoviesDiscover();

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
