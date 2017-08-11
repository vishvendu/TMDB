package nseit.com.tmdb.Discover.RetroClient;

import static nseit.com.tmdb.Common.Constant.TMDB_BASEURL;

/**
 * Created by vishvendu on 11/8/17.
 */

public class ApiUtils {



    public static SOService getSOService() {
        return RetrofitClient.getClient(TMDB_BASEURL).create(SOService.class);
    }

}
