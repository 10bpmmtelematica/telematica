@file:Suppress("Annotator", "Annotator")

package com.richterapps.controlep4

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2 : AppCompatActivity() {

    var html:String?=""
    var numeroRecibo:String?=null
    var destino:String?=null
    var qtd:String?=null
    var tipo:String?=null
    var descricao:String?=null
    var obs:String?=null
    var cidadeDataEx:String?=null
    var nomeGuerra:String?=null
    var postoGrad:String?=null
    var reMike:String?=null


    var webview:WebView?=null
    var loopMat:String?=null
    var array = arrayOf(String())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            startActivity(Intent(this, MainActivity::class.java))
        }
        findViewById<FloatingActionButton>(R.id.fab2).setOnClickListener { view ->

        }
        numeroRecibo = "10BPM/M-000/04/21"
        destino = "1º Cia"
        qtd = "10"
        tipo = "Escritório"
        descricao = "Caneta Bic preta cx com 50un"
        obs = "sem alteração"
        cidadeDataEx = "23 de janeiro de 2021"
        nomeGuerra = "Richter"
        postoGrad = "Sd PM"
        reMike = "170534-2"
        html = "<html><h1>ola mundo</h1></html>"

        loopMat="          <tr class=\\\"row8\\\">\n" +
                "            <td class=\\\"column0 style14 n\\\">q</td>\n" +
                "            <td class=\\\"column1 style15 s style17\\\" colspan=\\\"4\\\">t</td>\n" +
                "            <td class=\\\"column2 style15 s style17\\\" colspan=\\\"9\\\">d</td>\n" +
                "            <td class=\\\"column3 style15 s style17\\\" colspan=\\\"6\\\">o</td>\n" +
                "          </tr>\n"
        carregaPDF()


        webview=findViewById<WebView>(R.id.webview)
        val header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
        webview?.loadData(html, "text/html", "UTF-8")
        //webview?.setWebViewClient(WebViewClient())



    }

    fun loop(){
        for (i in 0..20) {
            var array = arrayOfNulls <String> (19)
            loopMat="          <tr class=\\\"row8\\\">\n" +
                    "            <td class=\\\"column0 style14 n\\\">q</td>\n" +
                    "            <td class=\\\"column1 style15 s style17\\\" colspan=\\\"4\\\">t</td>\n" +
                    "            <td class=\\\"column2 style15 s style17\\\" colspan=\\\"9\\\">d</td>\n" +
                    "            <td class=\\\"column3 style15 s style17\\\" colspan=\\\"6\\\">o</td>\n" +
                    "          </tr>\n"
            //array[i]=loopMat.toString()

        }

    }


    fun carregaPDF(){
        loop()
        html= "<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\" ?>" +
                "<html>\n" +
                "\n" +
                "  <body>\n" +
                "        <style>\n" +
                "            @page { margin-left: 0.511811024in; margin-right: 0.511811024in; margin-top: 0.787401575in; margin-bottom: 0.787401575in; }\n" +
                "            body { margin-left: 0.511811024in; margin-right: 0.511811024in; margin-top: 0.787401575in; margin-bottom: 0.787401575in; }\n" +
                "        </style>\n" +
                "\n" +
                "        <tr class=\\\"row1\\\">\n" +
                "            <h1 class=\\\"column0 style18 f style18\\\" colspan=\\\"15\\\">RECIBO - $numeroRecibo</h1>\n" +
                "        </tr>\n" +
                "        <tr class=\\\"row2\\\">\n" +
                "            <h2 class=\\\"column0 style19 s style19\\\" colspan=\\\"9\\\">DESTINO: $destino </h2>\n" +
                "        </tr>\n" +
                "        <tr class=\\\"row4\\\">\n" +
                "            <h2 class=\\\"column0 style20 s style20\\\" colspan=\\\"15\\\">Recebi do P/4 do 10BPM/M, o material abaixo discriminado: </h2>\n" +
                "        </tr>\n" +
                "    <table border=\\\"0\\\" cellpadding=\\\"0\\\" cellspacing=\\\"0\\\" id=\\\"sheet0\\\" class=\\\"sheet0\\\">\n" +
                "        <col class=\\\"col0\\\">\n" +
                "        <col class=\\\"col1\\\">\n" +
                "        <col class=\\\"col2\\\">\n" +
                "        <col class=\\\"col3\\\">\n" +
                "        \n" +
                "        <tbody>\n" +
                "          <tr class=\\\"row6\\\">\n" +
                "            <td class=\\\"column0 style21 s style21\\\" rowspan=\\\"2\\\">QTD</td>\n" +
                "            <td class=\\\"column1 style22 s style22\\\" colspan=\\\"4\\\" rowspan=\\\"2\\\">TIPO</td>\n" +
                "            <td class=\\\"column2 style22 s style22\\\" colspan=\\\"9\\\" rowspan=\\\"2\\\">DESCRIÇÃO</td>\n" +
                "            <td class=\\\"column3 style23 s style26\\\" colspan=\\\"6\\\" rowspan=\\\"2\\\">OBS</td>\n" +
                "          </tr>\n" +
                //"          $array"+
                "$loopMat"+
                "        </tbody>\n" +
                "    </table>\n" +
                "          <tr class=\\\"row1\\\">\n" +
                "            <h4 class=\\\"column0 style30 f style30\\\" colspan=\\\"6\\\">$cidadeDataEx</h4>\n" +
                "          </tr>\n" +
                "          <tr class=\\\"row1\\\">\n" +
                "            <h4 class=\\\"column0 style7 s\\\">Nome: $nomeGuerra</h4>\n" +
                "          </tr>\n" +
                "          <tr class=\\\"row1\\\">\n" +
                "            <h4 class=\\\"column0 style7 s\\\">Posto/Grad: $postoGrad</h4>\n" +
                "          </tr>\n" +
                "          <tr class=\\\"row1\\\">\n" +
                "            <h4 class=\\\"column0 style7 s\\\">RE: $reMike</h4>\n" +
                "          </tr>\n" +
                "  </body>\n" +
                "</html>"
    }
}