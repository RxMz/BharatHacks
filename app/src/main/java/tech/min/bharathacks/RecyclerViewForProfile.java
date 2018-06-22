package tech.min.bharathacks;

/**
 * Created by rishabh on 17/6/17.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewForProfile extends RecyclerView.Adapter<RecyclerViewForProfile.RecyclerViewHolder> {


    private List<StuffInCardTwo> task;
    protected Context context;

    public RecyclerViewForProfile(Context context, List<StuffInCardTwo> task) {
        this.task = task;
        this.context = context;
    }

    public RecyclerViewForProfile() {
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder = null;
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_list_of_lenders, parent, false);
        viewHolder = new RecyclerViewHolder(layoutView);
        return viewHolder;
    }

//HERE TO CHANGE

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        if(task.get(position).getName()!=null) {
            holder.name.setText(task.get(position).getName());
            holder.amount.setText(task.get(position).getAmount());
            holder.interest.setText(task.get(position).getInterest());
        }

    }

    @Override
    public int getItemCount() {
        return this.task.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView name, amount, interest;

        public RecyclerViewHolder(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvNameOfLender);
            amount = (TextView) itemView.findViewById(R.id.tvLoanAmount);
            interest = (TextView) itemView.findViewById(R.id.tvInterest);

        }
    }

}