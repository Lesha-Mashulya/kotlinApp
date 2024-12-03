package com.example.food

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.foundation.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.food.ui.theme.FoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun MainTheme(content : @Composable ()-> Unit) {
    FoodTheme{
        Surface(color = MaterialTheme.colorScheme.background){
            content()
        }
    }
}

@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .offset(0.dp, (-30).dp),
            painter = painterResource(id = R.drawable.bg_main),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        Column {
            AppBar()
            Content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    Row(
        Modifier
            .padding(16.dp)
            .height(46.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Search Food, Vegetable, etc", fontSize = 12.sp)},
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")},
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "Favorite", tint = Color.White)
        }
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Outlined.Notifications, contentDescription = "Notification", tint = Color.White)
        }
    }
}

@Composable
fun Content(){
    Header()
}

@Composable
fun Header() {
    Card(
        Modifier
            .height(64.dp)
            .padding(horizontal = 16.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(100.dp)
    ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            QrButton()
            VerticalDevider()
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { }
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_money),
                    contentDescription ="",
                    tint = Color(0xFF6FCF97)
                )
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(text = "$120", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Top up", color = MaterialTheme.colorScheme.primary, fontSize = 12.sp)
                }
            }
            VerticalDevider()
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .clickable { }
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_coin),
                    contentDescription ="",
                    tint = Color.Magenta
                )
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(text = "$12", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = "Top up", color = Color.LightGray, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
fun QrButton(){
    IconButton(
        onClick = {},
        modifier = Modifier
            .size(48.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_scan),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}

@Composable
fun VerticalDevider() {
    HorizontalDivider(
        color = Color(0xFFF1F1F1),
        modifier = Modifier
            .width(1.dp)
            .height(32.dp)
    )
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PrevScreen(){
    MainTheme {
        HomeScreen()
    }
}
