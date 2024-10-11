package com.example.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.domain.usecases.character.GetCharactersUseCase
import com.example.rickandmorty.base.theme.RickAndMortyTheme
import org.koin.androidx.compose.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val inPad = innerPadding
                    val getCharactersUseCase: GetCharactersUseCase = get()
                    Test(getCharactersUseCase = getCharactersUseCase)
                }
            }
        }
    }
}

@Composable
fun Test(getCharactersUseCase: GetCharactersUseCase) {

    val flow by getCharactersUseCase.charactersFlow.collectAsState(initial = emptyList())

    Column {
        Text(text = flow.toString())
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickAndMortyTheme {

    }
}