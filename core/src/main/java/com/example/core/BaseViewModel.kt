package com.example.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

open class BaseViewModel<VIEW_STATE : BaseViewState, VIEW_EVENT : BaseViewEvent> : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    protected val mutableStateLiveData: MutableLiveData<VIEW_STATE> = MutableLiveData()
    val viewStateLiveData: LiveData<VIEW_STATE> = mutableStateLiveData

    protected val mutableEventLiveData: MutableLiveData<VIEW_EVENT> = SingleLiveEvent()
    val viewEventLiveData: LiveData<VIEW_EVENT> = mutableEventLiveData

    protected fun launchJob(job: () -> Disposable) {
        compositeDisposable.add(job.invoke())
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
