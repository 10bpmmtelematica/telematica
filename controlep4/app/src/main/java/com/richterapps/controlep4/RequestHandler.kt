package com.richterapps.controlep4

import android.content.Context
import android.widget.Toast
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.*
import javax.net.ssl.HttpsURLConnection

class RequestHandler {
    //Method to send httpPostRequest
    //This method is taking two arguments
    //First argument is the URL of the script to which we will send the request
    //Other is an HashMap with name value pairs containing the data to be send with the request
    fun sendPostRequest(requestURL: String?,
                        postDataParams: HashMap<String, String>): String {
        //Creating a URL
        val url: URL

        //StringBuilder object to store the message retrieved from the server
        var sb = StringBuilder()
        try {
            //Initializing Url
            url = URL(requestURL)

            //Creating an httmlurl connection
            val conn = url.openConnection() as HttpURLConnection

            //Configuring connection properties
            conn.readTimeout = 15000
            conn.connectTimeout = 15000
            conn.requestMethod = "POST"
            conn.doInput = true
            conn.doOutput = true

            //Creating an output stream
            val os = conn.outputStream

            //Writing parameters to the request
            //We are using a method getPostDataString which is defined below
            val writer = BufferedWriter(
                    OutputStreamWriter(os, "UTF-8"))
            writer.write(getPostDataString(postDataParams))
            writer.flush()
            writer.close()
            os.close()
            val responseCode = conn.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val br = BufferedReader(InputStreamReader(conn.inputStream))
                sb = StringBuilder()
                var response: String?
                //Reading server response
                while (br.readLine().also { response = it } != null) {
                    sb.append(response)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return sb.toString()
    }

    fun sendGetRequest(requestURL: String?): String {
        val sb = StringBuilder()
        try {
            val url = URL(requestURL)
            val con = url.openConnection() as HttpURLConnection
            val bufferedReader = BufferedReader(InputStreamReader(con.inputStream))
            var s: String
            while (bufferedReader.readLine().also { s = it } != null) {
                sb.append(s+"\n")
                //sb.append(URLEncoder.encode("áàâãõóòúç", "UTF-8"))
                //println("------------------$s")
            }
        } catch (e: Exception) {
            //println("------------------$e")
        }
        //println("------------------${sb.toString()}")
        return sb.toString()
    }

    @Throws(UnsupportedEncodingException::class)
    private fun getPostDataString(params: HashMap<String, String>): String {
        val result = StringBuilder()
        var first = true
        for ((key, value) in params) {
            if (first){ first = false }
            else{
                result.append("&")
                result.append(URLEncoder.encode(key, "UTF-8"))
                result.append("=")
                result.append(URLEncoder.encode(value, "UTF-8"))}
            }
        return result.toString()
    }
}