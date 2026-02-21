package com.geeks.episode.ui.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.geeks.episode.domain.usecase.GetEpisodePageSourceUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class EpisodeListViewModel(
    private val getEpisodesPageSourceUseCase: GetEpisodePageSourceUseCase
) : ViewModel() {

//    val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())   // Вот не забыл как вы и говорили :)

    val pagingData =  getEpisodesPageSourceUseCase(page = 1)
        .cachedIn(viewModelScope)
        .stateIn(scope = viewModelScope, started = SharingStarted.Lazily, initialValue = PagingData.empty())

}