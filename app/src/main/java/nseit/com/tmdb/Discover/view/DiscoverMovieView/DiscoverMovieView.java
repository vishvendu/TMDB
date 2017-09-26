package nseit.com.tmdb.Discover.view.DiscoverMovieView;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;


import nseit.com.tmdb.Discover.ClickListner.RecyclerTouchListener;
import nseit.com.tmdb.Discover.commondiscover.OnItemClickListner;
import nseit.com.tmdb.Discover.model.DiscoverMovieModel.Result;
import nseit.com.tmdb.Discover.presenter.DiscoverMoviePresenter.IMoviepresenter;
import nseit.com.tmdb.Discover.presenter.DiscoverMoviePresenter.MoviepresenterImpl;
import nseit.com.tmdb.Discover.view.MovieDetailsViews.MovieDetailsView;
import nseit.com.tmdb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverMovieView extends Fragment implements IDiscoverMovieView {

    private View v;
    private IMoviepresenter iMoviepresenter;
    private RecyclerView recyclerView;
    private DiscoverMovieAdapter discoverMovieAdapter;
    private FragmentManager fragmentManager;

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
    public void updateRecyclerView(final List<Result> discoverResultList) {

        discoverMovieAdapter.setDiscoverMovieResult(discoverResultList);
        discoverMovieAdapter.notifyDataSetChanged();
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new OnItemClickListner() {
            @Override
            public void onClick(View view, int position) {
                Result result = discoverResultList.get(position);
                startActivity(new Intent(getActivity(), MovieDetailsView.class)
                        .putExtra("SelectedMovieID", result.getId()));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    public void showMessage(String message) {

        System.out.println("Item clicked");
        Toast.makeText(getActivity(),"item clicked "+message,Toast.LENGTH_LONG).show();
    }


}
