package com.ieseljust.pmdm.comptador


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ieseljust.pmdm.comptador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var comptador=0

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)

        // Referencia al TextView
        val textViewContador=findViewById<TextView>(R.id.textViewComptador)

        // Inicialitzem el TextView amb el comptador a 0
        textViewContador.setText(comptador.toString())

        // Referencia al botón
        val btAdd=binding.btAdd
        val btReset=binding.btReset
        val btResta=binding.btResta

        // Asociaciamos una expresióin lambda como
        // respuesta (callback) al evento Clic sobre
        // el botón
        binding.btAdd.setOnClickListener {
            comptador++
            binding.textViewComptador.setText(comptador.toString())
        }

        binding.btReset.setOnClickListener {
            comptador=0
            binding.textViewComptador.setText(comptador.toString())
        }

        binding.btResta.setOnClickListener {
            comptador--
            binding.textViewComptador.setText(comptador.toString())
        }

    }

    override fun onSaveInstanceState(estat: Bundle) {
        super.onSaveInstanceState(estat)
        // Save the value of comptador
        estat.putInt("CLAU", comptador)
    }

    override fun onRestoreInstanceState(estat: Bundle) {
        super.onRestoreInstanceState(estat)
        // Restore the value of comptador
        comptador = estat.getInt("CLAU")
        // Update the TextView to display the restored value
        binding.textViewComptador.text = comptador.toString()
    }


}