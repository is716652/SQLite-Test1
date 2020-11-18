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

        if(newVersion > oldVersion)
        {
            for (i in oldVersion until newVersion) {
                when (i) {
                    1 -> { }
                    2 -> upToVer2(db)
                    3 -> upToVer3(db)
                }
            }
        }
        else {
            for (i in newVersion until oldVersion) {
                when (i) {
                    1 -> downToVer1(db)
                    2 -> downToVer2(db)
                    3 -> { }
                }

            }
        }
    }

    private fun upToVer2(db:SQLiteDatabase) {
        db.execSQL("insert into xzqh(bm,mc) values('131127','景县')")
        db.execSQL("insert into xzqh(bm,mc) values('131128','阜成县')")
    }

    private fun upToVer3(db:SQLiteDatabase){
        db.execSQL("delete from xzqh where bm ='131127'")
        db.execSQL("insert into xzqh(bm,mc) values('131121','冬强县')")
        db.execSQL("insert into xzqh(bm,mc) values('131122','式邑县')")
    }

    private fun downToVer1(db:SQLiteDatabase){
        db.execSQL("delete from xzqh where bm ='131127'")
        db.execSQL("delete from xzqh where bm ='131128'")
    }
    private fun downToVer2(db:SQLiteDatabase){
        db.execSQL("insert into xzqh(bm,mc) values('131127','景县')")
        db.execSQL("delete from xzqh where bm ='131121'")
        db.execSQL("delete from xzqh where bm ='131122'")
    }

}