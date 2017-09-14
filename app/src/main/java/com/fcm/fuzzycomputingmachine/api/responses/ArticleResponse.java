/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.api.responses;

import com.fcm.fuzzycomputingmachine.models.Article;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by bry1337 on 14/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class ArticleResponse {

  @SerializedName("status") private String status;

  @SerializedName("source") private String source;

  @SerializedName("sortBy") private String sortBy;

  @SerializedName("articles") private List<Article> articleList;

  public String getStatus() {
    return status;
  }

  public String getSource() {
    return source;
  }

  public String getSortBy() {
    return sortBy;
  }

  public List<Article> getArticleList() {
    return articleList;
  }
}
