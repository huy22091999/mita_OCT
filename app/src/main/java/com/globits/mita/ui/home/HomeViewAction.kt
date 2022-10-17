package com.globits.mita.ui.home

import com.globits.mita.core.MitaViewModelAction

sealed class HomeViewAction: MitaViewModelAction {
    object GetAnalytics:HomeViewAction()
    object GetCurrentUser: HomeViewAction()
    data class GetAssetInfo(val key:String):HomeViewAction()
}