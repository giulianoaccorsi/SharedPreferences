package com.giuliano.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.giuliano.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.buttonSave.setOnClickListener {
            val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
            val editor = saudacaoPersistencia.edit()

            editor.putString("nome", binding.editTextUser.text.toString())
            editor.putString("tratamento", binding.spinner.selectedItem.toString())
            editor.apply()

            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()

        }

        binding.exibirButton.setOnClickListener {
            val indent = Intent(this, Saudacao::class.java)
            startActivity(indent)
        }
    }
}