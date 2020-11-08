package es.iessaladillo.pedrojoya.intents.ui.selection

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import es.iessaladillo.pedrojoya.intents.databinding.BattleActivityBinding
import es.iessaladillo.pedrojoya.intents.databinding.SelectionActivityBinding

class SelectionActivity : AppCompatActivity() {
    private lateinit var pokImg: Array<ImageButton>
    private lateinit var pokBtn: Array<RadioButton>
    private lateinit var binding: SelectionActivityBinding
    private var ExtraPokemon: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = SelectionActivityBinding.inflate(layoutInflater)
        // TODO
        setContentView(binding.constraintLayout)
        setupViews()
    }

    private fun setupViews() {
        pokImg = arrayOf(
            binding.imageButton0,
            binding.imageButton1,
            binding.imageButton2,
            binding.imageButton3,
            binding.imageButton4,
            binding.imageButton5,
        )
        pokBtn = arrayOf(
            binding.rb0,
            binding.rb1,
            binding.rb2,
            binding.rb3,
            binding.rb4,
            binding.rb5
        )
        observers()
    }

    private fun observers() {
        for (imageButton in pokImg) {
            imageButton.setOnClickListener { v -> elegido(v) }
        }
        for (radioButton in pokBtn) {
            radioButton.setOnClickListener { v -> btnElegido(v) }
        }
    }

    private fun btnElegido(v: View?) {

        if (v != null) {
            Snackbar.make(v, v.id.toString(), Snackbar.LENGTH_LONG)
                .show()

            for ((value, radioButton) in pokBtn.withIndex()) {
                if (radioButton.id != v.id) {
                    radioButton.isChecked = false
                } else {
                    ExtraPokemon = value
                }
            }
        };
    }

    private fun elegido(v: View?) {

        if (v != null) {
            Snackbar.make(v, v.id.toString(), Snackbar.LENGTH_LONG)
                .show()
            for ((value0, imageButton) in pokImg.withIndex()) {
                if (imageButton.id == v.id) {
                    for ((value1, radioButton) in pokBtn.withIndex()) {
                        radioButton.isChecked = value0 == value1
                        ExtraPokemon = value1
                    }
                }
            }
        };

    }

    override fun onBackPressed() {
        super.onBackPressed()
        var resultIntent: Intent = Intent();
        resultIntent.putExtra("id", ExtraPokemon);
        setResult(RESULT_OK, resultIntent)

    }

}