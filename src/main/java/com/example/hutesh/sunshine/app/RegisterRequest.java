package com.example.hutesh.sunshine.app;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL="https://hk-coffes.000webhostapp.com/regestration.php";
    private Map<String,String> params;
    public RegisterRequest(String username,String password ,String email,Response.Listener<String>Listner){
        super(Method.POST,REGISTER_REQUEST_URL,Listner,null);
        params=new HashMap<>();
        params.put("username",username);
        params.put("password",password);
        params.put("email",email);
    }
    @Override
    public Map<String,String>getParams(){
        return params;
    }
}
