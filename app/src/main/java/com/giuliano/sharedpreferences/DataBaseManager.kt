package com.giuliano.sharedpreferences

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseManager(context: Context, name: String?,) : SQLiteOpenHelper(context, name, null, 1){
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE SAUDACAO(\n" +
                "\tID_SAUDACAO INT NOT NULL, \n" +
                "\tNOME VARCHAR (20), \n" +
                "\tTRATAMENTO VARCHAR(20), \n" +
                "\tPRIMARY KEY (ID_SAUDACAO)\n" +
                "\t);")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS SAUDACAO")
        p0?.execSQL("CREATE TABLE SAUDACAO(\n" +
                "\tID_SAUDACAO INT NOT NULL, \n" +
                "\tNOME VARCHAR (20), \n" +
                "\tTRATAMENTO VARCHAR(20), \n" +
                "\tPRIMARY KEY (ID_SAUDACAO)\n" +
                "\t);")
    }

    fun insereSaudacao(id: Int, nome: String, tratamento: String) {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("ID_SAUDACAO", id)
        cv.put("NOME", nome)
        cv.put("TRATAMENTO", tratamento)
        db.insert("SAUDACAO", "ID_SAUDACAO", cv)
    }

    fun listaSaudacao(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("select nome, tratamento from saudacao", null)
    }

    fun removeSaudacao(){
        val db = this.writableDatabase
        db.delete("SAUDACAO", "ID_SAUDACAO=1", null)
    }


}