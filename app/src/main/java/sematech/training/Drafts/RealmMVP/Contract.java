package sematech.training.Drafts.RealmMVP;

import java.util.List;

public interface Contract {

    interface View {
        void onUserLoaded(List<StudentEntity> students);
        void userRegister();
    }

    interface Presenter {
        void attachView(View view);
        void register (String name,String family,String mobile,String age);
        void onUserLoaded(List<StudentEntity> students);
        void userRegister();
    }

    interface Model {
        void attachPresenter(Presenter presenter);
        void loadlist();
        void register (String name,String family,String mobile,String age);
    }
}
