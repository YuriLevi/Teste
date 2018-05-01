package com.example.rizzadinha.teste

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    val db = BDManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listMaker()

    }


    fun listMaker(){

        var theList = ArrayList<String>()

        var dados = db.getList()


        if(dados.count ==0){

            Log.d("tra", "deu zik")
        }else{

            while(dados.moveToNext()){
                theList.add(dados.getString(1))

                var listAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,theList)

                lista.adapter = listAdapter

            }

        }



    }

}






















