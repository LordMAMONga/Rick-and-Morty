package com.geeks.episode.ui.episodes

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.geeks.episode.ui.components.EpisodeListItem
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterListScreen(modifier: Modifier = Modifier) {
    val viewModel = koinViewModel<EpisodeListViewModel>()
    val episodeList = viewModel.pagingData.collectAsLazyPagingItems()
    val listState = rememberLazyListState()

    Scaffold(modifier) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding), state = listState) {
            items(
                count = episodeList.itemCount,
                key = episodeList.itemKey { episode -> episode.id }) { index ->
                val item = episodeList[index]

                item?.let { episode ->
                    EpisodeListItem(
                        episode = episode
                    )
                }

            }
        }
    }
}