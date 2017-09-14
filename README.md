# fuzzy-computing-machine

This is a sample project based on Uncle Bob's clean architecture.
* [Uncle Bob's Clean Architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)

## Getting Started

Once you got a copy of this project, you will see that the application is using some open api from News Api.
An open source software that provides news data.

### Prerequisites

* [News Api](https://newsapi.org/)

### Installing

You will need to register on their site and get an API Key to get yourself started, and modify the SOURCE_VALUE 
inside AppConstants file based on your selected news url.

```
public static final String SOURCE_VALUE = "cnn";
```

Once you have done that.
You will also have to add this to your application gradle file inside buildTypes enclosure.

```
buildTypes {
    buildTypes.each {
      it.buildConfigField 'String', 'NEWS_API_KEY', newsApiKey
    }

  }
```

Also don't forget to add newsApiKey inside your gradle.properties file
```
newsApiKey="API KEY GOES HERE"
```
## Built With

* [Retrofit2](http://square.github.io/retrofit/)
* [RxJava](https://github.com/ReactiveX/RxJava)
* [Dagger2](https://google.github.io/dagger/)
* [ButterKnife](http://jakewharton.github.io/butterknife/)
* [OkHttp](http://square.github.io/okhttp/)

## Authors

* **Edward Bryan Abergas** - *Android Developer* - [Bry1337](https://github.com/Bry1337)

[contributor](https://github.com/ceosilvajr) who participated in this project.
