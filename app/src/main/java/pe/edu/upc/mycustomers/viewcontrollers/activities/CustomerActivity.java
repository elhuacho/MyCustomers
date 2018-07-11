package pe.edu.upc.mycustomers.viewcontrollers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.upc.mycustomers.R;
import pe.edu.upc.mycustomers.models.Customer;

public class CustomerActivity extends AppCompatActivity {

    ViewHolder holder;
    Button mapButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        holder = new ViewHolder(findViewById(android.R.id.content));
        Intent intent = getIntent();
        if (intent == null) return;
        Customer customer = Customer.Builder.from(intent.getExtras()).build();
        holder.updateViewFrom(customer);

        mapButton = (Button) findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(mapIntent);
            }
        });
    }

    private class ViewHolder {
        private ImageView pictureImageView;
        private TextView nameServiceTextView;
        private TextView contactTextView;
        private TextView addressTextView;

        public ViewHolder(View view){
            pictureImageView = (ImageView) findViewById(R.id.pictureImageView);
            nameServiceTextView = (TextView) findViewById(R.id.nameServiceTextView);
            contactTextView = (TextView) findViewById(R.id.contactTextView);
            addressTextView = (TextView) findViewById(R.id.addressTextView);
        }

        public void updateViewFrom(Customer customer) {
            pictureImageView.setImageResource(customer.getPictureId());
            nameServiceTextView.setText(customer.getName());
            contactTextView.setText(customer.getContact());
            addressTextView.setText(customer.getAddress());
        }

    }

}
