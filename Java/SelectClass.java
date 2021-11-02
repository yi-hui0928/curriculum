package com.example.curriculum;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SelectClass extends AppCompatActivity {

    private SQLiteDatabase db=null;
    private final static String CREATE_TABLE="CREATE TABLE table01"+
            "(_id INTEGER PRIMARY KEY,name TEXT,price TEXT)";

    ListView listview01;
    Button btnSearch,btnSearchAll;
    EditText edtID;
    Cursor cursor;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_list);

        //取得元件
        edtID=(EditText)findViewById(R.id.edtID);
        btnSearch=(Button)findViewById(R.id.btnSearch);
        btnSearchAll=(Button)findViewById(R.id.btnSearchAll);
        listview01=(ListView)findViewById(R.id.ListView01);
        //設定偵聽
        btnSearch.setOnClickListener(myListener);
        btnSearchAll.setOnClickListener(myListener);
        listview01.setOnItemClickListener(listview01Listener);

        Intent intent_=getIntent();
        Bundle bundle=intent_.getExtras();
        String sel=bundle.getString("SEL").toString();

        //建立資料庫
        db=openOrCreateDatabase("db1.db",MODE_PRIVATE,null);
        try{
            db.execSQL(CREATE_TABLE);//建立資料表
            db.execSQL("INSERT INTO table01 (name,price) values ('資管系必修','網際網路程式設計')");//新增資料
            db.execSQL("INSERT INTO table01 (name,price) values ('資管系選修','行動裝置程式設計')");
            db.execSQL("INSERT INTO table01 (name,price) values ('人文領域','易經')");
            db.execSQL("INSERT INTO table01 (name,price) values ('生命領域','生命倫理')");
            db.execSQL("INSERT INTO table01 (name,price) values ('社會領域','法學緒論')");
            db.execSQL("INSERT INTO table01 (name,price) values ('自然領域','數學漫談')");
            db.execSQL("INSERT INTO table01 (name,price) values ('微型課程','古蹟文化與在地生活')");
        }
        catch (Exception e){
            cursor=getAll();//查詢所有資料
            UpdateAdapter(cursor);//載入資料表至ListView中
        }
        /*if(sel == "資管系必修"){
            long n1=1;
            cursor=get(n1);
            UpdateAdapter(cursor);
        }
        else if(sel=="資管系選修"){
            long n2=2;
            cursor=get(n2);
            UpdateAdapter(cursor);
        }
        else if(sel=="人文領域"){
            long n3=3;
            cursor=get(n3);
            UpdateAdapter(cursor);
        }
        else if(sel=="生命領域"){
            long n4=4;
            cursor=get(n4);
            UpdateAdapter(cursor);
        }
        else if(sel=="社會領域"){
            long n5=5;
            cursor=get(n5);
            UpdateAdapter(cursor);
        }
        else if(sel=="自然領域"){
            long n6=6;
            cursor=get(n6);
            UpdateAdapter(cursor);
        }
        else if(sel=="微型課程"){
            long n7=7;
            cursor=get(n7);
            UpdateAdapter(cursor);
        }*/

    }
    private ListView.OnItemClickListener listview01Listener=new ListView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            cursor.moveToPosition(position);
            Cursor c=get(id);
            String s="id="+id+"\r\n"+"name="+c.getString(1)+"\r\n"+"price="+c.getString(2);
            Toast.makeText(getApplicationContext(),"已成功選取該課程",Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();//關閉資料庫
    }

    private Button.OnClickListener myListener=new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            try{
                switch (v.getId()){
                    case R.id.btnSearch: { //查詢單筆資料
                        long id = Integer.parseInt(edtID.getText().toString());
                        cursor = get(id);
                        UpdateAdapter(cursor);//載入資料表至ListView中
                        break;
                    }
                    case R.id.btnSearchAll:{//查詢全部
                        cursor=getAll();//查詢所有資料
                        UpdateAdapter(cursor);//載入資料表至ListView中
                        break;
                    }
                }
            }
            catch (Exception err){
                Toast.makeText(getApplicationContext(),"查無此資料",Toast.LENGTH_SHORT).show();
            }
        }
    };

    public void UpdateAdapter(Cursor cursor){
        if(cursor!=null && cursor.getCount()>=0){
            SimpleCursorAdapter adapter=new SimpleCursorAdapter(
                    this,
                    R.layout.mylayout,//自訂的mylayout.xml
                    cursor,//資料庫的Cursor物件
                    new String[]{"_id","name","price"},//_id,name,price欄位
                    new int[]{R.id.txtId,R.id.txtName,R.id.txtPrice},//與_id,name,price對應的元件
                    0
            );
            listview01.setAdapter(adapter);//將adapter增加到listview01中
        }
    }

    public Cursor getAll(){//查詢所有資料
        Cursor cursor=db.rawQuery("SELECT _id,name,price FROM table01",null);
        return cursor;//傳回 id、pname、price欄位
    }

    public Cursor get(long rowId) throws SQLException {//查詢指定ID資料
        Cursor cursor=db.rawQuery("SELECT _id,name,price FROM table01 WHERE _id="+rowId,null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
        }
        else{
            Toast.makeText(getApplicationContext(),"查無此筆資料",Toast.LENGTH_SHORT).show();
        }
        return cursor;//傳回 id、pname、price欄位
    }

}