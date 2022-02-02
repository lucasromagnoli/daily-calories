package br.com.lucasromagnoli.dailycalories.domain.usecase;

import org.springframework.stereotype.Service;

public interface UseCase<T> {
    T handle(T t);
}
