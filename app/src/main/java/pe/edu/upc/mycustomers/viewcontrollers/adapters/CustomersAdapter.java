package pe.edu.upc.mycustomers.viewcontrollers.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.mycustomers.R;
import pe.edu.upc.mycustomers.models.Customer;
import pe.edu.upc.mycustomers.viewcontrollers.activities.CustomerActivity;

public class CustomersAdapter extends RecyclerView.Adapter<CustomersAdapter.ViewHolder> {

    private List<Customer> customers;

    public CustomersAdapter(List<Customer> customers) {
        this.customers = customers;
    }

    @NonNull
    @Override
    public CustomersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.item_customer, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomersAdapter.ViewHolder holder, int position) {
        Customer customer = customers.get(position);
        holder.updateViewFrom(customer);
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public CustomersAdapter setCustomers(List<Customer> customers) {
        this.customers = customers;
        return this;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView pictureImageView;
        private TextView nameServiceTextView;
        private CardView customerCardView;
        private Customer customer;

        public ViewHolder(View view) {
            super(view);
            pictureImageView = (ImageView) view.findViewById(R.id.pictureImageView);
            nameServiceTextView = (TextView) view.findViewById(R.id.nameServiceTextView);
            customerCardView = (CardView) view.findViewById(R.id.customerCardView);
        }

        public void updateViewFrom(final Customer customer) {
            pictureImageView.setImageResource(customer.getPictureId());
            nameServiceTextView.setText(customer.getName());
            this.customer = customer;
            customerCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent =  new Intent(context, CustomerActivity.class);
                    intent.putExtras(customer.toBundle());
                    context.startActivity(intent);
                }
            });
        }
    }
}
