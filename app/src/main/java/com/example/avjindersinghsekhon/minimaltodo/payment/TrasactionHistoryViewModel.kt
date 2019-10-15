package com.example.avjindersinghsekhon.minimaltodo.payment

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.avjindersinghsekhon.minimaltodo.data.model.Receipt
import com.example.avjindersinghsekhon.minimaltodo.provider.repository.ReceiptRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.lang.Exception

class TrasactionHistoryViewModel : ViewModel() {

    /**
     * This is the job for all coroutines started by this ViewModel.
     * Cancelling this job will cancel all coroutines started by this ViewModel.
     */
    private val viewModelJob = SupervisorJob()

    /**
     * This is the io scope for all coroutines launched by this ViewModel.
     * Since we pass viewModelJob, you can cancel all coroutines
     * launched by uiScope by calling viewModelJob.cancel()
     */
    private val ioScope = CoroutineScope(Dispatchers.IO + viewModelJob)

    //TODO inject with Dagger
    private val repository = ReceiptRepository()

    fun getReceipt(id: String) : LiveData<Receipt> {
        val liveData = MutableLiveData<Receipt>()
        ioScope.launch {
            try {
                val receipt = repository.getReceipt(id)
                liveData.postValue(receipt)
            } catch (e: Exception) {
                //TODO better error handling
                Log.e("Error", "Something bad happened", e)
            }
        }
        return liveData
    }
}