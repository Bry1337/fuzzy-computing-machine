/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.models;

/**
 * Created by bry1337 on 14/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

import com.google.gson.annotations.SerializedName;

public class Article {

  @SerializedName("author") private String author;

  @SerializedName("title") private String title;

  @SerializedName("description") private String description;

  @SerializedName("url") private String url;

  @SerializedName("urlToImage") private String urlToImage;

  @SerializedName("publishedAt") private String publishedAt;

  public Article() {
    //Intended to be empty.
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getUrl() {
    return url;
  }

  public String getUrlToImage() {
    return urlToImage;
  }

  public String getPublishedAt() {
    return publishedAt;
  }
}
