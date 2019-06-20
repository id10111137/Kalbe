package com.tatang.pcit1.kalbe.Library.Hellper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tatang.pcit1.kalbe.Library.Interface.Interface_Kalbe;
import com.tatang.pcit1.kalbe.Library.Model.M_Brand;
import com.tatang.pcit1.kalbe.Library.Model.M_Costumer;
import com.tatang.pcit1.kalbe.Library.Model.M_Interface;
import com.tatang.pcit1.kalbe.Library.Model.M_Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class Hellper_Kalbe extends SQLiteOpenHelper implements Interface_Kalbe {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Db_Kalbe";
    private static final String TABLE_BRAND = "tbl_brand";
    private static final String TABLE_PRODUCT = "tbl_product";
    private static final String TABLE_COSTUMER = "tbl_costumer";
    private static final String TABLE_PEMBELIAN = "tbl_pembelian";

    private static final String KEY_BRANDID = "intBrandID";
    private static final String KEY_TXTBRANDNAME = "txtBrandName";
    private static final String KEY_DTINSERTED = "dtInserted";

    private static final String intProductID = "intProductID";
    private static final String txtProductCode = "txtProductCode";
    private static final String txtProductName = "txtProductName";
    private static final String dtInserted = "dtInserted";

    private static final String intCustomerID = "intCustomerID";
    private static final String txtCustomerName = "txtCustomerName";
    private static final String txtCustomerAddress = "txtCustomerAddress";
    private static final String bitGender = "bitGender";
    private static final String Inserted = "Inserted";

    private static final String intSalesOrderID = "intSalesOrderID";
    private static final String dtSalesOrder = "dtSalesOrder";
    private static final String intQty = "intQty";


    public Hellper_Kalbe(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BRAND =
                "CREATE TABLE " + TABLE_BRAND +
                        "("
                        + KEY_BRANDID +
                        " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + KEY_TXTBRANDNAME +
                        " TEXT,"
                        + KEY_DTINSERTED +
                        " TEXT" + ")";

        db.execSQL(CREATE_BRAND);

        String CREATE_PRODUCT =
                "CREATE TABLE " + TABLE_PRODUCT +
                        "("
                        + intProductID +
                        " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + txtProductCode +
                        " TEXT,"
                        + txtProductName +
                        " TEXT,"
                        + dtInserted +
                        " TEXT" + ")";

        db.execSQL(CREATE_PRODUCT);

        String CREATE_CUSTOMER =
                "CREATE TABLE " + TABLE_COSTUMER +
                        "("
                        + intCustomerID +
                        " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + txtCustomerName +
                        " TEXT,"
                        + txtCustomerAddress +
                        " TEXT,"
                        + bitGender +
                        " TEXT," +
                        Inserted +
                        " TEXT" + ")";

        db.execSQL(CREATE_CUSTOMER);

        String CREATE_PEMBELIAN =
                "CREATE TABLE " + TABLE_PEMBELIAN +
                        "("
                        + intSalesOrderID +
                        " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + dtSalesOrder +
                        " TEXT,"
                        + intQty +
                        ")";

        db.execSQL(CREATE_PEMBELIAN);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BRAND);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COSTUMER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PEMBELIAN);
        onCreate(db);
    }

    @Override
    public String AddKalbe(M_Interface m_interface) throws SQLException {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(intCustomerID, m_interface.getIntCustomerID());
        values.put(intProductID, m_interface.getIntProductID());
        values.put(dtSalesOrder, m_interface.getDtSalesOrder());
        values.put(intQty, m_interface.getIntQty());
        db.insert(TABLE_PEMBELIAN, null, values);
        db.close();
        return "sukses";
    }

    @Override
    public ArrayList<M_Brand> getMBrand() throws SQLException {
        ArrayList<M_Brand> listBrand = new ArrayList<M_Brand>();
        String query = "SELECT * FROM " + TABLE_BRAND;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                M_Brand m_brand = new M_Brand();
                m_brand.setIntBrandID(String.valueOf(cursor.getInt(0)));
                m_brand.setTxtBrandName(cursor.getString(1));
                m_brand.setDtInserted(cursor.getString(2));
                listBrand.add(m_brand);
            } while (cursor.moveToNext());
        }
        return listBrand;
    }

    @Override
    public ArrayList<M_Product> getMProduct() throws SQLException {
        ArrayList<M_Product> listProduct = new ArrayList<M_Product>();
        String query = "SELECT * FROM " + TABLE_PRODUCT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                M_Product m_product = new M_Product();
                m_product.setIntProductID(String.valueOf(cursor.getInt(0)));
                m_product.setTxtProductCode(cursor.getString(1));
                m_product.setTxtProductName(cursor.getString(2));
                m_product.setDtInserted(cursor.getString(3));
                listProduct.add(m_product);
            } while (cursor.moveToNext());
        }
        return listProduct;
    }

    @Override
    public ArrayList<M_Costumer> getMCostumer() throws SQLException {
        ArrayList<M_Costumer> listCostumer = new ArrayList<M_Costumer>();
        String query = "SELECT * FROM " + TABLE_COSTUMER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                M_Costumer m_costumer = new M_Costumer();
                m_costumer.setIntCustomerID(String.valueOf(cursor.getInt(0)));
                m_costumer.setTxtCustomerName(cursor.getString(1));
                m_costumer.setTxtCustomerAddress(cursor.getString(2));
                m_costumer.setBitGender(cursor.getString(3));
                m_costumer.setBitGender(cursor.getString(4));
                listCostumer.add(m_costumer);
            } while (cursor.moveToNext());
        }
        return listCostumer;
    }

    @Override
    public ArrayList<M_Interface> getMpembelian() throws SQLException {
        ArrayList<M_Interface> listPembelian = new ArrayList<M_Interface>();
        String query = "SELECT * FROM " + TABLE_PEMBELIAN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                M_Interface weathers = new M_Interface();
                weathers.setIntSalesOrderID(String.valueOf(cursor.getInt(0)));
                weathers.setIntCustomerID(cursor.getString(1));
                weathers.setIntProductID(cursor.getString(2));
                weathers.setDtSalesOrder(cursor.getString(3));
                weathers.setIntQty(cursor.getString(4));
                listPembelian.add(weathers);
            } while (cursor.moveToNext());
        }
        return listPembelian;
    }


}
