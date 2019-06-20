package com.tatang.pcit1.kalbe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tatang.pcit1.kalbe.Library.Hellper.Hellper_Date;
import com.tatang.pcit1.kalbe.Library.Hellper.Hellper_Kalbe;
import com.tatang.pcit1.kalbe.Library.Model.M_Brand;
import com.tatang.pcit1.kalbe.Library.Model.M_Costumer;
import com.tatang.pcit1.kalbe.Library.Model.M_Interface;
import com.tatang.pcit1.kalbe.Library.Model.M_Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView mTitle;
    CircleImageView toolbar_iconView, id_icon_toolbar_start;
    Button BtnSimpan;

    Spinner IdSpCostumerName, IdSpProductName;

    Hellper_Kalbe hellper_kalbe;
    Hellper_Date hellper_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_add);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        mTitle = toolbar.findViewById(R.id.id_title_toolbar);

        IdSpCostumerName = findViewById(R.id.IdSpCostumerName);
        IdSpProductName = findViewById(R.id.IdSpProductName);
        BtnSimpan = findViewById(R.id.BtnSimpan);
        mTitle.setText("Add Data");

        try {
            getDataToSpinner();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        id_icon_toolbar_start = toolbar.findViewById(R.id.id_icon_toolbar_start);
        id_icon_toolbar_start.setImageDrawable(getApplication().getResources().getDrawable(R.drawable.ic_back));
        id_icon_toolbar_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        BtnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    M_Interface m_interface = new M_Interface();
                    m_interface.setIntCustomerID(String.valueOf(IdSpCostumerName.getSelectedItem()));
                    m_interface.setIntProductID(String.valueOf(IdSpProductName.getSelectedItem()));
                    m_interface.setDtSalesOrder(String.valueOf(IdSpCostumerName.getSelectedItem()));
                    m_interface.setIntQty(""+hellper_date.getDate());
                    String Exec = hellper_kalbe.AddKalbe(m_interface);

                    if (Exec.equals("sukses")) {
                        Toast.makeText(AddActivity.this, "Sukses Simpan Data", Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    } else {
                        Toast.makeText(AddActivity.this, "Gagal Simpan Data", Toast.LENGTH_SHORT).show();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void getDataToSpinner() throws SQLException {

        List<M_Costumer> m_costumers = hellper_kalbe.getMCostumer();
        ArrayAdapter<M_Costumer> adapter =
                new ArrayAdapter<M_Costumer>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, m_costumers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        IdSpCostumerName.setAdapter(adapter);


        List<M_Product> m_products = hellper_kalbe.getMProduct();
        ArrayAdapter<M_Product> adapterProduct =
                new ArrayAdapter<M_Product>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, m_products);
        adapterProduct.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        IdSpProductName.setAdapter(adapterProduct);

    }

}
