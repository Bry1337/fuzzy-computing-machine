/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.api.utils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by bry1337 on 13/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class RetrofitException extends RuntimeException {

  private final String url;
  private final Response response;
  private final Kind kind;
  private final Retrofit retrofit;

  public RetrofitException(Builder builder) {
    super(builder.message, builder.exception);
    this.url = builder.url;
    this.response = builder.response;
    this.kind = builder.kind;
    this.retrofit = builder.retrofit;
  }

  /** The request URL which produced the error. */
  public String getUrl() {
    return url;
  }

  /** Response object containing status code, headers, body, etc. */
  public Response getResponse() {
    return response;
  }

  /** The event kind which triggered this error. */
  public Kind getKind() {
    return kind;
  }

  /** The Retrofit this request was executed on */
  public Retrofit getRetrofit() {
    return retrofit;
  }

  /**
   * HTTP response body converted to specified {@code type}. {@code null} if there is no
   * response.
   *
   * @throws IOException if unable to convert the body to the specified {@code type}.
   */
  public <T> T getErrorBodyAs(Class<T> type) throws IOException {
    if (response == null || response.errorBody() == null) {
      return null;
    }
    Converter<ResponseBody, T> converter = retrofit.responseBodyConverter(type, new Annotation[0]);
    return converter.convert(response.errorBody());
  }

  public static RetrofitException httpError(String url, Response response, Retrofit retrofit) {
    final String message = response.code() + " " + response.message();
    return new RetrofitException.Builder(message, null).setUrl(url)
        .setResponse(response)
        .setKind(Kind.HTTP)
        .setRetrofit(retrofit)
        .build();
  }

  public static RetrofitException networkError(final IOException exception) {
    return new RetrofitException.Builder(exception.getMessage(), exception).setUrl(null)
        .setResponse(null)
        .setKind(Kind.NETWORK)
        .setRetrofit(null)
        .build();
  }

  public static RetrofitException unexpectedError(Throwable exception) {
    return new RetrofitException.Builder(exception.getMessage(), exception).setUrl(null)
        .setResponse(null)
        .setKind(Kind.UNEXPECTED)
        .setRetrofit(null)
        .build();
  }

  /** Identifies the event kind which triggered a {@link RetrofitException}. */
  public enum Kind {
    /** An {@link IOException} occurred while communicating to the server. */
    NETWORK, /** A non-200 HTTP status code was received from the server. */
    HTTP, /**
     * An internal error occurred while attempting to execute a request. It is best practice to
     * re-throw this exception so your application crashes.
     */
    UNEXPECTED
  }

  public static class Builder {
    private final Throwable exception;
    private final String message;
    private String url;
    private Response response;
    private Kind kind;
    private Retrofit retrofit;

    public Builder(String message, Throwable exception) {
      this.message = message;
      this.exception = exception;
      this.url = null;
      this.response = null;
      this.kind = null;
      this.retrofit = null;
    }

    public Builder setUrl(String url) {
      this.url = url;
      return this;
    }

    public Builder setResponse(Response response) {
      this.response = response;
      return this;
    }

    public Builder setKind(Kind kind) {
      this.kind = kind;
      return this;
    }

    public Builder setRetrofit(Retrofit retrofit) {
      this.retrofit = retrofit;
      return this;
    }

    public RetrofitException build() {
      return new RetrofitException(this);
    }
  }
}
