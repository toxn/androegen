/**
 * 
 */

package com.cdbs.oegen ;

import android.content.Context ;
import android.database.SQLException ;
import android.database.sqlite.SQLiteDatabase ;
import android.database.sqlite.SQLiteDatabase.CursorFactory ;
import android.database.sqlite.SQLiteOpenHelper ;

/**
 * @author toxn
 */
public class Database
	extends SQLiteOpenHelper
{
	public static enum Type
	{
		Date,
		Source,
		Event,
		EventType,
		Person,
		Name,
		Place,
		Position,
		Role,
		Occupation
	} ;

	/**
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public Database(Context context, String name, CursorFactory factory, int version)
	{
		super(context, name, factory, version) ;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.beginTransaction() ;
		try
		{
			db.execSQL("CREATE TABLE OEGObject (\n" + "IID INTEGER UNIQUE NOT NULL AUTOINCREMENT,\n"
				+ "Type INTEGER,\n" + "GUID TEXT UNIQUE NOT NULL,\n" + "DisplayName TEXT,\n"
				+ "PRIMARY KEY (IID, Type)\n" + ");\n") ;
			db.setTransactionSuccessful() ;
		}
		catch (SQLException ex)
		{
			// TODO: Warn User
		}

		db.endTransaction() ;
	}

	/**
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// TODO Auto-generated method stub

	}

}
