package com.giuliano.sharedpreferences

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
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

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Criamos uma instancia do DataBaseManager.
        val db = DataBaseManager(this, "saudacoes")
        val cursor = db.listaSaudacao()
        var nome = ""
        var tratamento = ""

        // Aqui verificamos o count do Cursor. Se for maior do que 0. ou seja, caso exista um. Pegamos o Nome e o Tratamento.
        if(cursor.count > 0) {
            cursor.moveToFirst()
            nome = cursor.getString(cursor.getColumnIndex("NOME"))
            tratamento = cursor.getString(cursor.getColumnIndex("TRATAMENTO"))
        }
        if(tratamento.equals("Sem Tratamento")) {
            binding.lbSaudacao.text = nome
        }else {
            binding.lbSaudacao.text = tratamento + " " + nome
        }
    }
}