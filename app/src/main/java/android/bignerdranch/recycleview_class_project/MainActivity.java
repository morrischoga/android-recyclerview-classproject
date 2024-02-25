package android.bignerdranch.recycleview_class_project;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MyOnclick {

    ArrayList<String> array = new ArrayList<>();
    RecyclerView recycleview;
    Adapter adapter;
    SwipeRefreshLayout refreshlayout;


    TextView textview;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int x = 1; x<=100;x++){array.add("Tab "+x);}

        recycleview = findViewById(R.id.recycleview);
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(array,this,this);
        textview = findViewById(R.id.textView);
        recycleview.setAdapter(adapter);

        refreshlayout = findViewById(R.id.refreshlayout);


        refreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d("refresh","refreshed");
                refreshlayout.setRefreshing(false);
            }
        });



    }

    @Override
    public void MyOnclick(int position) {
        Toast.makeText(getApplicationContext(),"Tab "+position,Toast.LENGTH_SHORT).show();
    }
}