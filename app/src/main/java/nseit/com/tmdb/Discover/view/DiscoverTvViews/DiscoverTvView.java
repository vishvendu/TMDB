package nseit.com.tmdb.Discover.view.DiscoverTvViews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nseit.com.tmdb.Discover.model.DiscoverTvModel.ResultTvShow;
import nseit.com.tmdb.Discover.presenter.DiscoverTvPresenter.ITvShowPresenter;
import nseit.com.tmdb.Discover.presenter.DiscoverTvPresenter.TvShowPresenterImpl;
import nseit.com.tmdb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverTvView extends Fragment implements IDiscoverTvShowView {

    private View v;
    private ITvShowPresenter iTvShowPresenter;
    private RecyclerView recyclerView;
    private DiscoverTvShowAdapter discoverTvShowAdapter;

    public DiscoverTvView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_discover_tv_view, container, false);
        initView(v);
        return v;
    }

    private void initView(View v) {

        iTvShowPresenter = new TvShowPresenterImpl(this);
        recyclerView = (RecyclerView)v.findViewById(R.id.discovertvshow);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        discoverTvShowAdapter = new DiscoverTvShowAdapter(getContext(),R.layout.discovermovieitems);
        recyclerView.setAdapter(discoverTvShowAdapter);
        iTvShowPresenter.discoverTvShow();

    }

    public static DiscoverTvView newInstance(String text) {
        DiscoverTvView f = new DiscoverTvView();
        return f;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void updateRecyclerView(List<ResultTvShow> list) {

        discoverTvShowAdapter.setDiscoverMovieResult(list);
        discoverTvShowAdapter.notifyDataSetChanged();
    }
}
