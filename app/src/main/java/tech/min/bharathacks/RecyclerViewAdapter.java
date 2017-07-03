package tech.min.bharathacks;

/**
 * Created by rishabh on 17/6/17.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {


    private List<StuffInCard> task;
    protected Context context;
    public RecyclerViewAdapter(Context context, List<StuffInCard> task) {
        this.task = task;
        this.context = context;
    }

    public RecyclerViewAdapter() {
    }


    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolders viewHolder = null;

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.newcardd, parent, false);
        viewHolder = new RecyclerViewHolders(layoutView);


        return viewHolder;
    }

//HERE TO CHANGE

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder,  int position) {
        holder.name.setText(task.get(position).getNameofuser());
        holder.loanAmount.setText(task.get(position).getLoanAmount());
        final  int something=position;
        holder.loanType.setText(task.get(position).getLoanType());
        holder.desc.setText(task.get(position).getDescription());

        final String loanTypeString = task.get(position).getLoanType();
        final String name = task.get(position).getNameofuser();

        final String loadnAmountString = task.get(position).getLoanAmount();

        final String description = task.get(position).getDescription();

        holder.Fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(context, Cards.class);
                context.startActivity(i1);

            }
        });

    }
    @Override
    public int getItemCount() {
        return this.task.size();
    }


}