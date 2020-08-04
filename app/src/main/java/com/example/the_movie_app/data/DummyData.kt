package com.example.the_movie_app.data

import com.example.the_movie_app.data.vos.*

fun getDummyPopularData() : List<PopularMovieVO>{
    val popularList = PopularMovieVO()
    popularList.title = "Outpost"
    popularList.overview = "It is a war movie"
    popularList.id = 3

    return listOf(popularList)
}

fun getDummyActorsData() : List<ActorsVO>{
    val actorList = ActorsVO()
    actorList.name = "Naing Htet Zaw"
    actorList.profilePath = "naingghlgdh"

    return listOf(actorList)
}

fun getDummyMovieReviewData() : List<MovieReviewVO>{
    val movieReview = MovieReviewVO()
    movieReview.title = "Outpost"
    movieReview.posterPath = "ahdhghgdgh"
    movieReview.id = 12

    return listOf(movieReview)
}

fun getDummyNowPlayingMovieData() : List<NowPlayingMoviesVO>{
    val nowPlayingMovie = NowPlayingMoviesVO()
    nowPlayingMovie.originalTitle = "Outpost"
    nowPlayingMovie.id = 5
    nowPlayingMovie.releasedDate = "21.24.2020"

    return listOf(nowPlayingMovie)
}

fun getDummyMovieDetailData() : MovieDetailVO{
    val movieDetail = MovieDetailVO()
    movieDetail.originalTitle = "Outpost"
    movieDetail.overview = "Its is a war movie"
    movieDetail.runtime = 150

    return  movieDetail
}

fun getDummyMovieGenreData() : List<MovieGenreVO>{
    val movieGenre = MovieGenreVO()
    movieGenre.id = 4
    movieGenre.name = "Action"

    return listOf(movieGenre)
}

