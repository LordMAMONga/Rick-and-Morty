package com.geeks.rick_and_morty.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.geeks.character.ui.characters.CharacterListScreen
import com.geeks.rick_and_morty.ui.theme.RickandMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickandMortyTheme {
                CharacterListScreen(modifier = Modifier.fillMaxSize())

            }
        }
    }
}
