package com.example.hutesh.sunshine.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    String username;
    RadioGroup radioGroup;
    Button btn;
    Button btn2;
    Button submit;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    float totalcost=0;
    private static final int CAMERA_REQUEST=123;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.idbtn);
        btn2=(Button)findViewById(R.id.sendbutton);
        submit=(Button)findViewById(R.id.finalsubmit);
        imageView=(ImageView)findViewById(R.id.imageView);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup radioGroup,int i)
            {
                switch (i)
                {
                    case R.id.radioButton1:
                        displaymessage1("Pay By BHEEM App");
                        break;
                    case R.id.radioButton2:
                        displaymessage1("Money pay to Delivey Man");
                        break;
                }
            }
        });
        editText1 =(EditText)findViewById(R.id.idname);
        editText2 =(EditText)findViewById(R.id.idnum);
        editText3 =(EditText)findViewById(R.id.idaddr);
        Intent toy1=getIntent();
        username=toy1.getStringExtra("username");



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                final RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                final String url = "https://hk-coffes.000webhostapp.com/hutesh.php";
                final StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("Response", response.toString());
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
                        params.put("totalcost",totalcost+"");
                        return params;
                    }
                };
                queue.add(postRequest);
            }
        });

    }

    public void displaymessage1(String message)
    {
        TextView priceTextView=(TextView) findViewById(R.id.message);
        priceTextView.setText(message);
    }
    //edit text statement............
    public String coustmer() {
        String str1 = editText1.getText().toString();
        return str1;
    }
    public String mobile() {
        String str2 = editText2.getText().toString();
        return str2;
    }
    public String Address() {
        String str3 = editText3.getText().toString();
        return str3;
    }
    //end edit text...............
    //start camera..............
    public void btnClick(View v)
    {
        Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAMERA_REQUEST);
    }
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo=(Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }
    //end camera.................
    int numberOfCoffees=0;
    int numberOfIcecream=0;
    int numberOfColddrink=0;
    int numberOfSnacksplate=0;
    public void increment1(View view)
    {final ImageView imageView2 = (ImageView)findViewById(R.id.cofeecup);
        imageView2.setImageResource(R.drawable.hutesh2);
        numberOfCoffees+=1;
        display1(numberOfCoffees);
    }
    public void decrement1(View view)
    {
        numberOfCoffees-=1;
        display1(numberOfCoffees);
    }
    public void paymentfun(View v)
    {
        Button btn=(Button)findViewById(R.id.bheembutton);
        String s="Using Bheem App PAY Me\n"+"ON NO. 9782988487\n"+"After that We will Deliver";
        displaypayment(s);
    }
    private void displaypayment(String number)
    {
        TextView quantityTextView=(TextView) findViewById(R.id.bheembutton);
        quantityTextView.setText("" + number);
    }
    private void display1(int number)
    {
        TextView quantityTextView=(TextView) findViewById(R.id.text1);
        quantityTextView.setText("" + number);
    }
    public void increment2(View view)
    {
        numberOfIcecream+=1;
        display2(numberOfIcecream);
    }
    public void decrement2(View view)
    {
        numberOfIcecream-=1;
        display2(numberOfIcecream);
    }
    private void display2(int number)
    {
        TextView quantityTextView=(TextView) findViewById(R.id.text12);
        quantityTextView.setText("" + number);
    }
    public void increment3(View view)
    {
        numberOfColddrink+=1;
        display3(numberOfColddrink);
    }
    public void decrement3(View view)
    {
        numberOfColddrink-=1;
        display3(numberOfColddrink);
    }
    private void display3(int number)
    {
        TextView quantityTextView=(TextView) findViewById(R.id.text14);
        quantityTextView.setText("" + number);
    }
    public void increment4(View view)
    {
        numberOfSnacksplate+=1;
        display4(numberOfSnacksplate);
    }
    public void decrement4(View view)
    {
        numberOfSnacksplate-=1;
        display4(numberOfSnacksplate);
    }
    private void display4(int number)
    {
        TextView quantityTextView=(TextView) findViewById(R.id.text16);
        quantityTextView.setText("" + number);
    }
    private int  calculateprice(int number,int cost)
    {
        number=number*cost;
        return number;
    }
    public void submitOrder(View view)
    {    //ImageView imag=new ImageView(this);
        // ImageView imag=findViewById(R.id.cofeecup);
        //imag.setImageResource(R.drawable.hutesh2);
        final ImageView imageView1 = (ImageView)findViewById(R.id.cofeecup);
        imageView1.setImageResource(R.drawable.cofee12);
        totalcost=calculateprice(numberOfCoffees,10)+calculateprice(numberOfIcecream,25)+calculateprice(numberOfColddrink,15)+calculateprice(numberOfSnacksplate,40);
        try{
            String pricemessage="Item       "+"Quantity  "+"cost\n";
            if(numberOfCoffees>0)
            {pricemessage+="Coffee          "+numberOfCoffees+"           "+calculateprice(numberOfCoffees,10)+"\n";}
            if(numberOfIcecream>0)
            {pricemessage+="Icecream      "+numberOfIcecream+"          "+calculateprice(numberOfIcecream,25)+"\n";}
            if(numberOfColddrink>0)
            {pricemessage+="Colddrink      "+numberOfColddrink+"          "+calculateprice(numberOfColddrink,15)+"\n";}
            if(numberOfSnacksplate>0)
            {pricemessage+="Snacks          "+numberOfSnacksplate+"          "+calculateprice(numberOfSnacksplate,40)+"\n";}
            pricemessage+="--------------------------------------------\n";
            pricemessage+="Total Cost                "+totalcost+"\n";
            pricemessage+="--------------------------------------------\n";
            pricemessage+="Thank You!      "+coustmer();
            displaymessage(pricemessage);
        }
        catch (Exception e){
            displaymessage("Error occured");
        }
    }

    private void displaymessage(String message)
    {
        TextView priceTextView=(TextView) findViewById(R.id.text3);
        priceTextView.setText(message);
        //priceTextView.setTextSize(15);
        // priceTextView.setTextColor(Color.MAGENTA);
    }

    public void gmailclick(View v) {
        String complete= "Coustmer Order \n" + "Name: " + coustmer() + "\n" + "Contact: ";
        complete += mobile() + "\n" + "Address: " + Address() + "\n";
        complete+="Item       "+"Quantity  "+"cost\n";
        if(numberOfCoffees>0)
        {complete+="Coffee          "+numberOfCoffees+"           "+calculateprice(numberOfCoffees,10)+"\n";}
        if(numberOfIcecream>0)
        {complete+="Icecream      "+numberOfIcecream+"          "+calculateprice(numberOfIcecream,25)+"\n";}
        if(numberOfColddrink>0)
        {complete+="Colddrink      "+numberOfColddrink+"          "+calculateprice(numberOfColddrink,15)+"\n";}
        if(numberOfSnacksplate>0)
        {complete+="Snacks          "+numberOfSnacksplate+"          "+calculateprice(numberOfSnacksplate,40)+"\n";}
        complete+="--------------------------------------------------------\n";
        complete += "Price->" + totalcost+"\n";
        complete+="--------------------------------------------------------\n";
        Button btn = (Button) findViewById(R.id.finalsubmit);
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("email"));
        String[] s = {"huteshgauttam@gmail.com"};
        i.putExtra(Intent.EXTRA_EMAIL, s);
        i.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order "+coustmer());
        i.putExtra(Intent.EXTRA_TEXT, complete);
        i.setType("message/rfc822");
        Intent chooser = Intent.createChooser(i, "Launch Email");
        startActivity(chooser);
    }
    public void buttonClick(View v)
    {
        String complete1= "Coustmer Order \n" + "Name: " + coustmer() + "\n" + "Contact: ";
        complete1 += mobile() + "\n" + "Address: " + Address() + "\n";
        complete1+="Item       "+"Quantity  "+"cost\n";
        if(numberOfCoffees>0)
        {complete1+="Coffee          "+numberOfCoffees+"           "+calculateprice(numberOfCoffees,10)+"\n";}
        if(numberOfIcecream>0)
        {complete1+="Icecream      "+numberOfIcecream+"          "+calculateprice(numberOfIcecream,25)+"\n";}
        if(numberOfColddrink>0)
        {complete1+="Colddrink      "+numberOfColddrink+"          "+calculateprice(numberOfColddrink,15)+"\n";}
        if(numberOfSnacksplate>0)
        {complete1+="Snacks          "+numberOfSnacksplate+"          "+calculateprice(numberOfSnacksplate,40)+"\n";}
        complete1+="-----------------------------------------------\n";
        complete1 += "Price->" + totalcost+"\n";
        complete1+="-----------------------------------------------\n";
        Intent sharingIntent =new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, complete1);
        sharingIntent.setPackage("com.whatsapp");
        startActivity(sharingIntent);
    }
}
