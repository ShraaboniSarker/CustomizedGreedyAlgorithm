package com.example.shraboni.algorithmdesignforads.ui.createUser;

import com.example.shraboni.algorithmdesignforads.model.createUser.CreateUserResponse;
import com.example.shraboni.algorithmdesignforads.network.APIService;
import com.example.shraboni.algorithmdesignforads.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserPresenter implements ICreateUserPresenter{

    private ICreateUserView iCreateUserView;
    public APIService apiService;

    public CreateUserPresenter(ICreateUserView iCreateUserView) {
        this.iCreateUserView = iCreateUserView;
    }

    @Override
    public void registerUser(String name, String email, String password, String dob) {
        apiService = RetrofitClientInstance.getRetrofitInstance().create(APIService.class);
        Call<CreateUserResponse> call = apiService.createUser(name,email,password,dob);
        call.enqueue(new Callback<CreateUserResponse>() {
            @Override
            public void onResponse(Call<CreateUserResponse> call, Response<CreateUserResponse> response) {
              if(response.isSuccessful()){
                  iCreateUserView.onSuccess("Successfully created user");
              } else {
                  iCreateUserView.onSuccess("Some error happens! try again!");
              }
            }

            @Override
            public void onFailure(Call<CreateUserResponse> call, Throwable t) {
                iCreateUserView.onSuccess("Some error happens! try again!");
            }
        });

    }
}
