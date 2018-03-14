package alruiz.es.recipepuppy.ui.base;

/**
 * BasePresenter.
 *
 * @author AlfonsoRuiz
 */
public abstract class BasePresenter<T extends BaseView> {

    private T view;

    public BasePresenter(T view) {
        this.view = view;
    }

    protected T getView() {
        return this.view;
    }

}
