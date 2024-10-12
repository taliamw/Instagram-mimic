package com.example.myinstagram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontFamily
import com.example.myinstagram.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Preview
@Composable
fun MyApp() {
    // Using MaterialTheme from Material3
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier.fillMaxSize() // Ensure Box fills the entire screen
            ) {
                // Scrollable content (Column)
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxHeight()
                        .verticalScroll(rememberScrollState()) // Enable scrolling
                ) {
                    // First Row with "Instagram" text
                    Row(
                        modifier = Modifier
                            .padding(all = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.insta_icon),
                            contentDescription = "Instagram icon",
                            modifier = Modifier.size(34.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Instagram", fontSize = 24.sp,
                            fontFamily = FontFamily.Cursive
                        )
                    }

                    Divider(modifier = Modifier.padding(6.dp))

                    // Row of Circles for stories
                    Row(
                        modifier = Modifier.padding(all = 12.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        CircularPhoto(imageResId = R.drawable.image1)
                        CircularPhoto(imageResId = R.drawable.image2)
                        CircularPhoto(imageResId = R.drawable.image3)
                        CircularPhoto(imageResId = R.drawable.image4)
                        CircularPhoto(imageResId = R.drawable.image5)
                    }

                    Divider(modifier = Modifier.padding(6.dp))

                    // Username section
                    UserProfileSection("natalia_mw", R.drawable.image1)

                    Divider(modifier = Modifier.padding(1.dp))

                    // Square photo section
                    SquareImage()

                        Text(
                            text = "This is my first post \uD83D\uDE02",
                            modifier = Modifier
                                .padding(8.dp),
                            fontSize = 16.sp
                        )

                    // Like button
                    LikeButtonRow()

                    Divider(modifier = Modifier.padding(1.dp))

                    // Another Username and Photo Section
                    UserProfileSection("taliadraws", R.drawable.image3)

                    Divider(modifier = Modifier.padding(1.dp))

                    SquareImage2()

                    LikeButtonRow()

                    // Another Username and Photo Section
                    UserProfileSection("daily_memes", R.drawable.image5)

                    Divider(modifier = Modifier.padding(1.dp))

                    SquareImage3()

                    LikeButtonRow()
                }

                // Bottom menu (fixed at the bottom)
                HorizontalMenu(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter) // Align to the bottom of the screen
                )
            }
        }
    }
}

@Composable
fun CircularPhoto(imageResId: Int) {
    Box(
        modifier = Modifier
            .size(81.dp)
            .clip(CircleShape)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Magenta, Color.Cyan)
                ),
                shape = CircleShape
            )
            .padding(4.dp)
    ){
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "Circular Photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)

        )
    }
}

@Composable
fun UserProfileSection(username: String, imageResId: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Circle profile picture
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape) // Clip the image to be a circle
            )

        Spacer(modifier = Modifier.width(8.dp)) // Add some space between the image and the text
        Text(
            text = username,
            fontSize = 12.sp
        )
    }
}

@Composable
fun SquareImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.image6),
        contentDescription = "Photo",
        contentScale = ContentScale.Crop, // Ensures the image crops to the correct aspect ratio
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Ensures the image is square
            .padding(0.dp)
    )
}
@Composable
fun SquareImage2(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.image1),
        contentDescription = "Photo",
        contentScale = ContentScale.Crop, // Ensures the image crops to the correct aspect ratio
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Ensures the image is square
            .padding(0.dp)
    )
}

@Composable
fun SquareImage3(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.image4),
        contentDescription = "Photo",
        contentScale = ContentScale.Crop, // Ensures the image crops to the correct aspect ratio
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f) // Ensures the image is square
            .padding(0.dp)
    )
}

@Composable
fun LikeButtonRow(
    modifier: Modifier = Modifier,
    onLikeClick: () -> Unit = {},
    onCommentClick: () -> Unit = {},
    onShareClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onLikeClick) {
            Image(
                painter = painterResource(id = R.drawable.heart_icon),
                contentDescription = "Like",
                modifier = Modifier.size(40.dp)
            )
        }

        IconButton(onClick = onCommentClick) {
            Image(
                painter = painterResource(id = R.drawable.comment_icon),
                contentDescription = "Comment",
                modifier = Modifier.size(24.dp)
            )
        }

        IconButton(onClick = onShareClick) {
            Image(
                painter = painterResource(id = R.drawable.share_icon),
                contentDescription = "Share",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun HorizontalMenu(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(1.dp)
            .background(Color.White)
            .size(50.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.home_icon),
            contentDescription = "Home icon"
        )
        Image(
            painter = painterResource(id = R.drawable.plus_icon),
            contentDescription = "Plus icon",
            Modifier.size(30.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.search_icon),
            contentDescription = "Search icon",
            modifier = Modifier
                .size(35.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.profile_icon),
            contentDescription = "Profile icon"
        )
    }
}
