package sematech.training.Drafts.mvpCity;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class MVPModel implements MVPContract.Model {
    private MVPContract.Presenter presenter;
    List<cityModel> cityList = new ArrayList<>();
    @Override
    public void attachPresenter(MVPContract.Presenter presenter) {

        this.presenter = presenter;
    }

    @Override
    public void loadData() {

        cityModel tehran = new cityModel();
        tehran.name=("Tehran");
        tehran.country=("Iran");
        tehran.currency=("Rial");
        tehran.language=("Persian");
        tehran.population=(6000000);
        tehran.imgCity=("https://www.irangazette.com/en/images/picsofTehran/AllaboutTehran/All%20about%20Tehran7.jpg");
        tehran.imgFlag=("https://www.perfectflags.com/image/cache/data/FLAG%20IMAGES%20EBAY%20500/Iran500px-500x500.png");

        cityModel toronto = new cityModel();
        toronto.name=("Toronto");
        toronto.country=("Canada");
        toronto.currency=("Dollar");
        toronto.language=("Eng");
        toronto.population=(2732000);
        toronto.imgCity=("https://localfoodtours.com/wp-content/uploads/2018/07/cn-tower-and-tourist-attractions-things-to-do-in-toronto.jpg");
        toronto.imgFlag=("https://dynamicmedia.zuza.com/zz/m/original_/9/4/94747413-5e9e-45f1-a73e-f5a42936126d/LIST_FlagfactsFeb15_Gallery.jpg");

        cityModel newyork = new cityModel();
        newyork.name=("NewYork");
        newyork.country=("U.S.A");
        newyork.currency=("Dollar");
        newyork.language=("Eng");
        newyork.population=(8623000);
        newyork.imgCity=("https://www.burgessyachts.com/media/adminforms/locations/n/e/new_york_1.jpg");
        newyork.imgFlag=("https://www.united-states-flag.com/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/f/l/flgfhis1000024675_-00_15-star-spangled-banner-3ftx5ft-printed-polyester-flag.jpg");

        cityModel dubai = new cityModel();
        dubai.name=("Dubai");
        dubai.country=("U.A.E");
        dubai.currency=("Dirham");
        dubai.language=("Arab");
        dubai.population=(2000000);
        dubai.imgCity=("https://www.albawaba.com/sites/default/files/imagecache/article_headline_node_big//sites/default/files/im/pr_new/shutterstock_385992304_dubai_infrastructure.jpg");
        dubai.imgFlag=("https://i.ebayimg.com/images/g/R48AAOxy~iJRAQ-7/s-l300.jpg");

        cityModel tokyo = new cityModel();
        tokyo.name=("Tokyo");
        tokyo.country=("Japan");
        tokyo.currency=("Yen");
        tokyo.language=("Japanese");
        tokyo.population=(9273000);
        tokyo.imgCity=("http://static.asiawebdirect.com/m/phuket/portals/japan-hotels-ws/homepage/tokyo/nightlife/pagePropertiesImage/Tokyo-Nightlife.jpg.jpg");
        tokyo.imgFlag=("http://flags.fmcdn.net/data/flags/w580/jp.png");

        cityModel sydney = new cityModel();
        sydney.name=("Sydney");
        sydney.country=("Australia");
        sydney.currency=("Dollar");
        sydney.language=("English");
        sydney.population=(4452000);
        sydney.imgCity=("http://www.yellowrabbit.it/data/immagine/20181004105821_img_86e2c.png");
        sydney.imgFlag=("http://www.all-flags-world.com/country-flag/Australia/flag-australia-XL.jpg");

        cityModel istanbul = new cityModel();
        istanbul.name=("Istanbul");
        istanbul.country=("Turkey");
        istanbul.currency=("Lir");
        istanbul.language=("Turkish");
        istanbul.population=(15030000);
        istanbul.imgCity=("https://d2bgjx2gb489de.cloudfront.net/gbb-blogs/wp-content/uploads/2018/03/06175333/Istanbul-870x400.jpg");
        istanbul.imgFlag=("https://i.ebayimg.com/images/g/7~AAAOxyhlJRcSIL/s-l300.jpg");

        cityList.add(tehran);
        cityList.add(toronto);
        cityList.add(newyork);
        cityList.add(dubai);
        cityList.add(tokyo);
        cityList.add(sydney);
        cityList.add(istanbul);

        presenter.dataLoaded(cityList);

    }

    @Override
    public void getDataFromUser(String name, String country, String currency, String language, long population, Uri flagImg, Uri cityImg) {

        cityModel model = new cityModel();
        model.setName(name);
        model.setCountry(country);
        model.setCurrency(currency);
        model.setLanguage(language);
        model.setPopulation(population);
        model.setImgFlag(flagImg.toString());
        model.setImgCity(cityImg.toString());
        cityList.add(model);

        presenter.userDataSaved();
    }


}
