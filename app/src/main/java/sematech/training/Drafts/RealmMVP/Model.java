package sematech.training.Drafts.RealmMVP;

import io.realm.Realm;
import sematech.training.utils.BaseActivity;

public class Model implements Contract.Model {
    Contract.Presenter presenter ;
    @Override
    public void attachPresenter(Contract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void loadlist() {

    }

    @Override
    public void register(String name, String family, String mobile, String age) {
        StudentEntity std = new StudentEntity(name,family,mobile ,Integer.parseInt(age));
        Realm realm=Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyFromRealm(std);
        realm.commitTransaction();
        presenter.userRegister();
    }
}
