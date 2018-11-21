package sematech.training.CarsMVP;

import java.util.ArrayList;
import java.util.List;

public class CarModel implements CarContract.Model {
    private CarContract.Presenter presenter;

    @Override
    public void attachPresenter(CarContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @Override
    public void loadCars() {
        List<CarEntity> cars = new ArrayList<>();

        CarEntity pride = new CarEntity();
        pride.setName("131");
        pride.setCompany("Saipa");
        pride.setPrice(40000);
        pride.setImg("http://img8.irna.ir/1397/13970108/82873421/n82873421-72262776.jpg");

        CarEntity peugeot = new CarEntity();
        peugeot.setName("206");
        peugeot.setCompany("IranKhodro");
        peugeot.setPrice(60000);
        peugeot.setImg("https://sepandkhodro.com/wp-content/uploads/2017/11/jpxcsnwam5.jpg");

        cars.add(pride);
        cars.add(peugeot);

        presenter.onCarsLoaded(cars);

    }
}
