package com.troxumenko.seeker.api

import com.troxumenko.seeker.data.UnsplashPhoto

data class UnsplashResponse(
    val results: List<UnsplashPhoto>
)