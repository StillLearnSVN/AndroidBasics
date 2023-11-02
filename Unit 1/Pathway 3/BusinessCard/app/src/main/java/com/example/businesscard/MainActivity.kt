package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF3ddc84)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        CardInfo(
            name = "Samuel Volder",
            title = "Still Learn About Kotlin"
        )
        PersonInfo(
            phone = "+62 1234 56789",
            social = "@samuelvolderr",
            email = "samuelvolder@gmail.com"
        )
    }
}

@Composable
fun CardInfo(name: String, title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .height(160.dp)
                .width(160.dp)
                .background(Color(0xFF073042))
        )
        Text(
            text = name,
            fontSize = 40.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = title,
            color = Color(0xFF1F7E4F)
        )

    }
}

@Composable
fun PersonInfo(phone: String, social: String, email: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        ContactLine(
            icon = Icons.Outlined.Phone,
            message = phone
        )
        ContactLine(
            icon = Icons.Outlined.Share,
            message = social
        )
        ContactLine(
            icon = Icons.Outlined.Email,
            message = email
        )
    }
}

@Composable
fun ContactLine(icon: ImageVector, message: String) {
    Row (
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF1F7E4F),
            modifier = Modifier.padding(start = 100.dp, end = 8.dp)
        )
        Text(
            text = message,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF3ddc84)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}