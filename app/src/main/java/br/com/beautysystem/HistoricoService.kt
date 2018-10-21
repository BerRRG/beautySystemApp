package br.com.beautysystem

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

object HistoricoService {
/*
    fun getHistoricos (context: Context): List<Historico> {
        val historicos = mutableListOf<Historico>()

        for (i in 1..5){
            val d = Historico()
            d.nome = "Historico $i"
            d.tratamento = "Tratamento $i"
            d.data = "Data $i"
            d.foto = "https://blog.plantei.com.br/wp-content/uploads/2018/06/Ciclame.jpg"
            historicos.add(d)
        }
        return historicos

*/

        val host = "http://beautysystem.pythonanywhere.com"
        val TAG = "WS_LMS"

        fun getHistoricos(context: Context): List<Historico> {
            val url = "$host/historicos"
            //val json = URL(url).readText()
            val json = HttpHelper.get(url)

            Log.d(TAG, json)

            return parseJson<List<Historico>>(json)

        }
        fun save(historico: Historico): Response{
            val url = "$host/historicos"
            val json = GsonBuilder().create().toJson(historico)
            val retorno = HttpHelper.post(url,json)

            return  parseJson<Response>(retorno)
        }

        inline fun <reified T> parseJson(json: String): T {
            val tipo = object : TypeToken<T>(){}.type
            return Gson().fromJson<T>(json,tipo)

        }
    }

