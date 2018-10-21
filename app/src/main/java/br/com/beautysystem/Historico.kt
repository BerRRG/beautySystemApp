package br.com.beautysystem
class Historico {

    var id:Long = 0
    var tratamento = ""
    var foto = ""
    var data = ""
	var hora = ""

    override fun toString(): String {
        return "Historicos(tratamento='$tratamento',data='$data', hora='$hora' )"
    }

}