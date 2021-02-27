package com.richterapps.classesmodelo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class HelperDB(context: Context?, ) :
    SQLiteOpenHelper(context, NAME_DB, null, VERSION) {
    companion object{
        val NAME_DB = "modelo_pessoa.db"
        val VERSION = 1
        val TB_NAME = "modelo_pessoa"
        val DROP = "DROP TABLE IF EXISTS $TB_NAME"
        val ID = "id"
        val NOME = "nome"
        val EMAIL = "email"
        val TELEFONE = "telefone"
        val CREATE = "CREATE TABLE $TB_NAME ("+
                "$ID INTEGER NOT NULL,"+
                "$NOME TEXT,"+
                "$EMAIL TEXT,"+
                "$TELEFONE TEXT,"+
                ""+
                "PRIMARY KEY($ID AUTOINCREMENT)"+
                ")"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if(oldVersion != newVersion){
            db?.execSQL(DROP)
        }
    }
}