/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.ui.activities.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fcm.fuzzycomputingmachine.R;
import com.fcm.fuzzycomputingmachine.models.Article;
import com.fcm.fuzzycomputingmachine.ui.utils.OnBindViewListener;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by bry1337 on 14/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {

  private final Context context;
  private final List<Article> articleList;

  public MainActivityAdapter(Context context, List<Article> articleList) {
    this.context = context;
    this.articleList = articleList;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_news, parent, false));
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Article article = articleList.get(position);
    holder.onBind(article);
  }

  @Override public int getItemCount() {
    return articleList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder implements OnBindViewListener {

    TextView tvNewsTitle;

    public ViewHolder(View itemView) {
      super(itemView);
      tvNewsTitle = itemView.findViewById(R.id.tvNewsTitle);
    }

    @Override public void onBind(Object object) {
      Article article = (Article) object;

      if (article != null) {
        displayNewsTitle(article);
      }
    }

    private void displayNewsTitle(Article article) {
      if (article.getTitle() != null && StringUtils.isNotEmpty(article.getTitle())) {
        tvNewsTitle.setText(article.getTitle());
      }
    }
  }
}
