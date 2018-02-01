package com.example.hutesh.sunshine.app;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    EditText editText3;
    String username;
    String password;
    String email;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        editText1=(EditText)findViewById(R.id.reguser);
        editText2=(EditText)findViewById(R.id.regpass);
        editText3=(EditText)findViewById(R.id.regemail);
        btn=(Button)findViewById(R.id.regregbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = editText1.getText().toString();
                password = editText2.getText().toString();
                email = editText3.getText().toString();

               /* Response.Listener<String>responseListner=new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(MainActivity3.this, Main2Activity.class);
                                MainActivity3.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                                builder.setMessage("Registration Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest =new RegisterRequest(username,password,email,responseListner);
                RequestQueue queue = Volley.newRequestQueue(MainActivity3.this);
                queue.add(registerRequest);
            }
        });
    }*/
                final RequestQueue queue = Volley.newRequestQueue(MainActivity3.this);
                final String url = "https://hk-coffes.000webhostapp.com/regestration.php";
                final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("Response", response.toString());
                                if (response.toString().equals("1"))
                                {
                                    Intent toy = new Intent(MainActivity3.this, Main2Activity.class);
                                    startActivity(toy);
                                }
                                else
                                {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity3.this);
                                    builder.setMessage("Registration Failed")
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
                        params.put("email", email);
                        return params;
                    }
                };
                queue.add(postRequest);
            }
        });
    }

}