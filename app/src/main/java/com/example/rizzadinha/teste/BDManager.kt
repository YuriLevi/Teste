package com.example.rizzadinha.teste

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


val NOME_BD = "betaBD"
val NOME_TABELA = "professor"
val COLUNA_ID = "id"
val COLUNA_LOGIN = "login"
val COLUNA_SENHA = "senha"


class BDManager(context: Context) : SQLiteOpenHelper(context, NOME_BD,null,1){
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " +NOME_TABELA+ " (" +
                COLUNA_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUNA_LOGIN+ " VARCHAR(256), " +
                COLUNA_SENHA+ " VARCHAR(256))"

           db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    fun cargaDados(user: Usuario){

        Log.d("TRABALHO" , "ENTROU INSERT")

        val db = this.writableDatabase

        var cv = ContentValues()

        cv.put(COLUNA_LOGIN, user.login)
        cv.put(COLUNA_SENHA, user.senha)

        db.insert(NOME_TABELA,null,cv)

    }

    fun verificaLogin(usuario: Usuario) : Boolean{

        val query = "SELECT * FROM " +NOME_TABELA+ " WHERE " +COLUNA_LOGIN+ " = " +usuario.login+ " AND " +COLUNA_SENHA+ " = " +usuario.senha

        val db = this.writableDatabase

        val cursor = db.rawQuery(query,null)

        var validaUsuario = false


        if (cursor.moveToFirst()) {
            cursor.moveToFirst()

            validaUsuario = true

            cursor.close()

            }

        db.close()

        return validaUsuario

    }


    fun getList() : Cursor{

        val query = "SELECT * FROM " +NOME_TABELA

        val db = this.writableDatabase

        val cursor = db.rawQuery(query,null)

        return cursor

    }




}





