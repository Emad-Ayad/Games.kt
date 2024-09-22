package com.example.mygames2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.mygames2.data.model.Game
import com.example.mygames2.ui.theme.MyGames2Theme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = MainViewModel()
            viewModel.getAllGames()
            val games = viewModel.gamesResponse.collectAsState()
            MyGames2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Color.Black
                ) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        GameScreen(viewModel = viewModel)
//                        LazyVerticalGrid(
//                            columns = GridCells.Fixed(2),
//                            contentPadding = PaddingValues(2.dp),
//                            modifier = Modifier.fillMaxSize()
//                        ) {
//                            items(games.value) { game ->
//                                Card(
//                                    modifier = Modifier
//                                        .padding(8.dp)
//                                ) {
//                                    Box(
//                                        modifier = Modifier
//                                            .fillMaxSize()
//                                            .padding(top = 15.dp),
//                                    ) {
//                                        AsyncImage(
//                                            alignment = Alignment.Center,
//                                            model = game.thumbnail,
//                                            contentDescription = game.title,
//                                            modifier = Modifier.fillMaxSize(),
//                                        )
//                                    }
//                                    Text(
//                                        text = game.title ?: "No Title",
//                                        modifier = Modifier
//                                            .fillMaxWidth(),
//                                        textAlign = TextAlign.Center,
//                                        color = Color.DarkGray,
//                                        fontWeight = FontWeight.Bold,
//                                        maxLines = 1,
//                                    )
//                                }
//                            }
//                        }

                    }
                }
            }
        }
    }
}

@Composable
fun GameScreen(viewModel: MainViewModel) {
    val games = viewModel.gamesResponse.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(2.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(games.value) { game ->
            GameCard(game = game)
        }
    }
}

@Composable
fun GameCard(game: Game) {
    Card(
        modifier = Modifier
            .padding(8.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp),
        ) {
            AsyncImage(
                alignment = Alignment.Center,
                model = game.thumbnail,
                contentDescription = game.title,
                modifier = Modifier.fillMaxSize(),
            )
        }
        Text(
            text = game.title ?: "No Title",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
        )
    }
}