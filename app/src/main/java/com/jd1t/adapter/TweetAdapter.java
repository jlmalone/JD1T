package com.jd1t.adapter;

import com.jd1t.R;
import com.jd1t.model.Post;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Joseph on 17.05.15.
 */
public class TweetAdapter<T extends Post> extends RecyclerView.Adapter<TweetAdapter.ViewHolder>
{
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mUsername;
        public TextView mDate;
        public TextView mStatus;
        public ImageView mThumbnail;
        public ImageView mImageView;

       public TextView mLikes;
        public TextView mComments;

        public Button mLikeButton;
        public Button mCommentButton;

        public ImageView mHeart;


        public ViewHolder(RelativeLayout ll)
        {
            super(ll);
//            mContainer = ll;
        }
    }

    private static final String TAG = TweetAdapter.class.getSimpleName();

    private List<T> mDataset;
    private Context context;

    public TweetAdapter(List<T> myDataset, Context context)
    {
        Log.v(TAG, "is myDataset null?"+(myDataset==null));
        mDataset = myDataset;
        this.context = context;
    }

    public void setData(List<T> myDataset)
    {
        mDataset = myDataset;
    }

    @Override
    public TweetAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Log.v(TAG,"onCreateViewHolder "+(parent==null)+" "+viewType );
        RelativeLayout v =(RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        vh.mUsername = (TextView) v.findViewById(R.id.username_status);
        vh.mDate = (TextView) v.findViewById(R.id.date);
        vh.mImageView = (ImageView)v.findViewById(R.id.post_image);
        vh.mComments = (TextView)v.findViewById(R.id.comments);
        vh.mLikes = (TextView)v.findViewById(R.id.likes);
        vh.mCommentButton = (Button)v.findViewById(R.id.comment_button);
        vh.mLikeButton = (Button)v.findViewById(R.id.like);
        vh.mStatus = (TextView)v.findViewById(R.id.comment);
        vh.mThumbnail = (ImageView)v.findViewById(R.id.poster_thumbnail);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {

        Log.v(TAG,"onBindViewHolder " +mDataset.get(position).getAuthor().getThumbnailUrl()+" "+mDataset.get(position).getImageUrl());

        holder.mStatus.setText(mDataset.get(position).getText());
        holder.mUsername.setText("@"+mDataset.get(position).getAuthor().getUsername());
        holder.mDate.setText(mDataset.get(position).getDateCreated()+"");
        holder.mLikes.setText(mDataset.get(position).getLikes().size()+" Likes    |");
        holder.mComments.setText("    "+mDataset.get(position).getComments().size()+" Comments");
        Picasso.with(context)

                .load("http://lorempixel.com/"+(50+position%10)+"/"+(50+position%7)+"/")
                .error(R.drawable.just_do_one_thingbadge_1)
                .placeholder(R.drawable.just_do_one_thingbadge_1)
                .fit().centerInside()
                .into(holder.mThumbnail);
        Picasso.with(context)
                .load("http://lorempixel.com/"+(500+position%10)+"/"+(500+position%7)+"/")
                .fit().centerInside()
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount()
    {
        Log.v(TAG,"get item count "+mDataset.size() );
        return mDataset.size();
    }
}