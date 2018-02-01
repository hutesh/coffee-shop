package com.example.hutesh.sunshine.app;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;
public class LoginRequest extends StringRequest {

    private static final String LOGIN_REQUEST_URL="https://hk-coffes.000webhostapp.com/login.php";
    private Map<String,String> params;
    public LoginRequest(String username,String password,Response.Listener<String>Listner){
        super(Request.Method.POST,LOGIN_REQUEST_URL,Listner,null);
        params=new HashMap<>();
        params.put("username",username);
        params.put("password",password);
    }
    @Override
    public Map<String,String>getParams(){
        return params;
    }
}
