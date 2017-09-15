package nseit.com.tmdb.Discover.commondiscover;

import android.view.View;

/**
 * Created by vishvendu on 15/9/17.
 */

public interface OnItemClickListner {

    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
