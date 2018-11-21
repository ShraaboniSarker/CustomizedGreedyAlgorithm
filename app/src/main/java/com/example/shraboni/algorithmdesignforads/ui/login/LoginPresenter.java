package com.example.shraboni.algorithmdesignforads.ui.login;

import com.example.shraboni.algorithmdesignforads.model.login.LoginResponse;
import com.example.shraboni.algorithmdesignforads.network.APIService;
import com.example.shraboni.algorithmdesignforads.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements ILoginPresenter {

    private ILoginView view;

    public APIService apiService;

    public LoginPresenter(ILoginView view) {
        this.view = view;
    }



    @Override
    public void doLogin(String email,String password) {
        apiService = RetrofitClientInstance.getRetrofitInstance().create(APIService.class);

        Call<LoginResponse> call = apiService.doLogin(email,password);
        call.enqueue(new Callback<LoginResponse>(){
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    view.onSuccess("successfully login");

                }else{
                    view.onFailed("Sorry! there is some issues!");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                view.onFailed("Sorry! there is some issues!");
            }
        });
    }

}
