package sematech.training.Drafts.RealmMVP;

import java.util.List;

public class Presenter implements Contract.Presenter {
    Contract.View view;
    Contract.Model model = new Model();

    @Override
    public void attachView(Contract.View view) {

        this.view = view;
        model.attachPresenter(this);
    }

    @Override
    public void register(String name, String family, String mobile, String age) {
        model.register(name,family,mobile,age);
    }

    @Override
    public void onUserLoaded(List<StudentEntity> students) {

    }

    @Override
    public void userRegister() {
        view.userRegister();
    }
}
