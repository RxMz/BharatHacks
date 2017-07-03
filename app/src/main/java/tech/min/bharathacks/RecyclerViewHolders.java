package tech.min.bharathacks;

/**
 * Created by rishabh on 17/6/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
public class RecyclerViewHolders extends RecyclerView.ViewHolder{
    private static final String TAG = RecyclerViewHolders.class.getSimpleName();
    TextView name,loanAmount,loanType,desc;
    Button Fund;
    public RecyclerViewHolders(final View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.tvnamenew);
        loanAmount = (TextView)itemView.findViewById(R.id.tvLoadAmountnew);
        loanType = (TextView)itemView.findViewById(R.id.tvloanTypenew);
        desc = (TextView)itemView.findViewById(R.id.Descnew);
        Fund = (Button)itemView.findViewById(R.id.btnFund);
    }
}