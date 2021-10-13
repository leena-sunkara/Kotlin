package com.masai.myjournalapp.adapter

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.masai.myjournalapp.RoutineModel

class DatabaseHandler(val context: Context) :
    SQLiteOpenHelper(context, "journaldb", null, 1) {

    companion object {
        val TABLE_NAME = "journal_table"
        val ID = "id"
        val TITLE = "title"
        val DESC = "desc"
        val DAY = "day"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createQuery = "CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY," +
                "$TITLE TEXT, $DESC TEXT, $DAY TEXT)"
        db?.execSQL(createQuery)
    }

    fun getRoutines(): MutableList<RoutineModel> {
        val listRoutines: MutableList<RoutineModel> = mutableListOf<RoutineModel>()
        val db = readableDatabase
        val query = "select * from $TABLE_NAME"
        val cursor: Cursor = db.rawQuery(query, null)
        if (cursor != null && cursor.count > 0) {
            cursor.moveToFirst()
            do {
                val idIndex = cursor.getColumnIndex(ID)
                val titleIndex = cursor.getColumnIndex(TITLE)
                val descIndex = cursor.getColumnIndex(DESC)
                val dayIndex = cursor.getColumnIndex(DAY)

                val id: Int = cursor.getInt(idIndex)
                val title: String = cursor.getString(titleIndex)
                val desc: String = cursor.getString(descIndex)
                val day: String = cursor.getString(dayIndex)

                val routineModel = RoutineModel(id, title, desc, day)
                listRoutines.add(routineModel)
            } while (cursor.moveToNext())
        }
        return listRoutines
    }

    fun insertRoutine(title: String, desc: String, day: String) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(TITLE, title)
        values.put(DESC, desc)
        values.put(DAY, day)
        val id = db.insert(TABLE_NAME, null, values)
        if (id.toInt() == -1) {
            //Error
            Toast.makeText(context, "Error: Data is not inserted", Toast.LENGTH_SHORT).show()
        } else {
            //Success
            Toast.makeText(context, "Data inserted successfully", Toast.LENGTH_SHORT).show()
        }
    }

    fun updateRoutine(id: Int, newTitle: String, newDesc: String, newDay: String) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(ID, id)
        values.put(TITLE, newTitle)
        values.put(DESC, newDesc)
        values.put(DAY, newDay)
        val affectedRows = db.update(TABLE_NAME, values, "id = $id", null)
        if (affectedRows > 0) {
            //Success
            Toast.makeText(context, "Data updated successfully", Toast.LENGTH_SHORT).show()
        } else {
            //Failure
            Toast.makeText(context, "Error: Data is not updated", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteRoutine(id: Int) {
        val db = writableDatabase
        val affectedRows = db.delete(TABLE_NAME, "id = $id", null)
        if (affectedRows > 0) {
            //Success
            Toast.makeText(context, "Data deleted successfully", Toast.LENGTH_SHORT).show()
        } else {
            //Failure
            Toast.makeText(context, "Error: Data is not deleted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}