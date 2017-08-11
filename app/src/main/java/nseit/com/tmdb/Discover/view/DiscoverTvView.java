package nseit.com.tmdb.Discover.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nseit.com.tmdb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverTvView extends Fragment {

    private View v;

    public DiscoverTvView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_discover_tv_view, container, false);
        return v;
    }

    public static DiscoverTvView newInstance(String text) {
        DiscoverTvView f = new DiscoverTvView();
        return f;
    }

}
