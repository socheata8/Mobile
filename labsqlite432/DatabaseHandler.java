package buusk.bc.labsqlite432;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.StaticLayout;
import android.view.View;

import java.security.Key;

/**
 * Created by worldmac on 2/16/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int version = 1;
    private static final String name = "contactsManager";

    public DatabaseHandler(Context context,) {
        super(context, name, null, version);
    }

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";

    private static final String TABLE_CONTACTS = "contacts";

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String Sqlstring = "Create Table contacts (id INTEGER Primary Key, name Text,Phone_number Text)"
        String CREATE_CONTACT_TABLE = "Create Table " + TABLE_CONTACTS + "("
                + KEY_ID + "INTEGER Primary Key," + KEY_NAME + "Text, "
                + KEY_PH_NO + " Text)";
        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newversion) {
        db.execSQL(" Drop Table if Exists " + TABLE_CONTACTS);
        onCreate(db);

    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
    // Adding new contact
    void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Contact Name
        values.put(KEY_PH_NO, contact.getPhoneNumber()); // Contact Phone

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close();
        // Closing database connection

    }
        // Getting single contact
        Contact getContact ( int id){
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query(TABLE_CONTACTS,
                    new String[]{KEY_ID, KEY_NAME, KEY_PH_NO}, KEY_ID + "=?",
                    new String[]{String.valueOf(id)}, null, null, null, null);
            if (cursor != null)
                cursor.moveToFirst();
            Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2));
            // return contact
            return contact;
        }
    }
