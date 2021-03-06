package com.example.mohamed.popularmovies.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mohamed.popularmovies.R;
import com.example.mohamed.popularmovies.databinding.ActorListItemBinding;
import com.example.mohamed.popularmovies.model.Actor;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



/**
 * Created by mohamed
 */

public class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ActorsViewHolder> {
    private Context context;
    private ArrayList<Actor> actors;

    public ActorsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ActorsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ActorListItemBinding itemBinding = ActorListItemBinding.inflate(inflater, parent, false);
        return new ActorsViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(ActorsViewHolder holder, int position) {
        Actor actor = actors.get(position);
        holder.bind(actor);
    }

    @Override
    public int getItemCount() {
        if (actors == null) return 0;
        return actors.size();
    }

    public void updateData(ArrayList<Actor> newActors) {
        this.actors = newActors;
        notifyDataSetChanged();
    }

    public class ActorsViewHolder extends RecyclerView.ViewHolder {
        private final ActorListItemBinding itemBinding;

        public ActorsViewHolder(ActorListItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void bind(Actor actor) {
            Picasso.with(context).load(context.getString(R.string.movies_db_actor_image_base_url_w342) + actor.getProfileImage()).into(itemBinding.actorImageView);
            itemBinding.setActor(actor);
            itemBinding.executePendingBindings();
        }
    }
}
