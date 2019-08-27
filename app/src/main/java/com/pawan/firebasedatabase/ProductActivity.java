package com.pawan.firebasedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pawan.firebasedatabase.adapters.ProductListAdapter;
import com.pawan.firebasedatabase.models.Items;
import com.pawan.firebasedatabase.models.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductListAdapter productListAdapter;
    private List<Items> productList;
    private DatabaseReference databaseRefrence;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        productList = new ArrayList<>();
        databaseRefrence = FirebaseDatabase.getInstance().getReference();
        recyclerView = (RecyclerView) findViewById(R.id.rv_activity_product_list);
        productListAdapter = new ProductListAdapter(productList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(productListAdapter);

    }


    public void onInsertClick(View view) {
        for (int i = 0; i < 14; i++) {
            Items item = new Items();
            switch (i) {
                case 0:
                    item.setProductId("12345");
                    item.setInStock(true);
                    break;
                case 1:
                    item.setProductId("11939");
                    item.setInStock(true);
                    break;
                case 2:
                    item.setProductId("20516");
                    item.setInStock(true);
                    break;
                case 3:
                    item.setProductId("11036");
                    item.setInStock(true);
                    break;
                case 4:
                    item.setProductId("18001");
                    item.setInStock(true);
                    break;
                case 5:
                    item.setProductId("40002");
                    item.setInStock(true);
                    break;
                case 6:
                    item.setProductId("38010");
                    item.setInStock(true);
                    break;
                case 7:
                    item.setProductId("100001");
                    item.setInStock(false);
                    break;
                case 8:
                    item.setProductId("92502");
                    item.setInStock(true);
                    break;
                case 9:
                    item.setProductId("113501");
                    item.setInStock(true);
                    break;
                case 10:
                    item.setProductId("43506");
                    item.setInStock(false);
                    break;
                case 11:
                    item.setProductId("101002");
                    item.setInStock(true);
                    break;
                case 12:
                    item.setProductId("101003");
                    item.setInStock(true);
                    break;
                case 13:
                    item.setProductId("132501");
                    item.setInStock(true);
                    break;
                case 14:
                    item.setProductId("132503");
                    item.setInStock(true);
                    break;

            }
            String userId = databaseRefrence.push().getKey();
            item.setFirebaseKey(userId);
            databaseRefrence.child("items").child(userId).setValue(item);

        }

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Items items = dataSnapshot.getValue(Items.class);
                    productList.add(items);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Pawan", "error " + databaseError.toException());
            }
        };
        databaseRefrence.addValueEventListener(valueEventListener);
        productListAdapter.notifyDataSetChanged();


    }


    public void onUpdateClicked(View view) {

    }

    public void onDelClicked(View view) {

    }
}
