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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolders> {


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
    public void onBindViewHolder(RecyclerViewHolders holder, final int position) {
        holder.name.setText(task.get(position).getNameofuser());
        holder.loanAmount.setText(task.get(position).getLoanAmount());
        holder.loanType.setText(task.get(position).getLoanType());
        holder.desc.setText(task.get(position).getDescription());
        holder.loanID.setText(task.get(position).getLoanID());
        holder.Fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(context, Cards.class);
                i1.putExtra("loanid",task.get(position).getLoanID());
                context.startActivity(i1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.task.size();
    }

    public class RecyclerViewHolders extends RecyclerView.ViewHolder {
        TextView name, loanAmount, loanType, desc,loanID;
        Button Fund;

        public RecyclerViewHolders(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvnamenew);
            loanAmount = (TextView) itemView.findViewById(R.id.tvLoadAmountnew);
            loanType = (TextView) itemView.findViewById(R.id.tvloanTypenew);
            desc = (TextView) itemView.findViewById(R.id.Descnew);
            Fund = (Button) itemView.findViewById(R.id.btnFund);
            loanID = (TextView)itemView.findViewById(R.id.loanID);
        }
    }

}