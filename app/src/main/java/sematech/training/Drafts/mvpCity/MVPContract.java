package sematech.training.Drafts.mvpCity;

import android.net.Uri;

import java.util.List;

public interface MVPContract {

    interface View {
        void dataLoaded(List<cityModel> cities);
        void userDataSaved();
    }

    interface Presenter {
        void attachView(View view);
        void loadData();
        void getDataFromUser(String name, String country, String currency , String language, long population, Uri flagImg, Uri cityImg);
        void dataLoaded(List<cityModel> cities);
        void userDataSaved();
    }

    interface Model {
        void attachPresenter(Presenter presenter);
        void loadData();
        void getDataFromUser(String name,String country,String currency ,String language,long population,Uri flagImg,Uri cityImg);
    }
}
