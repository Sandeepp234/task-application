package com.abc.mytaskapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.abc.mytaskapplication.R;
import com.abc.mytaskapplication.TaskData;
import com.abc.mytaskapplication.callback.OnTaskUpdateListener;

import java.util.List;

public class AdapterTask extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

     private Context context;
   private  List<TaskData> list;
    private OnTaskUpdateListener onTaskUpdateListener;

    public AdapterTask(Context context, List<TaskData> list) {
        this.context = context;
        this.list = list;
    }
    public void setOnTaskUpdateListener(OnTaskUpdateListener onTaskUpdateListener) {
        this.onTaskUpdateListener = onTaskUpdateListener;
    }

    public void addTask(TaskData n){
        list.add(n);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.rows_task2,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if(holder instanceof  ViewHolder ){
            ViewHolder h = (ViewHolder) holder;
            h.tvtitel.setText(list.get(position).getTitle());
            h.tvdescription.setText(list.get(position).getDescription());
            h.btndelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (onTaskUpdateListener!=null){
                        onTaskUpdateListener.onUpdate(position);
                    }

                }
            });

            h.btndelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    notifyDataSetChanged();
                }
            });




        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvtitel;
        TextView tvdescription;
        Button btnupdate;
        Button btndelete;

        public ViewHolder(View itemView) {
            super(itemView);

            tvtitel = itemView.findViewById(R.id.tv_title);
            tvdescription =itemView.findViewById(R.id.tv_description);
            btnupdate = itemView.findViewById(R.id.btn_update);
            btndelete= itemView.findViewById(R.id.btn_delete);

        }
    }

}
