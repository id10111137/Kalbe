package com.tatang.pcit1.kalbe.Library.Interface;

import com.tatang.pcit1.kalbe.Library.Model.M_Brand;
import com.tatang.pcit1.kalbe.Library.Model.M_Costumer;
import com.tatang.pcit1.kalbe.Library.Model.M_Interface;
import com.tatang.pcit1.kalbe.Library.Model.M_Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Interface_Kalbe {

    String AddKalbe(M_Interface m_interface) throws SQLException;

    ArrayList<M_Brand> getMBrand() throws SQLException;

    ArrayList<M_Product> getMProduct() throws SQLException;

    ArrayList<M_Costumer> getMCostumer() throws SQLException;

    ArrayList<M_Interface> getMpembelian() throws SQLException;

}
