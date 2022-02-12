package br.com.lucasromagnoli.dailycalories.domain.usecase;

public interface UseCase<T> {
    default T handle(T t) {
        throw new UnsupportedOperationException();
    };

    default T handle() {
        throw new UnsupportedOperationException();
    }
}
