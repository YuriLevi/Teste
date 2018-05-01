package com.example.rizzadinha.teste

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val db = BDManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val cUsuario = Usuario("mariane","mariane")

       // db.cargaDados(cUsuario)


    }


    fun fazerLogin(view: View){

        Log.d("TRABALHO", "entrou fazerlogin")


        if(login.text.toString().isBlank() || senha.text.toString().isBlank() )
            Toast.makeText(this,"Preencha os campos", Toast.LENGTH_LONG).show()
        else {

            val vUsuario = Usuario(login.text.toString(), senha.text.toString())


            var validaUsuario = db.verificaLogin(vUsuario)

            if (validaUsuario == true) {

                Toast.makeText(this, "Sucesso", Toast.LENGTH_LONG).show()

                val novaTela = Intent(this, ListViewActivity::class.java)

                startActivity(novaTela)


            } else {

                Toast.makeText(this, "Dados Invalidos", Toast.LENGTH_LONG).show()
            }

        }

    }





}
