package com.example.rizzadinha.teste

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

       //val cUsuario = Usuario("1","1")
        //db.cargaDados(cUsuario)


    }


    fun fazerLogin(view: View){

        Log.d("TRABALHO", "entrou fazerlogin")



            val  vUsuario = Usuario(Nome.text.toString(), Senha.text.toString())


            var validaUsuario = db.verificaLogin(vUsuario)

            if(validaUsuario == true){

                Toast.makeText(this,"Sucesso",Toast.LENGTH_LONG).show()
            }else{

                Toast.makeText(this,"Falha",Toast.LENGTH_LONG).show()
            }


    }





}
