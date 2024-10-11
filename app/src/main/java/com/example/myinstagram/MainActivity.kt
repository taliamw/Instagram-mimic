import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
                        Text(text = "Instagram", fontSize = 24.sp)
                    }

                    Divider(modifier = Modifier.padding(6.dp))

                    // Row of Circles (Your Original Component)
                    Row(
                        modifier = Modifier.padding(all = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        repeat(5) {
                            CircularPhoto(imageResId = R.drawable.image1)
                        }
                    }

                    Divider(modifier = Modifier.padding(6.dp))

                    // Username section
                    UserProfileSection("natalia_mw", R.drawable.image1)

                    Divider(modifier = Modifier.padding(1.dp))

                    // Square photo section
                    SquareImage()

                    // Like button
                    LikeButtonRow()

                    Divider(modifier = Modifier.padding(1.dp))

                    // Another Username and Photo Section
                    UserProfileSection("natalia_mw", R.drawable.image1)

                    Divider(modifier = Modifier.padding(1.dp))

                    SquareImage()
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
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = "Circular Photo",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape) // Clip to a circle shape
            .padding(4.dp)
    )
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
        painter = painterResource(id = R.drawable.image1), // Replace with your image resource
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
            Icon(
                painter = painterResource(id = R.drawable.image1), // Your like icon
                contentDescription = "Like",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }

        IconButton(onClick = onCommentClick) {
            Icon(
                painter = painterResource(id = R.drawable.image1), // Your comment icon
                contentDescription = "Comment",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }

        IconButton(onClick = onShareClick) {
            Icon(
                painter = painterResource(id = R.drawable.image1), // Your share icon
                contentDescription = "Share",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun HorizontalMenu(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .padding(16.dp)
            .background(Color.LightGray) // Optional styling
    ) {
        Text("Home", modifier = Modifier.clickable { })
        Text("Search", modifier = Modifier.clickable { })
        Text("Profile", modifier = Modifier.clickable { })
    }
}
