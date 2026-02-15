package com.geeks.rick_and_morty.ui.screens.characters

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.geeks.rick_and_morty.ui.components.CharacterListItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreen(modifier: Modifier = Modifier) {
    val viewModel = koinViewModel<CharacterListViewModel>()
    val characterList = viewModel.pagingData.collectAsLazyPagingItems()
    val listState = rememberLazyListState()

    Scaffold(modifier) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding), state = listState) {
            items(
                count = characterList.itemCount,
                key = characterList.itemKey { character -> character.id }) { index->
                val item = characterList[index]

                item?.let { character ->
                    CharacterListItem(
                        character = character
                    )
                }

            }
        }
    }
}