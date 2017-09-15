package nseit.com.tmdb.Discover.commondiscover;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import nseit.com.tmdb.Discover.view.DiscoverMovieView;
import nseit.com.tmdb.Discover.view.DiscoverTvView;

/**
 * Created by vishvendu on 15/9/17.
 */

public class MovieDeatilsPager extends FragmentStatePagerAdapter {

    int tabCount;
    FragmentManager mFragmentManager;

    private Fragment mFragmentAtPos0;

    public MovieDeatilsPager(FragmentManager fm,int tabCount) {
        super(fm);
        this.tabCount = tabCount;
        this.mFragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){

            case 0:


                fragment = DiscoverMovieView.newInstance("FirstFragment, Instance 1");
                break;

            case 1:

                fragment  = DiscoverTvView.newInstance("FirstFragment, Instance 1");
                break;
            case 2:


                fragment = DiscoverMovieView.newInstance("FirstFragment, Instance 1");
                break;

            case 3:

                fragment  = DiscoverTvView.newInstance("FirstFragment, Instance 1");
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
