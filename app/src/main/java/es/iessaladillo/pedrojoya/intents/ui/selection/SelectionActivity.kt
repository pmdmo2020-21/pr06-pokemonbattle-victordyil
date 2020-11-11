package es.iessaladillo.pedrojoya.intents.ui.selection

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import es.iessaladillo.pedrojoya.intents.data.local.Database
import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon
import es.iessaladillo.pedrojoya.intents.databinding.BattleActivityBinding
import es.iessaladillo.pedrojoya.intents.databinding.SelectionActivityBinding
import java.sql.Time

const val EXTRA_ID = "EXTRA_ID"

class SelectionActivity : AppCompatActivity() {
    private lateinit var pokImg: Array<ImageButton>
    private lateinit var pokBtn: Array<RadioButton>
    private lateinit var binding: SelectionActivityBinding
    private var extraPk: Int? = null

    companion object {
        fun newIntent(context: Context, id: Long): Intent {

            return Intent(context, SelectionActivity::class.java)
                .putExtra(EXTRA_ID, id)
        }
    }


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
            //Snackbar.make(v, v.id.toString(), Snackbar.LENGTH_LONG).show()

            for ((value, radioButton) in pokBtn.withIndex()) {
                if (radioButton.id != v.id) {
                    radioButton.isChecked = false
                } else {
                    extraPk = value

                }
            }


        };
        finBien()
    }

    private fun elegido(v: View?) {

        if (v != null) {
            Snackbar.make(v, v.id.toString(), Snackbar.LENGTH_LONG)
                .show()
            for ((value0, imageButton) in pokImg.withIndex()) {
                if (imageButton.id == v.id) {
                    for ((value1, radioButton) in pokBtn.withIndex()) {
                        radioButton.isChecked = value0 == value1
                        if (value0 == value1) {
                            extraPk = value1
                        }
                    }

                }
            }

        };

    }

    private fun finBien() {
        var r = Intent().putExtra(EXTRA_ID, extraPk?.toLong());
        setResult(RESULT_OK, r)
    }

    override fun onBackPressed() {
        if (extraPk != null) {
            finBien()
        }
        super.onBackPressed()


    }

}