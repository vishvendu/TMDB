package nseit.com.tmdb.Discover.view;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import nseit.com.tmdb.Discover.commondiscover.MovieDeatilsPager;
import nseit.com.tmdb.Discover.commondiscover.OnItemClickListner;
import nseit.com.tmdb.Discover.commondiscover.Pager;
import nseit.com.tmdb.R;


public class MovieDetailsView extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private View v ;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MovieDeatilsPager adapter;

    public MovieDetailsView() {
        // Required empty public constructor
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_movie_details_view);
        initView();
    }

    private void setUpViewPager(ViewPager viewPager) {

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Info"));
        tabLayout.addTab(tabLayout.newTab().setText("Characters"));
        tabLayout.addTab(tabLayout.newTab().setText("Reviews"));
        tabLayout.addTab(tabLayout.newTab().setText("Related"));
        adapter = new MovieDeatilsPager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
        setupTabTexts();
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);




    }

    private void setupTabTexts() {



            tabLayout.getTabAt(0).setText("Info");
            tabLayout.getTabAt(1).setText("Characters");
            tabLayout.getTabAt(2).setText("Reviews");
            tabLayout.getTabAt(3).setText("Related");




    }

    private void initView() {

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        setUpViewPager(viewPager);

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


}
