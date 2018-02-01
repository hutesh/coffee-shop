package com.example.hutesh.sunshine.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    Button btn1;
    Button btn2;
    int no = 345;

    //String money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btn1 = (Button) findViewById(R.id.totalorder);
        btn2 = (Button) findViewById(R.id.totalcost);
    }
    public void bossorder(View view) {
        no = 13;
        display4(no);
    }

    public void bosscost(View view) {
        no = 1796;
        display5(no);
    }

    public void display4(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.no_of_order);
        quantityTextView.setText("" + number);
    }

    public void display5(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.cost);
        quantityTextView.setText("" + number);
    }
}

       /* btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                final RequestQueue queue = Volley.newRequestQueue(MainActivity4.this);
                final String url = "https://hk-coffes.000webhostapp.com/secrete.php";
                final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("Response", response.toString());
                                money=response.toString();
                                display4(money);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("Error.Response", error.toString());
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        return params;
                    }
                };
                queue.add(postRequest);
            }
        });*/
