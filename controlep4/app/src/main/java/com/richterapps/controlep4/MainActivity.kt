package com.richterapps.controlep4

//import android.support.v7.app.AlertDialog
//import android.support.v7.app.AppCompatActivity
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.net.URLEncoder
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var editTextMatId: EditText? = null
    var editTextCodigo: EditText? = null
    var editTextTipo: EditText? = null
    var editTextSubTipo: EditText? = null
    var editTextDescricao: EditText? = null
    var edtQtd: EditText? = null
    var editTextData: EditText? = null
    var progressBar: ProgressBar? = null
    var listView: ListView? = null
    var buttonAddUpdate: Button? = null
    var materialList: ArrayList<Material>? = null
    var isUpdating = false
    var btnScan:Button?=null
    var materialUp : Material? = null
    var busca:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextMatId = findViewById<View>(R.id.editTextID) as EditText
        editTextCodigo = findViewById<View>(R.id.editTextCodigo) as EditText
        editTextTipo = findViewById<View>(R.id.editTextTipo) as EditText
        editTextSubTipo = findViewById<View>(R.id.editTextSubTipo) as EditText
        editTextDescricao = findViewById<View>(R.id.editTextDescricao) as EditText
        edtQtd = findViewById<View>(R.id.editTextQtd) as EditText
        editTextData = findViewById<View>(R.id.editTextData) as EditText
        buttonAddUpdate = findViewById<View>(R.id.buttonAddUpdate) as Button
        btnScan = findViewById<View>(R.id.btnScan) as Button
        progressBar = findViewById<View>(R.id.progressBar) as ProgressBar
        listView = findViewById<View>(R.id.listViewMat) as ListView
        materialList = ArrayList()
        buttonAddUpdate!!.setOnClickListener {
            /*if (isUpdating) {
                //updateHero()
            } else {
                createHero()
            }

            editTextMatId!!.setText("")
            editTextCodigo!!.setText("")
            editTextTipo!!.setText("")
            editTextSubTipo!!.setText("")
            editTextDescricao!!.setText("")
            edtQtd!!.setText("")
            editTextData!!.setText("")
            buttonAddUpdate!!.text = "Add"
*/


        }


        btnScan?.setOnClickListener {
            val scanner = IntentIntegrator(this)
            scanner.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
            scanner.setBeepEnabled(false) //retira o beep ao scannear
            scanner.initiateScan() // `this` is the current Activity
            //scanner.
        }
        readHeroes()
    }

    private fun createHero() {
        val codigo = editTextCodigo!!.text.toString().trim { it <= ' ' }
        val tipo = editTextTipo!!.text.toString().trim { it <= ' ' }
        val subtipo = editTextSubTipo!!.text.toString().trim { it <= ' ' }
        val descricao = editTextDescricao!!.text.toString().trim { it <= ' ' }
        val qtd = edtQtd!!.text.toString().trim { it <= ' ' }
        val data = editTextData!!.text.toString().trim { it <= ' ' }

        if (TextUtils.isEmpty(codigo)) {
            editTextCodigo!!.error = "Please enter name"
            editTextCodigo!!.requestFocus()
            return
        }
        if (TextUtils.isEmpty(tipo)) {
            editTextTipo!!.error = "Please enter real name"
            editTextTipo!!.requestFocus()
            return
        }
        val params = HashMap<String, String>()
        params.put("codigo", codigo)
        params.put("tipo", tipo)
        params.put("subtipo", subtipo)
        params.put("descricao", descricao)
        params.put("qtd", qtd)
        params.put("data", data)
        val request = PerformNetworkRequest(Api.URL_CREATE_MATERIAL, params, CODE_POST_REQUEST)
        request.execute()
        //Toast.makeText(applicationContext, Api.URL_CREATE_HERO+"$params, $CODE_POST_REQUEST", Toast.LENGTH_LONG).show()
    }

    private fun readHeroes() {
        val request = PerformNetworkRequest(Api.URL_READ_MATERIAL, null, CODE_GET_REQUEST)
        request.execute()
        //Toast.makeText(applicationContext, Api.URL_READ_HEROES, Toast.LENGTH_LONG).show()
    }

    private fun scanUpdate(codigo:String){
        val request = PerformNetworkRequest(Api.URL_BUSCA_MATERIAL + codigo, null, CODE_GET_REQUEST)
        //Toast.makeText(applicationContext, "$codigo", Toast.LENGTH_SHORT).show()
        request.execute()
    }




    private fun updateHero() {
        val id = editTextMatId!!.text.toString()
        val codigo = editTextCodigo!!.text.toString().trim { it <= ' ' }
        val tipo = editTextTipo!!.text.toString().trim { it <= ' ' }
        val subtipo = editTextSubTipo!!.text.toString().trim { it <= ' ' }
        val descricao = editTextDescricao!!.text.toString().trim { it <= ' ' }
        val qtd = edtQtd!!.text.toString().trim { it <= ' ' }
        val data = editTextData!!.text.toString().trim { it <= ' ' }
        if (TextUtils.isEmpty(codigo)) {
            editTextCodigo!!.error = "Please enter name"
            editTextCodigo!!.requestFocus()
            return
        }
        if (TextUtils.isEmpty(tipo)) {
            editTextTipo!!.error = "Please enter real name"
            editTextTipo!!.requestFocus()
            return
        }
        val params = HashMap<String, String>()
        params["id"] = id
        params["codigo"] = codigo
        params["tipo"] = tipo
        params["subtipo"] = subtipo
        params["descricao"] = descricao
        params["qtd"] = qtd
        params["data"] = data
        val request = PerformNetworkRequest(Api.URL_UPDATE_MATERIAL, params, CODE_POST_REQUEST)
        request.execute()
        buttonAddUpdate!!.text = "Add"
        editTextCodigo!!.setText("")
        editTextTipo!!.setText("")
        edtQtd!!.setText("")
        isUpdating = false
    }

    private fun deleteHero(id: Int) {
        val request = PerformNetworkRequest(Api.URL_DELETE_MATERIAL + id, null, CODE_GET_REQUEST)
        request.execute()
    }


    private fun refreshHeroList(heroes: JSONArray) {
        //materialList!!.clear()
        var obj=heroes
        var listitemDesc = arrayOfNulls <String> (obj.length())
        var listitemId = arrayOfNulls <String> (obj.length())
        var listitemCod = arrayOfNulls <String> (obj.length())
        var listitemTip = arrayOfNulls <String> (obj.length())
        var listitemIdSub = arrayOfNulls <String> (obj.length())
        var listitemData = arrayOfNulls <String> (obj.length())
        var listitemIdQtd = arrayOfNulls <String> (obj.length())
        /*for (i in 0..heroes.length()) {
            var obj2 = obj.get(i)
            listitem[i] = obj2.toString()
            *//*materialList!!.add(Material(
                    obj2.getInt("id"),
                    obj2.getString("codigo"),
                    obj2.getString("tipo"),
                    obj2.getString("subtipo"),
                    obj2.getString("descricao"),
                    obj2.getString("qtd"),
                    obj2.getString("data")
            ))*//*
        }*/



        for (i in 0 until obj.length()) {
            val recipe = obj.getJSONObject(i)
            listitemDesc[i] = recipe.getString("descricao")
            listitemId[i] = recipe.getString("id")
            listitemCod[i] = recipe.getString("codigo")
            listitemTip[i] = recipe.getString("tipo")
            listitemIdSub[i] = recipe.getString("subtipo")
            listitemData[i] = recipe.getString("data")
            listitemIdQtd[i] = recipe.getString("qtd")
        }

        val adapter = ArrayAdapter ( this , android.R.layout.simple_list_item_1, listitemDesc)//HeroAdapter(materialList!!)//materialList!!)
        listView!!.adapter = adapter

        listView!!.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->

            var pos = position
            var iD = (position + 1).toString()
            Toast.makeText(this, " $position", Toast.LENGTH_SHORT).show()
            isUpdating = true
            editTextMatId!!.setText(iD)
            editTextCodigo!!.setText(listitemCod[pos]!!)
            editTextTipo!!.setText(listitemTip[pos]!!)
            editTextSubTipo!!.setText(listitemIdSub[pos]!!)
            editTextDescricao!!.setText(listitemDesc[pos]!!)
            edtQtd!!.setText(listitemIdQtd[pos]!!)
            editTextData!!.setText(listitemData[pos]!!)
            buttonAddUpdate!!.text = "Update"

        })

    }


    private fun refreshHero(heroes: JSONArray) {
        //materialList!!.clear()
        //var obj=heroes.getJSONObject(0).getString("codigo")
        Toast.makeText(this, " $heroes", Toast.LENGTH_SHORT).show()



        //materialList!!.clear()
        var obj=heroes
        var listitemDesc = arrayOfNulls <String> (obj.length())
        var listitemId = arrayOfNulls <String> (obj.length())
        var listitemCod = arrayOfNulls <String> (obj.length())
        var listitemTip = arrayOfNulls <String> (obj.length())
        var listitemIdSub = arrayOfNulls <String> (obj.length())
        var listitemData = arrayOfNulls <String> (obj.length())
        var listitemIdQtd = arrayOfNulls <String> (obj.length())
        /*for (i in 0..heroes.length()) {
            var obj2 = obj.get(i)
            listitem[i] = obj2.toString()
            *//*materialList!!.add(Material(
                    obj2.getInt("id"),
                    obj2.getString("codigo"),
                    obj2.getString("tipo"),
                    obj2.getString("subtipo"),
                    obj2.getString("descricao"),
                    obj2.getString("qtd"),
                    obj2.getString("data")
            ))*//*
        }*/



        for (i in 0..obj.length()) {
            val recipe = obj.getJSONObject(i)
            listitemDesc[i] = recipe.getString("descricao")
            listitemId[i] = recipe.getString("id")
            listitemCod[i] = recipe.getString("codigo")
            listitemTip[i] = recipe.getString("tipo")
            listitemIdSub[i] = recipe.getString("subtipo")
            listitemData[i] = recipe.getString("data")
            listitemIdQtd[i] = recipe.getString("qtd")

            if(listitemCod[i]==busca){
                Toast.makeText(this, " $i", Toast.LENGTH_SHORT).show()
                isUpdating = true
                editTextMatId!!.setText(listitemId[i])
                editTextCodigo!!.setText(listitemCod[i]!!)
                editTextTipo!!.setText(listitemTip[i]!!)
                editTextSubTipo!!.setText(listitemIdSub[i]!!)
                editTextDescricao!!.setText(listitemDesc[i]!!)
                edtQtd!!.setText(listitemIdQtd[i]!!)
                editTextData!!.setText(listitemData[i]!!)
                buttonAddUpdate!!.text = "Update"
            }

        }
    }

    private inner class PerformNetworkRequest internal constructor(var url: String, var params: HashMap<String, String>?, var requestCode: Int) : AsyncTask<Void?, Void?, String?>() {
        override fun onPreExecute() {
            super.onPreExecute()
            progressBar!!.visibility = View.VISIBLE
        }

        override fun onPostExecute(s: String?) {
            super.onPostExecute(s!!)
            progressBar!!.visibility = View.GONE
            //var result = JSONObject(s)
            try {
                //var ss:String = URLEncoder.encode("áàâãõóòúç", "utf-8")

                val `object` = JSONObject(s!!)
                //Toast.makeText(applicationContext, "$s", Toast.LENGTH_SHORT).show()
                //refreshHeroList(`object`.getJSONArray("materiais"))
                //var array =`object`.getJSONArray("").toString()
                if (`object`.getBoolean("error")) {
                    Toast.makeText(applicationContext, `object`.getString("message"), Toast.LENGTH_SHORT).show()
                    //Toast.makeText(applicationContext, "OK"+`object`.optString("materiais"), Toast.LENGTH_SHORT).show()
                    //refreshHeroList(`object`.getJSONArray("materiais"))
                    //Toast.makeText(applicationContext, " Array : $array", Toast.LENGTH_SHORT).show()
                    refreshHero(`object`.getJSONArray("materiais"))
                }
                //Toast.makeText(applicationContext, "OK"+`object`.getJSONArray("materiais"), Toast.LENGTH_LONG).show()
                //refreshHeroList(`object`.getJSONArray("materiais"))
                refreshHero(`object`.getJSONArray("materiais"))
                //Toast.makeText(applicationContext, "$s", Toast.LENGTH_SHORT).show()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }

        override fun doInBackground(vararg params2: Void?): String? {
            val requestHandler = RequestHandler()
            if (requestCode == CODE_POST_REQUEST) return params?.let {
                requestHandler.sendPostRequest(url,
                    it
                )
            }
            return if (requestCode == CODE_GET_REQUEST) requestHandler.sendGetRequest(url) else null
        }
    }

    internal inner class HeroAdapter(var materialList: ArrayList<Material>?) : BaseAdapter() {
        override fun getCount(): Int {
            return materialList!!.size
        }

        override fun getItem(position: Int): Any {
            return materialList!![position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val inflater = layoutInflater
            val listViewItem = inflater.inflate(R.layout.layout_hero_list, null, true)
            val textViewName = listViewItem.findViewById<TextView>(R.id.textViewName)
            val textViewUpdate = listViewItem.findViewById<TextView>(R.id.textViewUpdate)
            val textViewDelete = listViewItem.findViewById<TextView>(R.id.textViewDelete)
            val material = getItem(position) as Material
            //val material = materialList?.get(position)

            textViewName.text = material?.descricao
            textViewUpdate.setOnClickListener {
                isUpdating = true
                editTextMatId!!.setText(material?.id.toString())
                editTextCodigo!!.setText(material?.codigo)
                editTextTipo!!.setText(material?.tipo)
                editTextSubTipo!!.setText(material?.subtipo)
                editTextDescricao!!.setText(material?.descricao)
                edtQtd!!.setText(material?.qtd)
                editTextTipo!!.setText(material?.data)
                buttonAddUpdate!!.text = "Update"
            }
            textViewDelete.setOnClickListener {
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("Delete " + material?.descricao)
                    .setMessage("Are you sure you want to delete it?")
                    .setPositiveButton(android.R.string.yes) { dialog, which -> deleteHero(material!!.id) }
                    .setNegativeButton(android.R.string.no) { dialog, which -> }
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show()
            }
            return listViewItem
        }
    }

    companion object {
        private const val CODE_GET_REQUEST = 1024
        private const val CODE_POST_REQUEST = 1025
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            val result: IntentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    //Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                    editTextCodigo!!.setText(result.contents)
                    scanUpdate(editTextCodigo?.text.toString())
                    busca = editTextCodigo?.text.toString()
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

}