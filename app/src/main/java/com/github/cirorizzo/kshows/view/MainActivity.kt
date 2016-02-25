package com.github.cirorizzo.kshows.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.github.cirorizzo.kshows.KShowsApplication
import com.github.cirorizzo.kshows.R
import com.github.cirorizzo.kshows.presenter.MasterPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityInterface {
    private val imagesAdapterImpl: ImagesAdapterImpl by lazy { ImagesAdapterImpl() }

    private val masterPresenterImpl: MasterPresenterImpl
            by lazy {
                (application as KShowsApplication).masterPresenterInject.masterPresenterImpl
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        connectingToMasterPresenter()
        getURLs()
    }

    private fun initRecyclerView() {
        containerRecyclerView.layoutManager = GridLayoutManager(this, 2)//StaggeredGridLayoutManager(3, 1))
        containerRecyclerView.adapter = imagesAdapterImpl
    }

    private fun connectingToMasterPresenter() {
        masterPresenterImpl.connect(this, imagesAdapterImpl)
    }

    private fun getURLs() {
        masterPresenterImpl.getMasterRequest()
    }
}