package nseit.com.tmdb.Discover.commondiscover;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by vishvendu on 15/9/17.
 */

public class FragmentOrganizer {


    private Context mContext;
    private Activity mActivity;
    public static FragmentTransaction fragmentTransaction;


    public static void inflateFragment(Fragment fragment, FragmentManager fragmentManager, int fragmentContainer, Bundle bundle) {
        fragment.setArguments(bundle);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragmentContainer, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }



}
