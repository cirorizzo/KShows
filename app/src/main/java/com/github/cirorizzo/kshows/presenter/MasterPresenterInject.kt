package com.github.cirorizzo.kshows.presenter


class MasterPresenterInject {
    val masterPresenterImpl: MasterPresenterImpl by lazy { createMasterPresenterImpl() }

    protected fun createMasterPresenterImpl(): MasterPresenterImpl {
        return MasterPresenterImpl();
    }
}