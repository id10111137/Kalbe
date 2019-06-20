package com.tatang.pcit1.kalbe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.tatang.pcit1.kalbe.Adapter.Adapter_Kalbe;
import com.tatang.pcit1.kalbe.Library.Hellper.Hellper_Kalbe;
import com.tatang.pcit1.kalbe.Library.Model.M_Interface;

import java.sql.SQLException;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    Intent mIntent;
    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView, id_icon_toolbar_start;

    Adapter_Kalbe adapter_kalbe;
    ListView LvKalbe;
    Hellper_Kalbe hellper_kalbe;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);
        editText = findViewById(R.id.IdPencarian);
        mTitle.setText("Kalbe");


        toolbar_iconView = toolbar.findViewById(R.id.id_icon_toolbar);
        toolbar_iconView.setImageDrawable(getApplication().getResources().getDrawable(R.drawable.ic_add));
        toolbar_iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIntent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(mIntent);
            }
        });

        try {
            ArrayList<M_Interface> mInterfaces = hellper_kalbe.getMpembelian();
            adapter_kalbe = new Adapter_Kalbe(mInterfaces, getApplicationContext());
            adapter_kalbe.notifyDataSetChanged();
            LvKalbe.setAdapter(adapter_kalbe);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                adapter_kalbe.filter(s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter_kalbe.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
