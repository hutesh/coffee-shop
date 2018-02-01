package com.example.hutesh.sunshine.app;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
    public EditText editText11;
    public EditText editText22;
    String username;
    String password;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText11 = (EditText) findViewById(R.id.editID);
        editText22 = (EditText) findViewById(R.id.editPAS);
        btn = (Button) findViewById(R.id.Submit);


        TextView regestrationlink=(TextView)findViewById(R.id.registrationID);
        regestrationlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy1 = new Intent(Main2Activity.this, MainActivity3.class);
                startActivity(toy1);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                username = editText11.getText().toString();
                password = editText22.getText().toString();
               /* Response.Listener<String> responseListner = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent toy = new Intent(Main2Activity.this, MainActivity.class);
                                startActivity(toy);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(username, password, responseListner);
                RequestQueue queue = Volley.newRequestQueue(Main2Activity.this);
                queue.add(loginRequest);
            }
        });
    }*/
    final RequestQueue queue = Volley.newRequestQueue(Main2Activity.this);
    final String url = "https://hk-coffes.000webhostapp.com/login.php";
    final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("Response",response.toString());

                    if (response.toString().equals("1"))
                    {
                        if(username.equals("115cs0209")) {
                            Intent toy = new Intent(Main2Activity.this, MainActivity4.class);
                            startActivity(toy);
                        }
                        else
                        {
                            Intent toy1 = new Intent(Main2Activity.this, MainActivity.class);
                            toy1.putExtra("username",username);
                            startActivity(toy1);
                        }
                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                        builder.setMessage("Login Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }

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
            params.put("username", username);
            params.put("password", password);
            return params;
        }
    };
    queue.add(postRequest);
}
});
        }
}
