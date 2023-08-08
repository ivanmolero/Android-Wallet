package com.cristianvillamil.platziwallet.ui.home.presenter

import com.cristianvillamil.platziwallet.ui.home.FavoriteTransfer
import com.cristianvillamil.platziwallet.ui.home.HomeContract
import com.cristianvillamil.platziwallet.ui.home.data.HomeInteractor

class HomePresenter(private val view: HomeContract.View) : HomeContract.Presenter {
    private val homeInteractor = HomeInteractor() // no es necesario el tipo ya que se infiere
    override fun retrieveFavoriteTransfers(favoriteTransfer: List<FavoriteTransfer>) {
        homeInteractor.retrieveFavoriteTransferFromCache(object: HomeContract.OnResponseCallback {
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {
                view.hideLoader()
                view.showFavoriteTransfers(favoriteList)
            }
        })
    }


}