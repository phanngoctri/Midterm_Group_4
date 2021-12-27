package com.example.lib.InterfaceRepository;

import com.example.lib.Model.ProductInsertModel;
import com.example.lib.Model.ProductInsertModelResult;
import com.example.lib.Model.ProductModel;



import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;


public interface Methods {
    @GET("api/Product/get-product?groupName=18DTHA5_Nhom4")
    Call<ProductModel> getProduct();
    @POST("api/Product/post-product")
    Call<ProductInsertModelResult> insertProduct(@Body ProductInsertModel productInsertModel);
}
