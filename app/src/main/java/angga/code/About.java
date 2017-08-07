package angga.code;


        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        WebView view = (WebView)findViewById(R.id.webview1);

        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new MyBrowser() );
        view.loadUrl("file:///android_asset/www/about.html");
    }
    private class MyBrowser extends WebViewClient {

        public boolean shouldOverrideUrlLoading(WebView view, String url){
            return super.shouldOverrideUrlLoading(view,url);
        }
    }
    }