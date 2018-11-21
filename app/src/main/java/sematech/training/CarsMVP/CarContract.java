package sematech.training.CarsMVP;

import java.util.List;

public interface CarContract {
    interface View{
        void onCarsLoaded (List<CarEntity> cars);

    }
    interface Presenter{
        void attachView(View view);
        void onCarsLoaded (List<CarEntity> cars);
        void onCarSelected(CarEntity car);
    }
    interface  Model {
        void attachPresenter(Presenter presenter);
        void loadCars();
    }
}
