package com.example.repository.converters;

public interface Converter<I, O> {
    O convert(I input);
}
