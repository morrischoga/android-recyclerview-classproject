package android.bignerdranch.recycleview_class_project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    private static final String TAG = "Adapter";
    ArrayList<String> tabs;
    Context mContexts;
    MyOnclick myOnclick;


    public Adapter(ArrayList<String> tab, Context context,MyOnclick myOnclick) {
        tabs = tab;
        mContexts = context;
        this.myOnclick = myOnclick;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        LayoutInflater mLayoutInflater = LayoutInflater.from(mContexts);

        View view = mLayoutInflater.inflate(R.layout.design_file,parent,false);


        return new MyViewHolder(view,myOnclick);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTextViews.setText(tabs.get(position));



    }

    @Override
    public int getItemCount() {
        return tabs.size();

    }



    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        View root;
        TextView mTextViews;
        CardView cardview;
        LottieAnimationView animation;
        MyOnclick myOnclick;


        public MyViewHolder(@NonNull View itemView,MyOnclick myOnclick) {
            super(itemView);
            mTextViews = itemView.findViewById(R.id.textView);
            cardview = itemView.findViewById(R.id.cardview);

            this.myOnclick = myOnclick;
            mTextViews.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: called");
            myOnclick.MyOnclick(getAdapterPosition()+1);
        }
    }
}
