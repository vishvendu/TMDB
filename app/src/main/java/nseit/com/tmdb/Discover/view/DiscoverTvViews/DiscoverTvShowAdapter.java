package nseit.com.tmdb.Discover.view.DiscoverTvViews;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import nseit.com.tmdb.Discover.model.DiscoverTvModel.ResultTvShow;
import nseit.com.tmdb.R;

import static nseit.com.tmdb.Common.Constant.TMDB_BASEPOSTERURL;

/**
 * Created by vishvendu on 18/8/17.
 */

public class DiscoverTvShowAdapter extends RecyclerView.Adapter<DiscoverTvShowAdapter.ViewHolder> {


    private Context mContext;
    private int layoutItem;
    private List<ResultTvShow> discovertvshowResult;

    public DiscoverTvShowAdapter(Context Context, int layoutitem) {
        this.mContext = Context;
        this.layoutItem = layoutitem;
        discovertvshowResult = new ArrayList<>();
    }

    public void setDiscoverMovieResult(List<ResultTvShow> items) {
        discovertvshowResult = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layoutItem,parent,false);
       ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(discovertvshowResult.get(position).getOriginalName());
        holder.rating.setText(discovertvshowResult.get(position).getVoteAverage().toString());
        holder.description.setText(discovertvshowResult.get(position).getOverview().toString());
        //holder.poster.setImageResource(discoverMovieResult.get(position).getTitle());

        Glide.with(mContext).load(Uri.parse(TMDB_BASEPOSTERURL+discovertvshowResult.get(position).getPosterPath()))
                .thumbnail(0.5f)
                .into(holder.posterView);



        Glide.with(mContext)
                .load(Uri.parse(TMDB_BASEPOSTERURL+discovertvshowResult.get(position).getPosterPath()))
                .into(holder.posterView);
    }

    @Override
    public int getItemCount() {
        return discovertvshowResult.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView rating;
        TextView description;
        ImageView posterView;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.title);
            rating = (TextView)itemView.findViewById(R.id.rating);
            description = (TextView)itemView.findViewById(R.id.description);
            posterView = (ImageView) itemView.findViewById(R.id.poster);
        }
    }
}
