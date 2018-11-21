package sematech.training.CarsMVP;

import java.util.List;

public class CarPresenter implements CarContract.Presenter {
    private CarContract.View view;
    CarModel model = new CarModel();

    @Override
    public void attachView(CarContract.View view) {

        this.view = view;
        model.attachPresenter(this);
        model.loadCars();
    }

    @Override
    public void onCarsLoaded(List<CarEntity> cars) {
        view.onCarsLoaded(cars);
    }

    @Override
    public void onCarSelected(CarEntity car) {

    }
}
