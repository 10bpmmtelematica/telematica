package com.richterapps.controlep4

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2 : AppCompatActivity() {

    var html:String?=null
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

        //carregaPDF()
        webview=findViewById<WebView>(R.id.webview)
        webview?.settings
        val header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
        webview?.loadData(header + html, "text/html", "UTF-8")
        //webview?.setWebViewClient(WebViewClient())



    }


    /*fun carregaPDF(){
        html= "<html>\n" +
                "  <head>\n" +
                "      <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "      <meta name=\"generator\" content=\"PhpSpreadsheet, https://github.com/PHPOffice/PhpSpreadsheet\">\n" +
                "      <meta name=\"author\" content=\"Telemática-1\" />\n" +
                "      <meta name=\"company\" content=\"Microsoft Corporation\" />\n" +
                "    <style type=\"text/css\">\n" +
                "      html { font-family:Calibri, Arial, Helvetica, sans-serif; font-size:11pt; background-color:white }\n" +
                "      a.comment-indicator:hover + div.comment { background:#ffd; position:absolute; display:block; border:1px solid black; padding:0.5em }\n" +
                "      a.comment-indicator { background:red; display:inline-block; border:1px solid black; width:0.5em; height:0.5em }\n" +
                "      div.comment { display:none }\n" +
                "      table { border-collapse:collapse; page-break-after:always }\n" +
                "      .gridlines td { border:1px dotted black }\n" +
                "      .gridlines th { border:1px dotted black }\n" +
                "      .b { text-align:center }\n" +
                "      .e { text-align:center }\n" +
                "      .f { text-align:right }\n" +
                "      .inlineStr { text-align:left }\n" +
                "      .n { text-align:right }\n" +
                "      .s { text-align:left }\n" +
                "      td.style0 { vertical-align:bottom; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style0 { vertical-align:bottom; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style1 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:18pt; background-color:white }\n" +
                "      th.style1 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:18pt; background-color:white }\n" +
                "      td.style2 { vertical-align:middle; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style2 { vertical-align:middle; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style3 { vertical-align:bottom; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style3 { vertical-align:bottom; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style4 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:18pt; background-color:white }\n" +
                "      th.style4 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:18pt; background-color:white }\n" +
                "      td.style5 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style5 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style6 { vertical-align:bottom; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:10pt; background-color:white }\n" +
                "      th.style6 { vertical-align:bottom; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:10pt; background-color:white }\n" +
                "      td.style7 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:10pt; background-color:white }\n" +
                "      th.style7 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:10pt; background-color:white }\n" +
                "      td.style8 { vertical-align:middle; text-align:right; padding-right:0px; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style8 { vertical-align:middle; text-align:right; padding-right:0px; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style9 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style9 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style10 { vertical-align:bottom; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style10 { vertical-align:bottom; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style11 { vertical-align:bottom; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style11 { vertical-align:bottom; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style12 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:2px solid #000000 !important; border-left:2px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:18pt; background-color:white }\n" +
                "      th.style12 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:2px solid #000000 !important; border-left:2px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:18pt; background-color:white }\n" +
                "      td.style13 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:2px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:18pt; background-color:white }\n" +
                "      th.style13 { vertical-align:middle; text-align:center; border-bottom:2px solid #000000 !important; border-top:2px solid #000000 !important; border-left:none #000000; border-right:2px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:18pt; background-color:white }\n" +
                "      td.style14 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:9pt; background-color:#FFFFFF }\n" +
                "      th.style14 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:9pt; background-color:#FFFFFF }\n" +
                "      td.style15 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#FFFFFF }\n" +
                "      th.style15 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#FFFFFF }\n" +
                "      td.style16 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#FFFFFF }\n" +
                "      th.style16 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#FFFFFF }\n" +
                "      td.style17 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#FFFFFF }\n" +
                "      th.style17 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#FFFFFF }\n" +
                "      td.style18 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:18pt; background-color:white }\n" +
                "      th.style18 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:18pt; background-color:white }\n" +
                "      td.style19 { vertical-align:middle; text-align:right; padding-right:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:18pt; background-color:white }\n" +
                "      th.style19 { vertical-align:middle; text-align:right; padding-right:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:18pt; background-color:white }\n" +
                "      td.style20 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style20 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style21 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:9pt; background-color:#BFBFBF }\n" +
                "      th.style21 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:9pt; background-color:#BFBFBF }\n" +
                "      td.style22 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#BFBFBF }\n" +
                "      th.style22 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#BFBFBF }\n" +
                "      td.style23 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#BFBFBF }\n" +
                "      th.style23 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#BFBFBF }\n" +
                "      td.style24 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#BFBFBF }\n" +
                "      th.style24 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#BFBFBF }\n" +
                "      td.style25 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#BFBFBF }\n" +
                "      th.style25 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#BFBFBF }\n" +
                "      td.style26 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#BFBFBF }\n" +
                "      th.style26 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; font-weight:bold; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:#BFBFBF }\n" +
                "      td.style27 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style27 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style28 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style28 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style29 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style29 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style30 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style30 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style31 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style31 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style32 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style32 { vertical-align:middle; text-align:left; padding-left:0px; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style33 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style33 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style34 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style34 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style35 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style35 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:1px solid #000000 !important; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style36 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style36 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style37 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style37 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style38 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style38 { vertical-align:middle; text-align:center; border-bottom:none #000000; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style39 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style39 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:1px solid #000000 !important; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style40 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style40 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:none #000000; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      td.style41 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      th.style41 { vertical-align:middle; text-align:center; border-bottom:1px solid #000000 !important; border-top:none #000000; border-left:none #000000; border-right:1px solid #000000 !important; color:#000000; font-family:'Calibri'; font-size:11pt; background-color:white }\n" +
                "      table.sheet0 col.col0 { width:48.79999944pt }\n" +
                "      table.sheet0 col.col1 { width:42pt }\n" +
                "      table.sheet0 col.col2 { width:42pt }\n" +
                "      table.sheet0 col.col3 { width:42pt }\n" +
                "      table.sheet0 col.col4 { width:42pt }\n" +
                "      table.sheet0 col.col5 { width:42pt }\n" +
                "      table.sheet0 col.col6 { width:42pt }\n" +
                "      table.sheet0 col.col7 { width:42pt }\n" +
                "      table.sheet0 col.col8 { width:42pt }\n" +
                "      table.sheet0 col.col9 { width:42pt }\n" +
                "      table.sheet0 col.col10 { width:42pt }\n" +
                "      table.sheet0 col.col11 { width:42pt }\n" +
                "      table.sheet0 col.col12 { width:42pt }\n" +
                "      table.sheet0 col.col13 { width:42pt }\n" +
                "      table.sheet0 col.col14 { width:42pt }\n" +
                "      table.sheet0 col.col15 { width:42pt }\n" +
                "      table.sheet0 col.col16 { width:55.57777714pt }\n" +
                "      table.sheet0 col.col17 { width:59.64444376pt }\n" +
                "      table.sheet0 col.col18 { width:42pt }\n" +
                "      table.sheet0 col.col19 { width:42pt }\n" +
                "      table.sheet0 col.col20 { width:42pt }\n" +
                "      table.sheet0 tr { height:15pt }\n" +
                "      table.sheet0 tr.row0 { height:15.75pt }\n" +
                "      table.sheet0 tr.row1 { height:24pt }\n" +
                "      table.sheet0 tr.row2 { height:23.25pt }\n" +
                "      table.sheet0 tr.row41 { height:18.95pt }\n" +
                "      table.sheet0 tr.row42 { height:18.95pt }\n" +
                "      table.sheet0 tr.row43 { height:18.95pt }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "\n" +
                "  <body>\n" +
                "<style>\n" +
                "@page { margin-left: 0.511811024in; margin-right: 0.511811024in; margin-top: 0.787401575in; margin-bottom: 0.787401575in; }\n" +
                "body { margin-left: 0.511811024in; margin-right: 0.511811024in; margin-top: 0.787401575in; margin-bottom: 0.787401575in; }\n" +
                "</style>\n" +
                "    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" id=\"sheet0\" class=\"sheet0\">\n" +
                "        <col class=\"col0\">\n" +
                "        <col class=\"col1\">\n" +
                "        <col class=\"col2\">\n" +
                "        <col class=\"col3\">\n" +
                "        <col class=\"col4\">\n" +
                "        <col class=\"col5\">\n" +
                "        <col class=\"col6\">\n" +
                "        <col class=\"col7\">\n" +
                "        <col class=\"col8\">\n" +
                "        <col class=\"col9\">\n" +
                "        <col class=\"col10\">\n" +
                "        <col class=\"col11\">\n" +
                "        <col class=\"col12\">\n" +
                "        <col class=\"col13\">\n" +
                "        <col class=\"col14\">\n" +
                "        <col class=\"col15\">\n" +
                "        <col class=\"col16\">\n" +
                "        <col class=\"col17\">\n" +
                "        <col class=\"col18\">\n" +
                "        <col class=\"col19\">\n" +
                "        <col class=\"col20\">\n" +
                "        <tbody>\n" +
                "          <tr class=\"row0\">\n" +
                "            <td class=\"column0\">&nbsp;</td>\n" +
                "            <td class=\"column1\">&nbsp;</td>\n" +
                "            <td class=\"column2\">&nbsp;</td>\n" +
                "            <td class=\"column3\">&nbsp;</td>\n" +
                "            <td class=\"column4\">&nbsp;</td>\n" +
                "            <td class=\"column5\">&nbsp;</td>\n" +
                "            <td class=\"column6\">&nbsp;</td>\n" +
                "            <td class=\"column7\">&nbsp;</td>\n" +
                "            <td class=\"column8\">&nbsp;</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row1\">\n" +
                "            <td class=\"column0 style18 f style18\" colspan=\"15\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RECIBO - $numeroRecibo</td>\n" +
                "            \n" +
                "          </tr>\n" +
                "          <tr class=\"row2\">\n" +
                "            <td class=\"column0 style19 s style19\" colspan=\"9\">DESTINO: </td>\n" +
                "            <td class=\"column5 style1 f\"> $destino </td>\n" +
                "            \n" +
                "          </tr>\n" +
                "          <tr class=\"row3\">\n" +
                "            <td class=\"column0\">&nbsp;</td>\n" +
                "            <td class=\"column1\">&nbsp;</td>\n" +
                "            <td class=\"column2\">&nbsp;</td>\n" +
                "            <td class=\"column3\">&nbsp;</td>\n" +
                "            <td class=\"column4\">&nbsp;</td>\n" +
                "            <td class=\"column5\">&nbsp;</td>\n" +
                "            <td class=\"column6\">&nbsp;</td>\n" +
                "            <td class=\"column7\">&nbsp;</td>\n" +
                "            <td class=\"column8\">&nbsp;</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "           \n" +
                "          </tr>\n" +
                "          <tr class=\"row4\">\n" +
                "            <td class=\"column0 style20 s style20\" colspan=\"15\">Recebi do P/4 do 10BPM/M, o material abaixo discriminado: </td>\n" +
                "            \n" +
                "          </tr>\n" +
                "          <tr class=\"row5\">\n" +
                "            <td class=\"column0\">&nbsp;</td>\n" +
                "            <td class=\"column1\">&nbsp;</td>\n" +
                "            <td class=\"column2\">&nbsp;</td>\n" +
                "            <td class=\"column3\">&nbsp;</td>\n" +
                "            <td class=\"column4\">&nbsp;</td>\n" +
                "            <td class=\"column5\">&nbsp;</td>\n" +
                "            <td class=\"column6\">&nbsp;</td>\n" +
                "            <td class=\"column7\">&nbsp;</td>\n" +
                "            <td class=\"column8\">&nbsp;</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row6\">\n" +
                "            <td class=\"column0 style21 s style21\" rowspan=\"2\">QTD</td>\n" +
                "            <td class=\"column1 style22 s style22\" colspan=\"4\" rowspan=\"2\">TIPO</td>\n" +
                "            <td class=\"column5 style22 s style22\" colspan=\"9\" rowspan=\"2\">DESCRIÇÃO</td>\n" +
                "            <td class=\"column7 style23 s style26\" colspan=\"6\" rowspan=\"2\">OBS</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row7\">\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">$qtd do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">$tipo</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">$descricao</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">$obs</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row8\">\n" +
                "            <td class=\"column0 style14 n\">quantidade do material</td>\n" +
                "            <td class=\"column1 style15 s style17\" colspan=\"4\">tipo de material</td>\n" +
                "            <td class=\"column5 style15 s style17\" colspan=\"9\">descrição do material</td>\n" +
                "            <td class=\"column7 style15 s style17\" colspan=\"6\">observações</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          \n" +
                "          <tr class=\"row28\">\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row29\">\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "         \n" +
                "        \n" +
                "          <tr class=\"row38\">\n" +
                "            <td class=\"column0 style30 f style30\" colspan=\"6\">$cidadeDataEx</td>\n" +
                "            <td class=\"column4 style2 null\"></td>\n" +
                "            <td class=\"column5\">&nbsp;</td>\n" +
                "            <td class=\"column6\">&nbsp;</td>\n" +
                "            <td class=\"column7\">&nbsp;</td>\n" +
                "            <td class=\"column8\">&nbsp;</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row39\">\n" +
                "            <td class=\"column0\">&nbsp;</td>\n" +
                "            <td class=\"column1\">&nbsp;</td>\n" +
                "            <td class=\"column2\">&nbsp;</td>\n" +
                "            <td class=\"column3\">&nbsp;</td>\n" +
                "            <td class=\"column4\">&nbsp;</td>\n" +
                "            <td class=\"column5\">&nbsp;</td>\n" +
                "            <td class=\"column6\">&nbsp;</td>\n" +
                "            <td class=\"column7\">&nbsp;</td>\n" +
                "            <td class=\"column8\">&nbsp;</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row40\">\n" +
                "            <td class=\"column0 style31 null style31\" colspan=\"8\"></td>\n" +
                "            <td class=\"column6\">&nbsp;</td>\n" +
                "            <td class=\"column7\">&nbsp;</td>\n" +
                "            <td class=\"column8\">&nbsp;</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row41\">\n" +
                "            <td class=\"column0 style7 s\">Nome:</td>\n" +
                "            <td class=\"column1 style7 f style7\" colspan=\"7\">$nomeGuerra</td>\n" +
                "            <td class=\"column6\">&nbsp;</td>\n" +
                "            <td class=\"column7\">&nbsp;</td>\n" +
                "            <td class=\"column8\">&nbsp;</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row42\">\n" +
                "            <td class=\"column0 style7 s\">Posto/Grad:</td>\n" +
                "            <td class=\"column1 style7 f style7\" colspan=\"3\">$postoGrad</td>\n" +
                "            <td class=\"column6\">&nbsp;</td>\n" +
                "            <td class=\"column7\">&nbsp;</td>\n" +
                "            <td class=\"column8\">&nbsp;</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "          <tr class=\"row43\">\n" +
                "            <td class=\"column0 style7 s\">RE:</td>\n" +
                "            <td class=\"column1 style7 f style7\" colspan=\"3\">$reMike</td>\n" +
                "            <td class=\"column6\">&nbsp;</td>\n" +
                "            <td class=\"column7\">&nbsp;</td>\n" +
                "            <td class=\"column8\">&nbsp;</td>\n" +
                "            <td class=\"column9\">&nbsp;</td>\n" +
                "            <td class=\"column10\">&nbsp;</td>\n" +
                "            <td class=\"column11\">&nbsp;</td>\n" +
                "            <td class=\"column12\">&nbsp;</td>\n" +
                "            <td class=\"column13\">&nbsp;</td>\n" +
                "            <td class=\"column14\">&nbsp;</td>\n" +
                "            <td class=\"column15\">&nbsp;</td>\n" +
                "            <td class=\"column16\">&nbsp;</td>\n" +
                "            <td class=\"column17\">&nbsp;</td>\n" +
                "            <td class=\"column18\">&nbsp;</td>\n" +
                "            <td class=\"column19\">&nbsp;</td>\n" +
                "            <td class=\"column20\">&nbsp;</td>\n" +
                "          </tr>\n" +
                "        </tbody>\n" +
                "    </table>\n" +
                "  </body>\n" +
                "</html>\n"
    }*/
}