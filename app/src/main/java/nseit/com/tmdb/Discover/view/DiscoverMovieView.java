package nseit.com.tmdb.Discover.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


import nseit.com.tmdb.Discover.model.Result;
import nseit.com.tmdb.Discover.presenter.IDiscoverOnScreenView;
import nseit.com.tmdb.Discover.presenter.IMoviepresenter;
import nseit.com.tmdb.Discover.presenter.MoviepresenterImpl;
import nseit.com.tmdb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverMovieView extends Fragment implements IDiscoverOnScreenView {

    private View v;
    private IMoviepresenter iMoviepresenter;
    private RecyclerView recyclerView;
    private DiscoverMovieAdapter discoverMovieAdapter;

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
        recyclerView = (RecyclerView) v.findViewById(R.id.discovermovielist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        discoverMovieAdapter = new DiscoverMovieAdapter(getContext(),R.layout.discovermovieitems);
        recyclerView.setAdapter(discoverMovieAdapter);
        iMoviepresenter.fetchMoviesDiscover();

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void updateRecyclerView(List<Result> discoverResultList) {

        discoverMovieAdapter.setDiscoverMovieResult(discoverResultList);
        discoverMovieAdapter.notifyDataSetChanged();

    }


}
