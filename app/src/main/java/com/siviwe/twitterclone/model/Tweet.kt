package com.siviwe.twitterclone.model

data class Tweet(
    val id: Int,
    val user: User,
    val hasImage: Boolean,
    val imageUrl: String?,
    val numComments: Int,
    val numRetweets: Int,
    val numLikes: Int,
    val date: String,
    val text: String,
)
