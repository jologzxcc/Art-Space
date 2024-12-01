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
    var changePainting by remember { mutableStateOf(0) }

    val painting = when(changePainting){
        1 -> R.drawable.pearl
        2 -> R.drawable.monalisa
        else -> {R.drawable.scream}
    }

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Image(modifier = Modifier.size(350.dp), painter = painterResource(painting), contentDescription = null)
        Text(modifier = Modifier.padding(10.dp),
            text = stringResource(R.string.pearl_name),
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            fontWeight= FontWeight.Bold
        )
        Text(text = stringResource(R.string.pearl_artist))
        Row(modifier = Modifier.padding(top = 80.dp)){
            Button(onClick = {
                if(changePainting > 0){
                    changePainting--
                }else{
                    changePainting = 0
                }
            }, modifier = Modifier.padding(end = 150.dp)) {
                Text(text = stringResource(R.string.prev))

            }
            Button(onClick = {
                changePainting++
            }) {Text(text = stringResource(R.string.next))

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        DisplayPainting()
    }
}