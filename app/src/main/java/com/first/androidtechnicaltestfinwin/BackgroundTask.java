package com.first.androidtechnicaltestfinwin;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BackgroundTask
{
    Context context;
    ArrayList<Details> arrayList = new ArrayList<>();
    String jsonUrl = "https://jsonplaceholder.typicode.com/photos";

    public BackgroundTask(Context context)
    {
        this.context = context;
    }

    public ArrayList<Details> getList() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, jsonUrl, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("RESPONSE....",response.toString());
                        int count = 0;
                        while (count< response.length())
                        {
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                Details details = new Details(jsonObject.getInt("id"),jsonObject.getString("title"),jsonObject.getString("url"),
                                        jsonObject.getString("thumbnailUrl"));
                                arrayList.add(details);
                                Log.d("VALUES....",arrayList.toString());
                                count++;
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"ERRORR....",Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(jsonArrayRequest);
        return arrayList;
    }
}
