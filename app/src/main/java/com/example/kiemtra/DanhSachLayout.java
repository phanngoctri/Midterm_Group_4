package com.example.kiemtra;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kiemtra.Adapter.ProductAdapter;
import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.ProductModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DanhSachLayout extends AppCompatActivity {
    ListView lvAdvance;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_layout);
        lvAdvance = findViewById(R.id.lvAdvance);
        productAdapter = new ProductAdapter(DanhSachLayout.this, R.layout.productlayout);
    }

    public void GetProduct(){
        Bundle bundle = new Bundle();
        Methods methods = getRetrofit().create(Methods.class);
        Call<ProductModel> call = methods.getProduct();
        call.enqueue(new Callback<ProductModel>() {
            @Override
            public void onResponse(Call<ProductModel> call, Response<ProductModel> response) {
                List<ProductModel.Data> data = response.body().getData();

                for(ProductModel.Data dt : data){
                    productAdapter.add(dt);
                }
                productAdapter.notifyDataSetChanged();
                lvAdvance.setAdapter(productAdapter);
                lvAdvance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ProductModel.Data item = (ProductModel.Data) parent.getItemAtPosition(position);
                        Intent i = new Intent(DanhSachLayout.this, UpdateLayout.class);
                        i.putExtra("Id",item.getId().toString());
                        i.putExtra("ProductName",item.getName().toString());
                        i.putExtra("ProductPrice",item.getPrice().toString());
                        i.putExtra("ProductDescription",item.getDescription().toString());
                        i.putExtra("ProductPicture",item.getPicture().toString());
                        i.putExtra("GroupName",item.getGroupName().toString());
                        startActivity(i);
                    }
                });
            }
            @Override
            public void onFailure(Call<ProductModel> call, Throwable t) {
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(DanhSachLayout.this, "Loading data", Toast.LENGTH_SHORT).show();
        productAdapter.clear();
        lvAdvance.setAdapter(null);
        GetProduct();
    }

    public void ThemMoiLayout(View view) {
        Intent intent =  new Intent(DanhSachLayout.this, InsertLayout.class);
        startActivity(intent);
    }
}