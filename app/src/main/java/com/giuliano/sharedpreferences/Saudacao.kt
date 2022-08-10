package com.giuliano.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giuliano.sharedpreferences.databinding.ActivityMainBinding
import com.giuliano.sharedpreferences.databinding.ActivitySaudacaoBinding
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.*

class Saudacao : AppCompatActivity() {

    // Cria o ViewBinding para poder chamar a view sem utilizar o findingByID
    private val binding: ActivitySaudacaoBinding by lazy {
        ActivitySaudacaoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // Pega a string salva atraveés da função recuperaDadoArquivo
        val data = recuperaDadoArquivo("saudacao")
        val tokenizer = StringTokenizer(data, ":")
        val nome = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem Nome"
        val tratamento = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem Tratamento"
        if(tratamento.equals("Sem Tratamento")) {
            binding.lbSaudacao.text = nome
        }else {
            binding.lbSaudacao.text = tratamento + " " + nome
        }
    }

    fun recuperaDadoArquivo(filename: String): String {
        try {
            val fi = openFileInput(filename)
            val data = fi.readBytes()
            fi.close()
            data.toString()
            return data.toString(Charset.defaultCharset())
        }catch (e: FileNotFoundException) {
            return ""
        }catch (e: IOException) {
            return ""
        }
    }
}