package br.com.quintoandar.dbz.converter;

public interface Converter<E, D> {

    D convert(E entity);

}
