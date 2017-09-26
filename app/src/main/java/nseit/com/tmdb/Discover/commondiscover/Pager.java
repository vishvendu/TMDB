package nseit.com.tmdb.Discover.commondiscover;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import nseit.com.tmdb.Discover.view.DiscoverMovieView.DiscoverMovieView;
import nseit.com.tmdb.Discover.view.DiscoverTvViews.DiscoverTvView;

/**
 * Created by vishvendu on 11/8/17.
 */

public class Pager extends FragmentStatePagerAdapter{

    int tabCount;
    FragmentManager mFragmentManager;

    private Fragment mFragmentAtPos0;


    public Pager(FragmentManager fm,int tabCount) {
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

       }
        return fragment;

    }

    @Override
    public int getCount() {
        return tabCount;
    }



    @Override
    public int getItemPosition(Object object)
    {

        return POSITION_NONE;
    }
}
