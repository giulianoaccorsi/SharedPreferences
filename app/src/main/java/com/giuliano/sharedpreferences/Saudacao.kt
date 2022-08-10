package com.giuliano.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.giuliano.sharedpreferences.databinding.ActivityMainBinding
import com.giuliano.sharedpreferences.databinding.ActivitySaudacaoBinding

class Saudacao : AppCompatActivity() {
    private val binding: ActivitySaudacaoBinding by lazy {
        ActivitySaudacaoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)

        val nome = saudacaoPersistencia.getString("nome","")
        val tratamento = saudacaoPersistencia.getString("tratamento", "")

        if(tratamento.equals("Sem Tratamento")) {
            binding.lbSaudacao.text = nome
        }else {
            binding.lbSaudacao.text = tratamento + " " + nome
        }
    }
}