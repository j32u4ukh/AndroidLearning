package com.example.j32u4ukh.androidlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CRUD extends AppCompatActivity {
    EditText editCreate, editUpdateMember, editUpdateCard, editUpdateNumber, editDelete;
    Button buttonCreate, buttonRead, buttonUpdate, buttonDelete, toShow;
    TextView textRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        toShow = (Button)findViewById(R.id.toShow);
        editCreate = (EditText) findViewById(R.id.editCreate);
        editUpdateMember = (EditText) findViewById(R.id.editUpdateMember);
        editUpdateCard = (EditText) findViewById(R.id.editUpdateCard);
        editUpdateNumber = (EditText) findViewById(R.id.editUpdateNumber);
        editDelete = (EditText) findViewById(R.id.editDelete);
        buttonCreate = (Button)findViewById(R.id.buttonCreate);
        buttonRead = (Button)findViewById(R.id.buttonRead);
        buttonUpdate = (Button)findViewById(R.id.buttonUpdate);
        buttonDelete = (Button)findViewById(R.id.buttonDelete);
        textRead = (TextView)findViewById(R.id.textRead);
    }

    @Override
    protected void onResume() {
        super.onResume();
        toShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CRUD.this, Show.class);
                startActivity(intent);
            }
        });

        // Create
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String member = editCreate.getText().toString().trim();
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(CRUD.this, "Create Success.", Toast.LENGTH_SHORT).show();
                    }
                };

                CreateRequest createRequest = new CreateRequest(member, responseListener);
                RequestQueue queue = Volley.newRequestQueue(CRUD.this);
                queue.add(createRequest);
            }
        });

        // Read
        // TODO：更新功能，需再測試
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String member = editCreate.getText().toString().trim();
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            int _001 = jsonObject.getInt("001");
                            int _002 = jsonObject.getInt("002");
                            int _003 = jsonObject.getInt("003");
                            int _004 = jsonObject.getInt("004");
                            int _005 = jsonObject.getInt("005");
                            int _006 = jsonObject.getInt("006");
                            int _007 = jsonObject.getInt("007");
                            int _008 = jsonObject.getInt("008");
                            int _009 = jsonObject.getInt("009");
                            int _1001 = jsonObject.getInt("1001");
                            int _1002 = jsonObject.getInt("1002");
                            String result = String.format(Locale.getDefault(), " 001>%d, 002>%d, 003>%d, 004>%d, 005>%d, 006>%d, 007>%d, 008>%d, 009>%d, 1001>%d, 102>%d\n",
                                    _001, _002, _003, _004, _005, _006, _007, _008, _009, _1001, _1002);
                            textRead.setText(result);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };

                ReadRequest readRequest = new ReadRequest(member, responseListener);
                RequestQueue queue = Volley.newRequestQueue(CRUD.this);
                queue.add(readRequest);
            }
        });

        // Update
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String updateMember = editUpdateMember.getText().toString().trim();
                String updateCard = editUpdateCard.getText().toString().trim();
                int upateNumber = Integer.parseInt(editUpdateNumber.getText().toString().trim());
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(CRUD.this, "Update Success.", Toast.LENGTH_SHORT).show();
                    }
                };

                UpdateRequest updateRequest = new UpdateRequest(updateMember, updateCard, upateNumber, responseListener);
                RequestQueue queue = Volley.newRequestQueue(CRUD.this);
                queue.add(updateRequest);
            }
        });

        // Delete
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String member = editDelete.getText().toString().trim();
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(CRUD.this, "Delete Success.", Toast.LENGTH_SHORT).show();
                    }
                };

                DeleteRequest deleteRequest = new DeleteRequest(member, responseListener);
                RequestQueue queue = Volley.newRequestQueue(CRUD.this);
                queue.add(deleteRequest);
            }
        });
    }
}

// TODO：Create、Read、Delete三者皆只需member這一參數，或許可併一起，根據不同功能改變URL
class CreateRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://carboxyl-hatchet.000webhostapp.com/test/createTEST.php";
    private Map<String, String> params;

    public CreateRequest(String member, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("member", member);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

// TODO：更新功能，需再測試
class ReadRequest extends StringRequest {
    // TODO：尚無readTEST.php，條件加入where player = member
    private static final String REGISTER_REQUEST_URL = "https://carboxyl-hatchet.000webhostapp.com/test/readTEST.php";
    private Map<String, String> params;

    public ReadRequest(String member, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("member", member);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

class UpdateRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://carboxyl-hatchet.000webhostapp.com/test/updateTEST.php";
    private Map<String, String> params;

    public UpdateRequest(String member, String card, int number,Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("member", member);
        params.put("card", card);
        params.put("number", String.valueOf(number));
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

// TODO：這個功能可能用不到
class DeleteRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://carboxyl-hatchet.000webhostapp.com/test/deleteTEST.php";
    private Map<String, String> params;

    public DeleteRequest(String member, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("member", member);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

