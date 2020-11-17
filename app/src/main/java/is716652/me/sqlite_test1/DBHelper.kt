package is716652.me.sqlite_test1

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase

class DBHelper(context: Context,DbName:String,DbVer:Int):SQLiteOpenHelper(context,DbName,null,DbVer) {
    private val DbName = "jixi.db"
    private val DbVer = 3

    object SQL{
        val strCreateDB ="create table xzgh(bm char(6) primary key ,mc varchar(10))"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val FIRST_DbVer= 1
        val sql1 = "insert into xzqh(bm,mc) values('131126','你好现场')"
        db.execSQL(SQL.strCreateDB)
        db.execSQL(sql1)

        updateDb(db,FIRST_DbVer,DbVer)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        updateDb(db,oldVersion,newVersion)
    }

    private fun updateDb(db:SQLiteDatabase,oldVersion:Int,newVersion:Int){

    }
}