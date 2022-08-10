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

        // Caso o usuaário clique no botão salvar. Salva o nome e o tratamento que o usuário adiciona
        // e mostrar na tela com um Toast que foi salvo com sucesso

        binding.buttonSave.setOnClickListener {
            // Cria uma variaveél data que salva o que o usuário escreveu no edittext e o que selecionou no spinner
            val data = binding.editTextUser.text.toString() + ":" + binding.spinner.selectedItem.toString()
            // Chama a função gravaArquivo passando o filename e passando uma data
            gravaDadoArquivo("saudacao", data)
            // Cria um toast passando que foi salvo com sucesso
            Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()

        }

        // Caso o usuário clique no botaão exibir. Passa para a próxima tela.
        binding.exibirButton.setOnClickListener {
            val indent = Intent(this, Saudacao::class.java)
            startActivity(indent)
        }
    }


    // Cria uma função chamado gravaDadoArquivo que utiliza o openFileOutputStream que destinase escrever dados brutos como bytes
    fun gravaDadoArquivo(filename: String, data: String) {
        try {
            val fs = openFileOutput(filename, Context.MODE_PRIVATE)
            fs.write(data.toByteArray())
            fs.close()
        }

        // caso não consiga escrever irá cair no catch, mostrando no log
        catch (e: FileNotFoundException) {
            Log.i("gravaDadoArquivo", "FileNotFoundException")
        }
        catch (e: IOException) {
            Log.i("gravaDadoArquivo", "IOException")
        }
    }
}