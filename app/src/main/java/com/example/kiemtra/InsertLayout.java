package com.example.kiemtra;

import static com.example.lib.RetrofitClient.getRetrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lib.InterfaceRepository.Methods;
import com.example.lib.Model.ProductInsertModel;
import com.example.lib.Model.ProductInsertModelResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertLayout extends AppCompatActivity {
    EditText txtNameInsert,txtPrice,txtDescription,txtImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_layout);
        txtNameInsert = findViewById(R.id.txtNameInsert);
        txtPrice =findViewById(R.id.txtPrice);
        txtDescription =findViewById(R.id.txtDescription);
        txtImage =findViewById(R.id.txtImage);
    }

    public void Save(View view){
        ProductInsertModel productInsertModel = new ProductInsertModel();
        productInsertModel.setName(txtNameInsert.getText().toString());
        productInsertModel.setPrice(txtPrice.getText().toString());
        productInsertModel.setDescription(txtDescription.getText().toString());
        productInsertModel.setPicture(txtImage.getText().toString());

        productInsertModel.setId("00000000-0000-0000-0000-000000000000");
        productInsertModel.setGroupName("18DTHA5_Nhom4");

        Methods methods = getRetrofit().create(Methods.class);
        Call<ProductInsertModelResult> call = methods.insertProduct(productInsertModel);
        call.enqueue(new Callback<ProductInsertModelResult>() {
            @Override
            public void onResponse(Call<ProductInsertModelResult> call, Response<ProductInsertModelResult> response) {
                String status = response.body().getStatus();
                if (status == "true"){
                    InsertLayout.this.finish();
                }else{
                    Toast.makeText(InsertLayout.this, "Không thể thêm sản phẩm", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductInsertModelResult> call, Throwable t) {
            }
        });
    }

    public void Cancel(View view){
        InsertLayout.this.finish();
    }
}