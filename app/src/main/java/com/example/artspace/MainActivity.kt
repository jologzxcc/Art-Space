package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)){
                        DisplayPainting()
                    }
                }
            }
        }
    }
}

@Composable
fun DisplayPainting(modifier: Modifier = Modifier) {
    var changePainting by remember { mutableStateOf(1) }
    var changePaintingName by remember { mutableStateOf(1)}
    var changePaintingArtist by remember { mutableStateOf(1) }

    val painting = when(changePainting){
        1 -> R.drawable.pearl
        2 -> R.drawable.monalisa
        else -> {R.drawable.scream}
    }

    val paintingName = when(changePaintingName){
        1 -> R.string.pearl_name
        2 -> R.string.monalisa_name
        else -> {R.string.scream_name}
    }

    val paintingArtist = when(changePaintingArtist){
        1 -> R.string.pearl_artist
        2 -> R.string.monalisa_artist
        else -> {R.string.scream_artist}
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {

        ChangePainting(painting = painting, paintingName = paintingName,
            paintingArtist = paintingArtist,
            paintingDescription = stringResource(paintingName))

        Row(modifier = Modifier.padding(top = 80.dp)){
            Button(onClick = {
                if(changePainting > 1 && changePaintingName > 1 && changePaintingArtist > 1){
                    changePainting--
                    changePaintingName--
                    changePaintingArtist--
                }else{
                    changePainting = 1
                    changePaintingName = 1
                    changePaintingArtist = 1
                }
            }, modifier = Modifier.padding(end = 120.dp)) {
                Text(text = stringResource(R.string.prev))
            }
            Button(onClick = {
                changePainting++
                changePaintingName++
                changePaintingArtist++
            }) {Text(text = stringResource(R.string.next))

            }
        }
    }
}

@Composable
fun ChangePainting(painting: Int, paintingName: Int, paintingArtist: Int, paintingDescription: String){
    Image(modifier = Modifier.size(350.dp), painter = painterResource(painting), contentDescription = paintingDescription)
    Text(modifier = Modifier.padding(10.dp),
        text = stringResource(paintingName),
        textAlign = TextAlign.Center,
        fontSize = 22.sp,
        fontWeight= FontWeight.Bold
    )
    Text(text = stringResource(paintingArtist))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        DisplayPainting()
    }
}