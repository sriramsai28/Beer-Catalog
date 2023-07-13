package com.sriram.beerlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.sriram.beerlist.presentation.ui.BeerScreen
import com.sriram.beerlist.presentation.viewmodel.BeerViewModel
import com.sriram.beerlist.ui.theme.BeerListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeerListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BeerListTheme {
                        val beerViewModel = hiltViewModel<BeerViewModel>()
                        val beers = beerViewModel.beerPagingFlow.collectAsLazyPagingItems()
                        BeerScreen(beers = beers)
                    }
                }
            }
        }
    }
}