package com.example.mygames2.data.model

import com.google.gson.annotations.SerializedName

data class Game(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("short_description") val shortDescription: String,
    @SerializedName("game_url") val gameUrl: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("platform") val platform: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("developer") val developer: String,
    @SerializedName("release_date") val releaseDate: String
)
