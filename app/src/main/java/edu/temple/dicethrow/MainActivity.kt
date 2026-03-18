package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportFragmentManager.findFragmentById(R.id.fragmentContainerView) == null) {
            supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, DieFragment.newInstance(6))
                .add(R.id.fragmentContainerView2, DieFragment.newInstance(6))
                .commit()
        }

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            val die1 = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as DieFragment
            val die2 = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as DieFragment

            die1.throwDie()
            die2.throwDie()

            }
        }
    }