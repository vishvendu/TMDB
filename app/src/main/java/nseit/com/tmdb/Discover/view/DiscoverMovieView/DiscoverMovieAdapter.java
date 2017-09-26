package nseit.com.tmdb.Discover.view.DiscoverMovieView;

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

import nseit.com.tmdb.Discover.model.DiscoverMovieModel.Result;
import nseit.com.tmdb.Discover.presenter.DiscoverMoviePresenter.IMoviepresenter;
import nseit.com.tmdb.R;

import static nseit.com.tmdb.Common.Constant.TMDB_BASEPOSTERURL;


/**
 * Created by vishvendu on 14/8/17.
 */

public class DiscoverMovieAdapter extends RecyclerView.Adapter<DiscoverMovieAdapter.ViewHolder> {


    private List<Result> discoverMovieResult;
    private Context mContext;
    private int itemLayout;
    IMoviepresenter iMoviepresenter;

  /*  public DiscoverMovieAdapter(List<Result> discoverMovieResult, Context context, int itemLayout) {
        this.discoverMovieResult = discoverMovieResult;
        this.context = context;
        this.itemLayout = itemLayout;
    }*/

    public DiscoverMovieAdapter(Context context, int itemLayout) {

        this.mContext = context;
        this.itemLayout = itemLayout;
        discoverMovieResult = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(itemLayout,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.title.setText(discoverMovieResult.get(position).getTitle());
        holder.rating.setText(discoverMovieResult.get(position).getVoteAverage().toString());
        holder.description.setText(discoverMovieResult.get(position).getOverview().toString());
        //holder.poster.setImageResource(discoverMovieResult.get(position).getTitle());
        Glide.with(mContext)
                .load(Uri.parse(TMDB_BASEPOSTERURL+discoverMovieResult.get(position).getPosterPath()))
                .into(holder.posterView);
    }

    @Override
    public int getItemCount() {
        return discoverMovieResult.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
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

    public void setDiscoverMovieResult(List<Result> items) {
        discoverMovieResult = items;

    }


}
