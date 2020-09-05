package com.example.daggervmc.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daggervmc.R;
import com.example.daggervmc.root.App;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import twit.Game;
import twit.Twit;
import twit.TwitApi;

public class MainActivityView extends AppCompatActivity implements LoginActivityMVP.View {
    private EditText Nonbre, Appellido;
    private Button ButtonM;
    @Inject
    TwitApi twitApi;
    @Inject
    LoginActivityMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);

        setUpView();
        Call<Twit> call = twitApi.getTopGames("c8cbsehp35e8kkyi8lgownpi9p6tv5");
        call.enqueue(new Callback<Twit>() {
            @Override
            public void onResponse(Call<Twit> call, Response<Twit> response) {

                if (response.isSuccessful()) {
                    List<Game> topGames = response.body().getGame();
                    for (Game game : topGames) {
                        System.out.println(game);
                        Log.d("retro", "list" + game);
                    }
                } else {
                    Toast.makeText(MainActivityView.this, "error" + response.code(), Toast.LENGTH_LONG).show();
                    Log.d("tag", "error" + response.code());

                }
            }

            @Override
            public void onFailure(Call<Twit> call, Throwable t) {

                Toast.makeText(MainActivityView.this, "errore nella carica " + t.getMessage() + t.getCause(), Toast.LENGTH_LONG).show();
                Log.d("tag", "error" + t.getMessage() + t.getCause());
                t.printStackTrace();

            }
        });
    }

    private void setUpView() {
        ButtonM = findViewById(R.id.buttonM);
        Nonbre = findViewById(R.id.editTextTextPersonName);
        Appellido = findViewById(R.id.editTextTextPersonApellido);
        ButtonM.setOnClickListener((View view) -> {
            Toast.makeText(this, "btn pulsado", Toast.LENGTH_SHORT).show();
            presenter.LoginButtonClicked();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getLastNAme() {
        return this.Appellido.getText().toString();
    }

    @Override
    public String getFirstName() {
        return this.Nonbre.getText().toString();
    }

    @Override
    public void showUserNotAvalible() {
        Toast.makeText(this, " usuario no disponoble", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showUserInputError() {

        Toast.makeText(this, " error en la escritura ", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void showUSerSaved() {
        Toast.makeText(this, "usuario guardado correctamente", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirtsname(String firtsname) {
        this.Nonbre.setText(firtsname);
    }

    @Override
    public void setLastName(String lastName) {
        this.Appellido.setText(lastName);
    }


}