package com.example.the_movie_app.data.vos

data class MainVO (
    var popular : List<PopularMovieVO> = listOf(),
    var actor : List<ActorsVO> = listOf(),
    var nowPlayingMovie : List<NowPlayingMoviesVO> = listOf(),
    var topRated : List<MovieReviewVO> = listOf(),
    var genre : List<MovieGenreVO> = listOf()
)