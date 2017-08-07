package angga.code;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements CustomItemClickListener {

    private RecyclerView recyclerview;
    ImageView arah, about;
    private com.android.volley.RequestQueue requestQueue;
    private StringRequest stringRequest;
    ArrayList<HashMap<String, String>> list_data;
    private Config config = new Config();
    public MainActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_course_fragments);

        arah = (ImageView) findViewById(R.id.arah);
        about = (ImageView) findViewById(R.id.about);

        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent arah = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(arah);
            }
        });


        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about = new Intent(MainActivity.this, About.class);
                startActivity(about);
            }
        });


        recyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //recyclerview.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        recyclerview.setLayoutManager(llm);
        getdata();
    }

    public void getdata(){

        requestQueue    = Volley.newRequestQueue(MainActivity.this);
        list_data   = new ArrayList<HashMap<String, String>>();
        stringRequest   = new StringRequest(Request.Method.GET, config.URL_LISTCOURSE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response: ", response);
                try {
                    //JSONObject jsonObject = new JSONObject(response);
                    //JSONArray jsonArray = jsonObject.getJSONArray(response);
                    JSONArray jsonArray = new JSONArray(response);
                    for (int a = 0; a < jsonArray.length(); a++) {
                        //JSONObject json = jsonArray.getJSONObject(a);
                        JSONObject json = jsonArray.getJSONObject(a);
                        String id_ct = json.getString(config.TAG_ID_CATEGORY);
                        String title = json.getString(config.TAG_TITLE);
                        String image      = json.getString(config.TAG_IMAGE);
                        final HashMap<String, String> map = new HashMap<String, String>();

                        map.put(config.TAG_ID_CATEGORY, id_ct);
                        map.put(config.TAG_TITLE, title);
                        map.put(config.TAG_IMAGE, image);

                        /*map.put("id", json.getString("id"));
                        map.put("subjects", json.getString("subjects"));
                        map.put("content", json.getString("content"));*/

                        list_data.add(map);
                        AdapterList adapter = new AdapterList(MainActivity.this, list_data);
                        recyclerview.setAdapter(adapter);
                        adapter.setClickListener(MainActivity.this);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        requestQueue.add(stringRequest);


    }

    @Override
    public void onItemClick(View view, int position) {
        HashMap<String , String > list = list_data.get(position);
        Intent in = new Intent(MainActivity.this, CourseDetail.class);
        in.putExtra(config.TAG_ID_CATEGORY, list.get(config.TAG_ID_CATEGORY));
        startActivity(in);

    }


}
