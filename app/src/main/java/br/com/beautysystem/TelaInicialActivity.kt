package br.com.beautysystem

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import android.support.v4.view.MenuItemCompat
import android.widget.Toast
import br.com.beautysystem.R.id.action_buscar



class TelaInicialActivity : DebugActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)
        val progressBar: ProgressBar = this.progressBar1


        val args = intent.extras
        val nome = args.getString("nome")

        // Toast.makeText(this, "Parametro enviado: $nome", Toast.LENGTH_SHORT).show()


        Toast.makeText(this, "Bem Vindo(a) : $nome", Toast.LENGTH_SHORT).show()


        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



       profissional.setOnClickListener{
            val titulo = "Profissional"
            var intent = Intent(this, MenuActivity::class.java)
            var arg = Bundle()
            arg.putString("title", titulo)
            intent.putExtras(arg)
            startActivity(intent)
        }

        sala.setOnClickListener{
            val titulo = "Sala"
            var intent = Intent(this, MenuActivity::class.java)
            var arg = Bundle()
            arg.putString("title", titulo)
            intent.putExtras(arg)
            startActivity(intent)
        }

       tratamentos.setOnClickListener{
            val titulo = "Tratamentos"
            var intent = Intent(this, MenuActivity::class.java)
            var arg = Bundle()
            arg.putString("title", titulo)
            intent.putExtras(arg)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
        // vincular evento de buscar
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                // ação enquanto está digitando
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {

                var texto = action_buscar.toString()

                Toast.makeText(this@TelaInicialActivity, "${query}", Toast.LENGTH_LONG).show()
                return false
            }

        })
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //pega o id que definimos
        val id = item?.itemId
        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou buscar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_atualizar) {
            Thread(Runnable {
                // dummy thread mimicking some operation whose progress cannot be tracked

                // display the indefinite progressbar
                this@TelaInicialActivity.runOnUiThread(java.lang.Runnable {
                    val progressBar : ProgressBar = this.progressBar1
                    progressBar.visibility = View.VISIBLE
                })

                // performing some dummy time taking operation
                try {
                    var i = 0;
                    while (i < Int.MAX_VALUE) {
                        i++
                    }
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                // when the task is completed, make progressBar gone
                this@TelaInicialActivity.runOnUiThread(java.lang.Runnable {
                    val progressBar : ProgressBar = this.progressBar1
                    progressBar.visibility = View.GONE
                })
            }).start()
            //Toast.makeText(this, "Clicou atualizar", Toast.LENGTH_SHORT).show()
        }else if (id == R.id.action_add) {
            val intent = Intent(this, AdicionarActivity::class.java)
           startActivityForResult(intent,10)

        }else if (id == R.id.action_config) {
            val intent = Intent(this,ConfiguracaoActivity::class.java)
            startActivityForResult(intent, 10)
        } else if (id == R.id.action_sair) {
            var intent = Intent(this,MainActivity::class.java)
            Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
            startActivityForResult(intent, 10)
            finish()
        }else if (id == android.R.id.home){
            Toast.makeText(this, "Clicou atualizar", Toast.LENGTH_SHORT).show()
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


}


