package com.ryadita.www.informasi_tagihan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TampilNama extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextId;
    private EditText editTextName;
    private EditText editTextVendor;
    private EditText editTextTanggal;
    private EditText editTextTotal;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_nama);

        Intent intent = getIntent();

        id = intent.getStringExtra(MainActivity.EMP_ID);

        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextVendor = (EditText) findViewById(R.id.editTextVendor);
        editTextTanggal = (EditText) findViewById(R.id.editTextTanggal);
        editTextTotal = (EditText) findViewById(R.id.editTextTotal);

        editTextId.setText(id);

        getNama();
    }

    private void getNama() {
        class GetNama extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected String doInBackground(Void... voids) {
                return null;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showNama(s);
            }

        }
        GetNama ge = new GetNama();
        ge.execute();
    }

    private void showNama(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(MainActivity.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);


            String id = c.getString(MainActivity.TAG_ID);
            String nama = c.getString(MainActivity.TAG_NAMA);
            String vendor = c.getString(MainActivity.TAG_VENDOR);
            String tanggal = c.getString(MainActivity.TAG_TANGGAL);
            String total = c.getString(MainActivity.TAG_TOTAL);

            editTextId.setText(id);
            editTextName.setText(nama);
            editTextVendor.setText(vendor);
            editTextTanggal.setText(tanggal);
            editTextTotal.setText(total);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {

    }
}