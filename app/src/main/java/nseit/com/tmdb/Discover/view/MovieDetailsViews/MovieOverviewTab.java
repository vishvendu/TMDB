package nseit.com.tmdb.Discover.view.MovieDetailsViews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nseit.com.tmdb.Discover.presenter.MovieDetailsPresenter.IMovieDetailsPresenter;
import nseit.com.tmdb.Discover.presenter.MovieDetailsPresenter.IMoviedetailsPresenterImpl;
import nseit.com.tmdb.R;


public class MovieOverviewTab extends Fragment implements IMovieOverview_view {

    private View view ;
    private int MovieId;
    private IMovieDetailsPresenter iMovieDetailsPresenter;
    private TextView OverViewText;
    public MovieOverviewTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view  = inflater.inflate(R.layout.fragment_movie_overview_tab, container, false);
        intiFragment(view);
        return view;
    }

    private void intiFragment(View view) {


         OverViewText = (TextView)view.findViewById(R.id.movieoverview);
         MovieId = getActivity().getIntent().getIntExtra("SelectedMovieID",0);
         iMovieDetailsPresenter = new IMoviedetailsPresenterImpl(this);
         iMovieDetailsPresenter.loaddata(MovieId);

    }



    public static MovieOverviewTab newInstance(String text) {

        MovieOverviewTab f = new MovieOverviewTab();
        return f;
    }

    @Override
    public void updateOverView(String overView) {

        System.out.println("Data aaya "+ overView);
        OverViewText.setText(overView);

    }

    @Override
    public void updateTitle(String title) {

    }

    @Override
    public void updateDirectorView(String directorView) {

    }

    @Override
    public void updateProducerView(String producerView) {

    }

    @Override
    public void updateWriterView(String writerView) {

    }

    @Override
    public void getBackDropPath(String path) {

    }


}

