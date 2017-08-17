package nseit.com.tmdb.Discover.model;

import java.util.ArrayList;

import nseit.com.tmdb.Discover.RetroClient.*;
import nseit.com.tmdb.Discover.presenter.IMoviepresenter;

/**
 * Created by vishvendu on 17/8/17.
 */

public class DiscoverMovieModelImpl implements DiscoverMovieModel{

  private  IMoviepresenter iMoviepresenter;

    public DiscoverMovieModelImpl(IMoviepresenter iMoviepresenter) {
        this.iMoviepresenter = iMoviepresenter;
    }

    @Override
    public void DiscoverMovieModel() {


        iMoviepresenter.updateRecyclerView(new ArrayList<Result>());
    }
}
