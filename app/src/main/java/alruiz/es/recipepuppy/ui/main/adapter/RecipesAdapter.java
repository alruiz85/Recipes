package alruiz.es.recipepuppy.ui.main.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import alruiz.es.recipepuppy.R;
import alruiz.es.recipepuppy.domain.model.Recipe;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Comment.
 */
public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {

    private Context context;
    private List<Recipe> recipes;

    @Inject
    RecipesAdapter(Context context) {
        this.recipes = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_main, parent, false);
        return new RecipeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        holder.tvTitle.setText(recipes.get(position).getTitle());
        Glide.with(context)
                .load(recipes.get(position).getThumbnail())
                .apply(new RequestOptions().placeholder(R.drawable.ic_placeholder).error(R.drawable.ic_placeholder))
                .into(holder.imgThumbnail);
    }

    public void setItems(List<Recipe> newsItem) {
        recipes.addAll(newsItem);
        notifyDataSetChanged();
    }

    public void clearItems() {
        recipes.clear();
        //page = RepositoryImpl.FIRST_PAGE;
        notifyDataSetChanged();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    static class RecipeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.img_thumbnail)
        ImageView imgThumbnail;

        RecipeViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }


}