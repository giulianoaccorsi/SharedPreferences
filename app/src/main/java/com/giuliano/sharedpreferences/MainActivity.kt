package com.giuliano.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.giuliano.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Cria o ViewBinding para poder chamar a view sem utilizar o findingByID
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Caso o usuaário clique no botão salvar. Salva o nome e o tratamento que o usuário adiciona
        // e mostrar na tela com um Toast que foi salvo com sucesso

        binding.buttonSave.setOnClickListener {
            val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
            val editor = saudacaoPersistencia.edit()

            editor.putString("nome", binding.editTextUser.text.toString())
            editor.putString("tratamento", binding.spinner.selectedItem.toString())
            editor.apply()

            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()

        }

        // Caso o usuário clique no botaão exibir. Passa para a próxima tela.
        binding.exibirButton.setOnClickListener {
            val indent = Intent(this, Saudacao::class.java)
            startActivity(indent)
        }
    }
}