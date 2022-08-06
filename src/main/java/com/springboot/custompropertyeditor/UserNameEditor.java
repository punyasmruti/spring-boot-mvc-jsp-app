package com.springboot.custompropertyeditor;

import java.beans.PropertyEditorSupport;

public class UserNameEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String name) throws IllegalArgumentException {

		if (name.contains("Mr.") || name.contains("Mrs.")) {
			setValue(name);
		} else {
			name = "Mr." + name;
			setValue(name);
		}
	}
}
