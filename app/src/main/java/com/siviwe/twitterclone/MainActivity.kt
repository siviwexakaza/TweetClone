package com.siviwe.twitterclone

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Comment
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material.icons.outlined.Share

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import com.siviwe.twitterclone.data.MockData
import com.siviwe.twitterclone.model.Tweet
import com.siviwe.twitterclone.ui.theme.TwitterCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitterCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val tweets = MockData.tweets
                    TweetList(tweets = tweets)
                }
            }
        }
    }
}

@Composable
fun TweetList(tweets: List<Tweet>){
    LazyColumn{
        items(tweets.size){ index ->
            Spacer(modifier = Modifier.height(8.dp))
            Tweet(tweets[index])
            Spacer(modifier = Modifier.height(2.dp))
            Divider(
                color = Color.LightGray,
                thickness = 0.4.dp
            )
        }
    }
}

@Composable
fun Tweet(tweet: Tweet){
    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        Column() {

            Image(
                painter = rememberCoilPainter(
                    request = tweet.user.profilePic),
                contentDescription = "Profile Pic",
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row{
                Text(
                    text = tweet.user.name,
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )

                Text(
                    text = tweet.user.username,
                    style = TextStyle(
                        color = Color.Gray,
                    )
                )

                Text(
                    text = tweet.date,
                    style = TextStyle(
                        color = Color.Gray,
                    )
                )
            }
            Spacer(modifier = Modifier.height(5.dp) )
            Text(
                text = tweet.text
            )

            if(tweet.hasImage){
                tweet.imageUrl?.let{
                    Spacer(modifier = Modifier.height(5.dp))
                    Image(
                        painter = rememberCoilPainter(request = it),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Comment,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint= Color.LightGray
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Refresh,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint= Color.LightGray
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint= Color.LightGray
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Share,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint= Color.LightGray
                    )
                }
            }
        }
    }
}



