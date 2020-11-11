package es.iessaladillo.pedrojoya.intents.ui.battle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import es.iessaladillo.pedrojoya.intents.data.local.Database
import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon
import es.iessaladillo.pedrojoya.intents.databinding.BattleActivityBinding
import es.iessaladillo.pedrojoya.intents.ui.selection.EXTRA_ID
import es.iessaladillo.pedrojoya.intents.ui.selection.SelectionActivity
import es.iessaladillo.pedrojoya.intents.ui.winner.EXTRA_LONG
import es.iessaladillo.pedrojoya.intents.ui.winner.WinnerActivity


class BattleActivity : AppCompatActivity() {

    private lateinit var binding: BattleActivityBinding
    private var idPk1: Long = 1
    private lateinit var pk1: Pokemon
    private lateinit var pk2: Pokemon
    private val selectCall1: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultIntent = result.data
            if (result.resultCode == Activity.RESULT_OK && resultIntent != null) {
                updatePK1(resultIntent)
            }
        }
    private val selectCall2: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultIntent = result.data
            if (result.resultCode == Activity.RESULT_OK && resultIntent != null) {
                updatePK2(resultIntent)
            }
        }

    private fun updatePK1(rIntent: Intent) {
        var id: Long = rIntent.getLongExtra(EXTRA_ID, 0)
        var pk = Database.getPokemonById(id)
        if (pk != null) {
            binding.pk1lbl.text = pk.nombre
            binding.pok1.setImageDrawable(pk.getDrawable(this))
            pk1 = pk
        }
    }

    private fun updatePK2(rIntent: Intent) {
        var id: Long = rIntent.getLongExtra(EXTRA_ID, 0)
        var pk = Database.getPokemonById(id)
        if (pk != null) {
            binding.pk2lbl.text = pk.nombre
            binding.pok2.setImageDrawable(pk.getDrawable(this))
            pk2 = pk
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = BattleActivityBinding.inflate(layoutInflater)
        setContentView(binding.constraintLayout)
        setupViews()
    }

    private fun setupViews() {
        pk1 = Database.getRandomPokemon()
        pk2 = Database.getRandomPokemon()
        binding.pk1lbl.text = pk1.nombre
        binding.pk2lbl.text = pk2.nombre

        binding.pok1.setImageDrawable(pk1.getDrawable(this))
        binding.pok2.setImageDrawable(pk2.getDrawable(this))
        binding.pok1.setOnClickListener {
            selectCall1.launch(SelectionActivity.newIntent(this, pk1.id))
        }
        binding.pok2.setOnClickListener {
            selectCall2.launch(SelectionActivity.newIntent(this,
                pk2.id))
        }
        binding.fightBtn.setOnClickListener { pelear() }
    }

    private fun arrancarpk1() {
        selectCall1.launch(SelectionActivity.newIntent(this,
            pk1.id))
    }

    private fun pelear() {
        var pk: Pokemon = if (pk1.tipo.ganador(pk1.tipo, pk2.tipo) == 1) {
            Database.getPokemonById(pk1.id)!!
        } else {
            Database.getPokemonById(pk1.id)!!
        }


        val intent = Intent(this, WinnerActivity::class.java).putExtra(EXTRA_LONG, pk.id)
        startActivity(intent)
    }


}