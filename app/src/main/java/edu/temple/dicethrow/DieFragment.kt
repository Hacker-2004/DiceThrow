package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

class DieFragment : Fragment() {

    private val DIESIDE = "sidenumber"

    lateinit var dieTextView: TextView

    lateinit var dieViewModel: DieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dieViewModel = ViewModelProvider(requireActivity())[DieViewModel::class.java]

        arguments?.let {
            val sides = it.getInt(DIESIDE)
            dieViewModel.setThrowDie(sides)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dieViewModel.getThrowDieNumber().observe(viewLifecycleOwner) {
            value -> dieTextView.text = value.toString()
        }

        if(dieViewModel.getThrowDieNumber().value == null){
            dieViewModel.throwDie()
        }
    }

    companion object{
        fun newInstance (sides: Int) = DieFragment().apply {
            arguments = Bundle().apply {
                putInt(DIESIDE, sides)
            }
        };
    }
}