package sematech.training.Drafts.mvpA;

public interface MVPContract {
    interface View {
        void onAgeRecevied(int age);

    }

    interface Presenter {
        void onAgeRecevied(int age);
        void attachView(View view);
        void onGetAge(String name);

    }

    interface Model {
        void attachPressenter(Presenter presenter);
        void onGetAge(String name);
    }
}
