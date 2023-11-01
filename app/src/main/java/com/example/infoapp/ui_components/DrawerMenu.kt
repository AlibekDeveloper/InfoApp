package com.example.infoapp.ui_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.infoapp.R
import com.example.infoapp.ui.theme.BgTransparent
import com.example.infoapp.ui.theme.MainRed


@Preview(showBackground = true)
@Composable
fun DrawerMenu() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(
                id = R.drawable.drawer_list_bg
            ),
            contentDescription = "Main Bg image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Header()
            Body()
        }
    }
}


@Composable
fun Header() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, MainRed)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.header_bg),
                contentDescription = "Header image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = R.string.botanists_handbook),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MainRed)
                    .padding(10.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun Body() {
    val list = stringArrayResource(id = R.array.drawer_list)
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(list) { _, title ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp), colors = CardDefaults.cardColors(
                    containerColor = BgTransparent
                )
            ) {
                Text(text = title, modifier = Modifier
                    .fillMaxWidth()
                    .clickable {

                    }
                    .padding(10.dp)
                    .wrapContentWidth(), fontWeight = FontWeight.Bold)
            }
        }
    }
}