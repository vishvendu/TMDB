package nseit.com.tmdb.Discover.view.MovieDetailsViews;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import nseit.com.tmdb.Discover.commondiscover.MovieDeatilsPager;
import nseit.com.tmdb.Discover.presenter.MovieDetailsPresenter.IMovieDetailsPresenter;
import nseit.com.tmdb.Discover.presenter.MovieDetailsPresenter.IMoviedetailsPresenterImpl;
import nseit.com.tmdb.R;

import static nseit.com.tmdb.Common.Constant.TMDB_BACKDROPPATH;


public class MovieDetailsView extends AppCompatActivity implements IMovieOverview_view,TabLayout.OnTabSelectedListener {

    private View v ;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private MovieDeatilsPager adapter;
    private int MovieId ;
    private IMovieDetailsPresenter iMovieDetailsPresenter;
    private ImageView Posterbackdrop;
    int pStatus = 0;
    private Handler handler = new Handler();
    ProgressBar mProgress;
    TextView movieTitletextview;

    public MovieDetailsView() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_movie_details_view);
        getIntentData();
        initView();
    }

    private void getIntentData() {

        MovieId = getIntent().getIntExtra("SelectedMovieID",0);
    }
    private void initView() {

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        Posterbackdrop = (ImageView)findViewById(R.id.posterbackdrop);
        movieTitletextview = (TextView)findViewById(R.id.moviename);
        iMovieDetailsPresenter = new IMoviedetailsPresenterImpl(this);
        iMovieDetailsPresenter.loaddata(MovieId);
        setUpViewPager(viewPager);

    }
    private void setUpViewPager(ViewPager viewPager) {

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Info"));
        tabLayout.addTab(tabLayout.newTab().setText("Characters"));
        tabLayout.addTab(tabLayout.newTab().setText("Reviews"));
        tabLayout.addTab(tabLayout.newTab().setText("Related"));
        adapter = new MovieDeatilsPager(getSupportFragmentManager(), tabLayout.getTabCount());


        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
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

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void getBackDropPath(String path) {

        Glide.with(Posterbackdrop.getContext())
                .load(TMDB_BACKDROPPATH+path)
                .into(Posterbackdrop);

    }


    @Override
    public void updateOverView(String overView) {

    }

    @Override
    public void updateTitle(String title) {

        movieTitletextview.setText(title);
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
}
