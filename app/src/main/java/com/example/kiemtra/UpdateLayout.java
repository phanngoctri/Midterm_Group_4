package com.example.kiemtra;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.ProductInsertModel;
import com.example.lib.Model.ProductInsertModelResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateLayout extends AppCompatActivity {
    EditText txtNameInsert,txtPrice,txtDescription,txtImage;
    String Id, GroupName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_layout);
        txtNameInsert = findViewById(R.id.txtNameInsert);
        txtPrice =findViewById(R.id.txtPrice);
        txtDescription =findViewById(R.id.txtDescription);
        txtImage =findViewById(R.id.txtImage);
        // lay du lieu
        txtNameInsert.setText(getIntent().getStringExtra("ProductName"));
        txtPrice.setText(getIntent().getStringExtra("ProductPrice"));
        txtDescription.setText(getIntent().getStringExtra("ProductDescription"));
        txtImage.setText(getIntent().getStringExtra("ProductPicture"));

        Id = getIntent().getStringExtra("Id");
        GroupName = getIntent().getStringExtra("GroupName");
        //
    }

    public void Save(View view){
        ProductInsertModel productInsertModel = new ProductInsertModel();
        productInsertModel.setName(txtNameInsert.getText().toString());
        productInsertModel.setPrice(txtPrice.getText().toString());
        productInsertModel.setDescription(txtDescription.getText().toString());
        productInsertModel.setPicture(txtImage.getText().toString());

        productInsertModel.setId(Id);
        productInsertModel.setGroupName(GroupName);

        Methods methods = getRetrofit().create(Methods.class);
        Call<ProductInsertModelResult> call = methods.insertProduct(productInsertModel);
        call.enqueue(new Callback<ProductInsertModelResult>() {
            @Override
            public void onResponse(Call<ProductInsertModelResult> call, Response<ProductInsertModelResult> response) {
                String status = response.body().getStatus();
                if (status == "true"){
                    UpdateLayout.this.finish();
                }else{
                    Toast.makeText(UpdateLayout.this, "Khong the sua san pham", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductInsertModelResult> call, Throwable t) {
            }
        });
    }

    public void Cancel(View view){
        UpdateLayout.this.finish();
    }
}