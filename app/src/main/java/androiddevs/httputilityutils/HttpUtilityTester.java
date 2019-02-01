package androiddevs.httputilityutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import androiddevs.httlurlconutils.R;

public class HttpUtilityTester extends AppCompatActivity {

    private static final String TAG = HttpUtilityTester.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
//                post();
                get();
            }
        }).start();
    }

    public void get(){
        // test sending GET request
        String requestURL = "http://petstore-demo-endpoint.execute-api.com/petstore/pets?type=pets&page=1";
        try {
            HttpUtility.sendGetRequest(requestURL);
            String[] response = HttpUtility.readMultipleLinesRespone();
            StringBuilder builder = new StringBuilder();
            for(String s : response) {
                builder.append(s);
            }
            String mResponse = builder.toString();
            Log.e(TAG, "get: >>"+mResponse);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        HttpUtility.disconnect();
    }

    public void post(){
        // test sending POST request
        Map<String, String> params = new HashMap<String, String>();
/*        String requestURL = "http://petstore-demo-endpoint.execute-api.com/petstore/pets?type=pets&page=1";
        params.put("Email", "your_email");
        params.put("Passwd", "your_password");*/
        String requestURL = "https://www.meetntrain.com/webservices/checkuseremailreg";
        params.put("api", "840928409233204890239");
        params.put("email", "test@gmail.com");
        try {
            HttpUtility.sendPostRequest(requestURL, params);
            String[] response = HttpUtility.readMultipleLinesRespone();
            StringBuilder builder = new StringBuilder();
            for(String s : response) {
                builder.append(s);
            }
            String mResponse = builder.toString();
            Log.e(TAG, "post: >>"+mResponse);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        HttpUtility.disconnect();
    }
}
