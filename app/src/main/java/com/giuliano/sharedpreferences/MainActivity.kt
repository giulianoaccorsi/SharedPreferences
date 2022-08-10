package com.giuliano.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.giuliano.sharedpreferences.databinding.ActivityMainBinding
import java.io.FileNotFoundException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    // Cria o ViewBinding para poder chamar a view sem utilizar o findingByID
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Aqui criamos uma instancia do banco de dados
        val db = DataBaseManager(this, "saudacoes")

        binding.buttonSave.setOnClickListener {
            // Assim que o usuário clicar no banco de dados, que chama a função removeSaudacao, chama a função insereSaudacao passando parametros e apresenta um toast
            db.removeSaudacao()
            db.insereSaudacao(1, binding.editTextUser.text.toString(), binding.spinner.selectedItem.toString())
            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()

        }

        // Caso o usuário clique no botaão exibir. Passa para a tela Saudacao Activity.
        binding.exibirButton.setOnClickListener {
            val indent = Intent(this, Saudacao::class.java)
            startActivity(indent)
        }
    }
}