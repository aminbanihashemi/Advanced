package sematech.training.CarsMVP;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import sematech.training.R;
import sematech.training.utils.BaseActivity;

public class CarsActivity extends BaseActivity implements CarContract.View,CarsAdapter.SelectCar {
    RecyclerView carsList;
    CarPresenter presenter = new CarPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
        carsList = findViewById(R.id.carsList);
        presenter.attachView(this);




    }

    @Override
    public void onCarsLoaded(List<CarEntity> cars) {
        CarsAdapter adapter = new CarsAdapter(mContext,cars);
        carsList.setAdapter(adapter);
        adapter.setSelectCar(this);
    }

    @Override
    public void onCarSelect(CarEntity car) {
        Toast.makeText(mContext, car.getName(), Toast.LENGTH_SHORT).show();
    }
}
