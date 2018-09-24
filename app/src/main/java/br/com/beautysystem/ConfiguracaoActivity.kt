package br.com.beautysystem

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class ConfiguracaoActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar)
        val progressBar: ProgressBar = this.progressBar1

        supportActionBar?.title = "Configurações"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
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
                this@ConfiguracaoActivity.runOnUiThread(java.lang.Runnable {
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
                this@ConfiguracaoActivity.runOnUiThread(java.lang.Runnable {
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
            Toast.makeText(this, "Clicou voltar", Toast.LENGTH_SHORT).show()
            finish()
        }
        return super.onOptionsItemSelected(item)
    }


}