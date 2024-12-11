package com.example.ArtSpace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ArtSpace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    var taker by remember { mutableIntStateOf(1) }

    val imageRes = when (taker) {
        1 -> R.drawable.artke1
        2 -> R.drawable.artke2
        3 -> R.drawable.artke3
        else -> R.drawable.ic_launcher_background
    }

    val artworkTitle = when (taker) {
        1 -> R.string.arttitle1
        2 -> R.string.arttitle2
        3 -> R.string.arttitle3
        else -> R.string.arttitle1
    }

    val artworkArtist = when (taker) {
        1 -> R.string.artist1
        2 -> R.string.artist2
        3 -> R.string.artist3
        else -> R.string.artist1
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .size(height = 500.dp, width = 350.dp)
                .border(BorderStroke(3.dp, Color.Gray), RectangleShape)
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(36.dp)
                    .border(BorderStroke(2.dp, Color.LightGray), RectangleShape)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(300.dp)
                .height(80.dp)
                .background(Color(0xFFE0E0E0), shape = RectangleShape)
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(artworkTitle),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = stringResource(artworkArtist),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    taker = if (taker > 1) taker - 1 else 3
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF89d88a)),
                modifier = Modifier
                    .size(width = 120.dp, height = 50.dp)
                    .clip(MaterialTheme.shapes.small)
            ) {
                Text(text = "Previous")
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = {
                    taker = if (taker < 3) taker + 1 else 1
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF89d88a)),
                modifier = Modifier
                    .size(width = 120.dp, height = 50.dp)
                    .clip(MaterialTheme.shapes.small)
            ) {
                Text(text = "Next")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}