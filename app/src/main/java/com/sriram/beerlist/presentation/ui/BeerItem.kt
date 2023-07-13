package com.sriram.beerlist.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.sriram.beerlist.domain.model.Beer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeerItem(
    beer: Beer,
    modifier: Modifier,
) {
    Card(
        onClick = { /*TODO*/ },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(IntrinsicSize.Max)
        ) {
            AsyncImage(
                model = beer.imageUrl,
                contentDescription = beer.name,
                modifier = Modifier
                    .weight(1f)
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier =
                Modifier
                    .weight(3f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${beer.id}. ${beer.name}",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 14.sp
                )
                beer.tagLine?.let {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = beer.description,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 10.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "First Brewed on: ${beer.firstBrewed} ",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    fontSize = 8.sp
                )
            }
        }
    }
}


@Preview
@Composable
fun BeerItemPreview() {
    BeerItem(
        beer = Beer(
            id = 1,
            name = "Beer",
            tagLine = "Taste the beer",
            firstBrewed = "07/2023",
            description = "Field for beer description. \n Test 2 lines",
            imageUrl = null
        ), modifier = Modifier.fillMaxWidth()
    )
}