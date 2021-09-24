package com.siviwe.twitterclone.data

import com.siviwe.twitterclone.model.Tweet
import com.siviwe.twitterclone.model.User

object MockData {
    val tweets = listOf(
        Tweet(
            id = 1,
            user = User(
                id = 1,
                name = "Siviwe Xakaza",
                username = "@siviwe",
                profilePic = "https://pbs.twimg.com/profile_images/1429535486683631635/FBBjBBQ4_400x400.jpg"
            ),
            hasImage = true,
            imageUrl = "https://www.rollingstone.com/wp-content/uploads/2021/08/kanye-west-donda-review.jpg",
            numComments = 10,
            numLikes = 121,
            numRetweets = 67,
            date = "21 Sep",
            text = "The self-soilers, the harmony-hushers.\n" +
                    "Even if you are not ready for the day, it cannot always be night"

        ),
    )
}