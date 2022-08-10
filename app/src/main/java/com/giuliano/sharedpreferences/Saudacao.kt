package com.giuliano.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giuliano.sharedpreferences.databinding.ActivityMainBinding
import com.giuliano.sharedpreferences.databinding.ActivitySaudacaoBinding

class Saudacao : AppCompatActivity() {

    // Cria o ViewBinding para poder chamar a view sem utilizar o findingByID
    private val binding: ActivitySaudacaoBinding by lazy {
        ActivitySaudacaoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Cria uma variável para pegar as preferências salvas.
        val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)

        // Pega os valores salvos pelo usuaário na tela anterior.
        val nome = saudacaoPersistencia.getString("nome","")
        val tratamento = saudacaoPersistencia.getString("tratamento", "")

        // Se o tratamento for igual "Sem Tratamento" irá imprimir somente o nome, senão iraá mostrar no text o tratamento
        // e salvação
        if(tratamento.equals("Sem Tratamento")) {
            binding.lbSaudacao.text = nome
        }else {
            binding.lbSaudacao.text = tratamento + " " + nome
        }
    }
}