package com.github.cirorizzo.kshows

import android.app.Application
import com.github.cirorizzo.kshows.presenter.MasterPresenterInject


open class KShowsApplication : Application() {
    val masterPresenterInject: MasterPresenterInject by lazy { createMasterPresenterInject() }

    protected fun createMasterPresenterInject(): MasterPresenterInject {
        return MasterPresenterInject()
    }
}