package es.iessaladillo.pedrojoya.intents.ui.winner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.intents.data.local.Database
import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon
import es.iessaladillo.pedrojoya.intents.databinding.BattleActivityBinding
import es.iessaladillo.pedrojoya.intents.databinding.SelectionActivityBinding
import es.iessaladillo.pedrojoya.intents.databinding.WinnerActivityBinding
const val EXTRA_LONG = "GANADOR"
class WinnerActivity : AppCompatActivity() {

    private lateinit var binding: WinnerActivityBinding
    private lateinit var pk: Pokemon
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WinnerActivityBinding.inflate(layoutInflater)
        setContentView(binding.constraintLayout)
        setupViews()

    }

    private fun setupViews() {
        pk = Database.getPokemonById(intent.getLongExtra(EXTRA_LONG, 0))!!

        binding.imageView.setImageDrawable(pk.getDrawable(this))
        binding.ganadorTxt.text = pk.nombre

    }

}