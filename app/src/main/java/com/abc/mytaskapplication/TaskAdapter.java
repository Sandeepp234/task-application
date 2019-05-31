//package com.abc.mytaskapplication;
//
//import android.content.Context;
//import android.support.v7.app.AlertDialog;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.abc.mytaskapplication.callback.OnTaskUpdateListener;
//
//import java.util.List;
//
//public class TaskAdapter extends BaseAdapter {
//
//    List<TaskData> list;
//    Context context;
//    OnTaskUpdateListener onTaskUpdateListener;
//
//    public TaskAdapter(List<TaskData> list, Context context) {
//        this.list = list;
//        this.context = context;
//    }
//
//    public void setOnTaskUpdateListener(OnTaskUpdateListener onTaskUpdateListener) {
//           this.onTaskUpdateListener = onTaskUpdateListener;
//    }
//
//    public void addTask(TaskData n){
//        list.add(n);
//        notifyDataSetChanged();
//    }
////
////    public  void removeTask(TaskData n){
////        list.remove(position);
////        notifyDataSetChanged();
////    }
//
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return list.get(position);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(final int i, View convertView, ViewGroup viewGroup) {
//
//        convertView = LayoutInflater.from(context).inflate(R.layout.rows_task, viewGroup, false);
//     final    TaskData n = (TaskData) getItem(i);
//        TextView tvTitle = convertView.findViewById(R.id.tv_title);
//        TextView tvDescription = convertView.findViewById(R.id.tv_description);
//        tvTitle.setText(n.getTitle());
//        tvDescription.setText(n.getDescription());
//
//        Button btnUpdate = convertView.findViewById(R.id.btn_update);
//        Button btnDelete = convertView.findViewById(R.id.btn_delete);
//
//
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              //  AlertDialog.Builder dialog = new AlertDialog.Builder(TaskAdapter.this);
//
//                //((TaskData) getItem(i)).setTitle("testtt");
//               // notifyDataSetChanged();
//      if (onTaskUpdateListener!=null){
//          onTaskUpdateListener.onUpdate(i);
//      }
//
//            }
//
//
//        });
//
//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                list.remove(n);
//                notifyDataSetChanged();
//            }
//        });
//        return convertView;
//
//
//
//
//    }
//}
