package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class BikeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BikeScreen()
                }
            }
        }
    }
}

@Composable
fun BikeScreen(){
    val CustomBlue = colorResource(id =R.color.Blue)
    Surface{
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.im_bike),
                contentDescription = "Bike image",
                modifier = Modifier.size(400.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Mudah dalam bertransaksi, " +
                        "dengan  Jumot",
                fontSize = 25.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Beli kendaraan sesuai minatmu dan dengan " +
                        "harga negosiasi terbaik",
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(modifier = Modifier
                .fillMaxWidth(),
                shape = RoundedCornerShape(25),
                colors = ButtonDefaults.buttonColors(CustomBlue),
                onClick = {}
            )
                {
                    Text("Masuk",
                        fontSize = 20.sp,
                        color = Color.White)
                }
            Spacer(modifier = Modifier.height(16.dp))
            Button(modifier = Modifier
                .fillMaxWidth(),
                shape = RoundedCornerShape(25),
                colors = ButtonDefaults.buttonColors(Color.White),
                border = BorderStroke(1.dp, CustomBlue),
                onClick = {}
            )
            {
                Text("Mendaftar",
                    fontSize = 20.sp,
                    color = CustomBlue)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BikeScreenPreview() {
    ComposeApplicationTheme {
        BikeScreen()
    }
}