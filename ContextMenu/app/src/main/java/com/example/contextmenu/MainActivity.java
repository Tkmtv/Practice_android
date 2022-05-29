package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_ADD = 1;
    public static final int RESULT_CODE_ADD_FAIL = 10;
    public static final int RESULT_CODE_ADD_SUCCESS = 11;
    public static final int REQUEST_CODE_EDIT = 2;
    public static final int RESULT_CODE_EDIT_FAIL = 20;
    public static final int RESULT_CODE_EDIT_SUCCESS = 21;
    private Toast toast;
    private ListView listView;
    private ArrayList<String> subjects;
    private ArrayAdapter<String> adapter = null;
    private int id_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
    }

    private void mapping() {
        listView = findViewById(R.id.lv);
        subjects = new ArrayList<>();
        subjects.add("Lập trình mobile");
        subjects.add("Cấu trúc dữ liệu và giải thuật");
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, subjects);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            id_edit = position;
            return false;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (toast != null) {
            toast.cancel();
        }
        if (id == R.id.mnAdd) {
//            toast = Toast.makeText(getApplicationContext(), "Add Clicked", Toast.LENGTH_SHORT);
            Intent intent = new Intent(MainActivity.this, AddSubjectActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("cmd", REQUEST_CODE_ADD);
            intent.putExtra("MyPacket", bundle);
            startActivityForResult(intent, REQUEST_CODE_ADD);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
        }
        if (id == R.id.mnExit) {
            finish();
        }
//        toast.show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.my_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mnEdit) {
            Intent intent = new Intent(MainActivity.this, AddSubjectActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("cmd", REQUEST_CODE_EDIT);
            bundle.putString("name", subjects.get(id_edit));
            intent.putExtra("MyPacket", bundle);
            startActivityForResult(intent, REQUEST_CODE_EDIT);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
        }
        if (id == R.id.mnDel) {
            subjects.remove(id_edit);
            adapter.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_CODE_ADD_FAIL:
                toast = Toast.makeText(getApplicationContext(), "Add failed", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case RESULT_CODE_ADD_SUCCESS:
                String newSubject = data.getStringExtra("data");
                subjects.add(newSubject);
                adapter.notifyDataSetChanged();
                break;
            case RESULT_CODE_EDIT_FAIL:
                toast = Toast.makeText(getApplicationContext(), "Edit failed", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case RESULT_CODE_EDIT_SUCCESS:
                String editSubject = data.getStringExtra("data");
                subjects.remove(id_edit);
                subjects.add(id_edit, editSubject);
                adapter.notifyDataSetChanged();
                break;
            default:
                toast = Toast.makeText(getApplicationContext(), "Unkown error", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }
}