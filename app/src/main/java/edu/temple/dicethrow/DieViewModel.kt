package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {

    private var dieSides  = 6
    private val die = MutableLiveData<Int>()

    fun setThrowDie(sides: Int) {
        if(sides > 0){
            dieSides = sides
        }

    }

    fun throwDie(){
        die.value = (Random.nextInt(dieSides) + 1)
    }

    fun getThrowDieNumber(): LiveData<Int> {
        return die
    }

}