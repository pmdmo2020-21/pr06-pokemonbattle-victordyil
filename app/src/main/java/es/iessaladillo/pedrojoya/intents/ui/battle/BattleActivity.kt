package es.iessaladillo.pedrojoya.intents.ui.battle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.intents.R
import es.iessaladillo.pedrojoya.intents.databinding.BattleActivityBinding
import es.iessaladillo.pedrojoya.intents.ui.selection.SelectionActivity


class BattleActivity : AppCompatActivity() {

    private lateinit var binding: BattleActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = BattleActivityBinding.inflate(layoutInflater)
        // TODO
        setContentView(binding.constraintLayout)
        setupViews()
        
    }

    private fun setupViews() {
        binding.pok1.setOnClickListener { cambiarPokemon() }
    }

    private fun cambiarPokemon() {
        val intent = Intent(this, SelectionActivity::class.java)
        startActivity(intent)
        var pk = when(intent.getIntExtra("id",0)){
            0 -> R.drawable.bulbasur
            1 -> R.drawable.giratina
            2 -> R.drawable.cubone
            3 -> R.drawable.gyarados
            4 -> R.drawable.feebas
            5 -> R.drawable.pikachu
            else -> 0
        }

        binding.pok1.setImageResource(pk)

    }



}