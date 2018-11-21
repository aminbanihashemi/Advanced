package sematech.training.Drafts.mvpCity;

import android.net.Uri;

import java.util.List;

public class MVPPresenter implements MVPContract.Presenter {
    MVPContract.Model model = new MVPModel();
    private MVPContract.View view;

    @Override
    public void attachView(MVPContract.View view) {
        model.attachPresenter(this);
        this.view = view;
    }

    @Override
    public void loadData() {
        model.loadData();
    }

    @Override
    public void getDataFromUser(String name, String country, String currency, String language, long population, Uri flagImg, Uri cityImg) {
        model.getDataFromUser(name, country, currency, language, population, flagImg, cityImg);
    }


    @Override
    public void dataLoaded(List<cityModel> cities) {
        view.dataLoaded(cities);
    }

    @Override
    public void userDataSaved() {
        view.userDataSaved();
    }
}
