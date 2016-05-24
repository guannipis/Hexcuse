package com.example.viewdemo.common.base;

/**
 * Created by Hexcuse on 2016/5/19.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(视图层的基类接口).
 */
public interface BaseView<T> {

	void setPresenter(T presenter);

}
