package com.jd1t.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jd1t.R;
import com.jd1t.adapter.TweetAdapter;
import com.jd1t.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Joseph on 17.05.15.
 */
public class TimelineActivity extends Activity
{
    //*** Debug Set up Post Holder

    private List<Post> debugPosts;
    private RecyclerView.LayoutManager mLayoutManager;
    private TweetAdapter mAdapter;
    private RecyclerView mRecyclerView;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        populatePosts();
        setContentView(R.layout.timeline_layout);

        mAdapter = new TweetAdapter(debugPosts, this);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        mLayoutManager = new LinearLayoutManager(TimelineActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void populatePosts()
    {
        debugPosts = new ArrayList<>();
        Random r = new Random(System.currentTimeMillis()+10);
        int count = r.nextInt(30);
        for(int i=0;i<count;i++)
        {
            r.setSeed(System.currentTimeMillis()+i*10);
            Post p = Post.getRandomDebug();
            debugPosts.add(p);
        }
    }
}