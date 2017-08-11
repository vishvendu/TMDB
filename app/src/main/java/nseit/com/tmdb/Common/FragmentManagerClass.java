package nseit.com.tmdb.Common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by vishvendu on 11/8/17.
 */

public class FragmentManagerClass {

    public static FragmentTransaction fragmentTransaction;

    public static void inflateFragment(Fragment fragment, FragmentManager fragmentManager, int fragmentContainer, Bundle bundle){

        fragment.setArguments(bundle);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragmentContainer,fragment,fragment.getClass().getName());
        fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();

    }

}
