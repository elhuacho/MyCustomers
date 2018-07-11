package pe.edu.upc.mycustomers.viewcontrollers.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.mycustomers.R;
import pe.edu.upc.mycustomers.models.Customer;
import pe.edu.upc.mycustomers.viewcontrollers.adapters.CustomersAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView customersRecyclerView;
    LinearLayoutManager customersLayoutManager;
    CustomersAdapter customersAdapter;
    List<Customer> customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        customersRecyclerView = (RecyclerView) findViewById(R.id.customersRecyclerView);
        Resources resources = getApplicationContext().getResources();
        customers = new ArrayList<>();
        customers.add(new Customer(resources.getString(R.string.name_service_bbva),
                resources.getString(R.string.contact_bbva),
                resources.getString(R.string.address_bbva),
                R.drawable.bbva));
        customers.add(new Customer(resources.getString(R.string.name_service_banco_comercio),
                resources.getString(R.string.contact_banco_comercio),
                resources.getString(R.string.address_banco_comercio),
                R.drawable.bancocomercio));
        customers.add(new Customer(resources.getString(R.string.name_service_banco_falabella),
                resources.getString(R.string.contact_banco_falabella),
                resources.getString(R.string.address_banco_falabella),
                R.drawable.bancofalabella));
        customers.add(new Customer(resources.getString(R.string.name_service_banco_ripley),
                resources.getString(R.string.contact_banco_ripley),
                resources.getString(R.string.address_banco_ripley),
                R.drawable.bancoripley));
        customers.add(new Customer(resources.getString(R.string.name_service_interbank),
                resources.getString(R.string.contact_interbank),
                resources.getString(R.string.address_interbank),
                R.drawable.interbank));
        customersAdapter = new CustomersAdapter(customers);
        customersLayoutManager = new LinearLayoutManager(this);
        customersRecyclerView.setAdapter(customersAdapter);
        customersRecyclerView.setLayoutManager(customersLayoutManager);
    }

}
