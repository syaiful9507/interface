package angga.code;

/**
 * Created by AKNS08 on 7/21/2017.
 */



        import android.content.Context;
        import android.content.Intent;
        import android.support.design.widget.CollapsingToolbarLayout;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
        import android.view.MenuItem;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;
        import com.bumptech.glide.Glide;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

public class CourseDetail extends AppCompatActivity {
    TextView txtid, txtTitle, txtContent;
    ImageView viewimage;
    Context context;
    public String id_,textimage;
    private Toolbar toolbar;
    int backgroundImage = R.mipmap.ic_launcher;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        //ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        //imageView.setImageResource(backgroundImage);

        txtTitle    = (TextView) findViewById(R.id.title);
        txtid       = (TextView) findViewById(R.id.id);
        txtContent  = (TextView) findViewById(R.id.txtContent);
        viewimage   = (ImageView) findViewById(R.id.backdrop);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.maincollapsing);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Intent intent = getIntent();
        txtid.setText(intent.getStringExtra(Config.TAG_ID_CATEGORY));
        id_ = txtid.getText().toString();

        setSupportActionBar(toolbar);
        GETDATA();

        //action bar back press
        ActionBar actionBar = getSupportActionBar();
        if (actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }

    private void GETDATA(){
        String url = Config.URL_LISTCONTEN+ txtid.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CourseDetail.this, error.getMessage().toString(), Toast.LENGTH_SHORT ).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response){
        String title ="", content = "", image="";
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray("content");
            JSONObject collegeData = result.getJSONObject(0);
            title = collegeData.getString(Config.TAG_TITLE);
            content = collegeData.getString(Config.TAG_CONTENT);
            image   = collegeData.getString(Config.TAG_IMAGE);

        } catch (JSONException e){
            e.printStackTrace();
        }
        txtContent.setText(content);
        txtTitle.setText(title);
        collapsingToolbarLayout.setTitle(title);

        Glide.with(getApplicationContext())
                .load(Config.IMAGE + image)
                .placeholder(R.mipmap.ic_launcher)
                .into(viewimage);

    }


    //back press methode
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == android.R.id.home){
            navigateUpTo(new Intent(this, MainActivity.class));
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }

}
