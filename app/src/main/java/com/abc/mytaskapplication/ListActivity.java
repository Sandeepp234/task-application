package com.abc.mytaskapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.abc.mytaskapplication.Adapter.AdapterTask;
import com.abc.mytaskapplication.TaskData;
//import com.abc.mytaskapplication.TaskAdapter;
import com.abc.mytaskapplication.callback.OnTaskUpdateListener;

public class ListActivity extends AppCompatActivity implements TextWatcher {
    EditText edtSearch;
    Button btnaddtask;
    ListView lvtasklist;
   RecyclerView recyclerView;

    final List<TaskData> list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        edtSearch = findViewById(R.id.edt_search);
        btnaddtask = findViewById(R.id.btn_addtask);
       //lvtasklist = findViewById(R.id.lv_list);

        recyclerView = findViewById(R.id.rv_taskdata);
      LinearLayoutManager  layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
      recyclerView.setLayoutManager(layoutManager);
      recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //  btnUpdate = findViewById(R.id.btn_update);

        // btnDelete = findViewById(R.id.btn_delete);

//        edtSearch.addTextChangedListener(this);

        edtSearch.addTextChangedListener( this);


        final TaskData n = new TaskData("1", "Task 1", "abcdddfdfd");
        list.add(n);
        list.add(new TaskData("2", "Task 2", "abcdsdsdsddddfdfd"));
       // final TaskAdapter adapter = new TaskAdapter(list, this);
      final  AdapterTask adapterTask = new AdapterTask(this,list);

      recyclerView.setAdapter(adapterTask);
       // lvtasklist.setAdapter(adapterTask);

        adapterTask.setOnTaskUpdateListener(new OnTaskUpdateListener() {
            @Override
            public void onUpdate(final int position) {
                final View view = getLayoutInflater().inflate(R.layout.add_task, null);
                AlertDialog.Builder dialog = new AlertDialog.Builder(ListActivity.this)
                        .setTitle("Update Item")
                        .setView(view);
                final EditText name = view.findViewById(R.id.edt_taskname);
                final EditText description = view.findViewById(R.id.edt_taskdescription);
                name.setText(list.get(position).getTitle());
                description.setText(list.get(position).getDescription());
                dialog.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        TaskData n = list.get(position);
                        n.setTitle(name.getText().toString());
                        n.setDescription(description.getText().toString());
                        list.remove(position);
                        list.add(n);
                        adapterTask.notifyDataSetChanged();

                    }
                })
                        .setNegativeButton("Cancel", null);
                dialog.show();
            }
        });


        btnaddtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAlert();

            }
        });

        // adapter.addNews(new News("","new news", "" );

    }

    private void showAlert() {

        final View view = getLayoutInflater().inflate(R.layout.add_task, null);

        AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                .setTitle("Fill the Form")
                .setView(view)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText name = view.findViewById(R.id.edt_taskname);
                        EditText description = view.findViewById(R.id.edt_taskdescription);
                        String string = name.getText().toString();
                        String string1 = description.getText().toString();
                        Integer integer = list.size();
                        String string2 = Integer.toString(integer);
                        TaskData taskData = new TaskData(string2, string, string1);
                        list.add(taskData);

                    }
                })
                .setNegativeButton("Cancel", null);

        dialog.show();


    }






    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
       // lvtasklist.setAdapter(ListActivity.this, filterlist(s.toString()));
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public List<TaskData> filterlist(String s) {
        List<TaskData> filteredlist = new ArrayList<>();
        for (TaskData taskData : list) {

            String title = taskData.getTitle();
            String description = taskData.getDescription();
            if (title.contains(s) || description.contains(s)) {
                filteredlist.add(taskData);
            }


        }return  filteredlist;
    }

    /*dfd*/
}



