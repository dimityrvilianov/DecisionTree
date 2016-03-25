package com.csc.interfaces;

public interface IVisitable<T> {

	void accept(ITreeVisitor<T> visitor);

}
