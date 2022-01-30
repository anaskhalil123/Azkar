package com.a.khalil.azkarapplication.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.a.khalil.azkarapplication.model.Classification
import com.a.khalil.azkarapplication.model.Theker

const val DB_NAME = "ThekerDB"
const val THEKER_TABLE_NAME = "THEKER"
const val CLASSIFICATION_TABLE_NAME = "CLASSIFICATION"
const val THEKERTOCLASS_TABLE_NAME = "THEKERTOCLASS"
var version = 1

class DB(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(
            "CREATE TABLE $THEKER_TABLE_NAME(\n" +
                    "ID INTEGER PRIMARY KEY ,\n" +
                    "INTRO VARCHAR ,\n" +
                    "TEXT VARCHAR NOT NULL,\n" +
                    "BUTTONNUMBER INTEGER NOT NULL,\n" +
                    "REWARD VARCHAR,\n" +
                    "EVIDENCE VARCHAR\n" +
                    ");"
        )
        p0.execSQL(
            "CREATE TABLE $CLASSIFICATION_TABLE_NAME(\n" +
                    "ID INTEGER PRIMARY KEY ,\n" +
                    "NAME VARCHAR\n" +
                    ");"
        )
        p0.execSQL(
            "CREATE TABLE $THEKERTOCLASS_TABLE_NAME(\n" +
                    "THEKER_ID INTEGER REFERENCES $THEKER_TABLE_NAME(ID),\n" +
                    "CLASS_ID INTEGER REFERENCES $CLASSIFICATION_TABLE_NAME(ID),\n" +
                    "NUMBERFORTHEKER INTEGER,\n" +
                    "PRIMARY KEY (THEKER_ID, CLASS_ID)\n" +
                    ");"
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS $THEKER_TABLE_NAME")
        p0.execSQL("DROP TABLE IF EXISTS $CLASSIFICATION_TABLE_NAME")
        p0.execSQL("DROP TABLE IF EXISTS $THEKERTOCLASS_TABLE_NAME")
        onCreate(p0)
    }

    fun insertTheker(theker: Theker): Boolean {
        val contentValues = ContentValues()
        contentValues.put("ID", theker.id)
        contentValues.put("intro", theker.intro)
        contentValues.put("TEXT", theker.text)
        contentValues.put("BUTTONNUMBER", theker.buttonNumber)
        contentValues.put("REWARD", theker.reward)
        contentValues.put("EVIDENCE", theker.evidence)
        return (this.writableDatabase.insert(THEKER_TABLE_NAME, null, contentValues) > 0)
    }

    fun insertClass(classification: Classification): Long {
        val contentValues = ContentValues()
        contentValues.put("ID", classification.id)
        contentValues.put("NAME", classification.name)
        return writableDatabase.insert(CLASSIFICATION_TABLE_NAME, null, contentValues)
    }

    fun insertThekerToClass(theker_id: Int, classification_id: Int, numberForTheker: Int): Boolean {
        val contentValues = ContentValues()
        contentValues.put("THEKER_ID", theker_id)
        contentValues.put("CLASS_ID", classification_id)
        contentValues.put("NUMBERFORTHEKER", numberForTheker)
        return (writableDatabase.insert(THEKERTOCLASS_TABLE_NAME, null, contentValues) > 0)
    }

    fun getTheker(theker_id: Int): Theker? {
        val cursor = readableDatabase.rawQuery(
            "SELECT * FROM $THEKER_TABLE_NAME WHERE ID = $theker_id",
            null
        )
        if (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndex("ID"))
            val intro = cursor.getString(cursor.getColumnIndex("INTRO"))
            val buttonNumber = cursor.getInt(cursor.getColumnIndex("BUTTONNUMBER"))
            val evidence = cursor.getString(cursor.getColumnIndex("EVIDENCE"))
            val text = cursor.getString(cursor.getColumnIndex("TEXT"))
            val reward = cursor.getString(cursor.getColumnIndex("REWARD"))
            val theker = Theker(id, intro, text, buttonNumber, reward, evidence)
            cursor.close()
            return theker
        }
        return null
    }

    fun getThekersForClass(classification_id: Int): Array<Array<Any>> {
        var index = 0
        val cursor = readableDatabase.rawQuery(
            "SELECT * FROM $THEKERTOCLASS_TABLE_NAME WHERE CLASS_ID = $classification_id",
            null
        )
        val array: Array<Array<Any>> = Array(cursor.count) { Array(2) { } }
        /* we have array that have (theker , number),
        then we have an array of it
        */
        while (cursor.moveToNext()) {
            val theker_id = cursor.getInt(cursor.getColumnIndex("THEKER_ID"))
            val theker_number = cursor.getInt(cursor.getColumnIndex("NUMBERFORTHEKER"))
            if (getTheker(theker_id) != null) {
                Log.e("cursor count", cursor.count.toString())
                Log.e("wake up >>>>", getTheker(theker_id)!!.text)
                array.set(index, arrayOf(getTheker(theker_id)!!, theker_number))
            }
            index++
        }
        cursor.close()
        return array
    }

    fun getClasses(): ArrayList<Classification> {
        val classifications = ArrayList<Classification>()
        val cursor = readableDatabase.rawQuery("SELECT * FROM $CLASSIFICATION_TABLE_NAME", null)
        while (cursor.moveToNext()) {
            classifications.add(
                Classification(
                    cursor.getInt(cursor.getColumnIndex("ID")),
                    cursor.getString(cursor.getColumnIndex("NAME"))
                )
            )
        }
        cursor.close()
        return classifications
    }


}