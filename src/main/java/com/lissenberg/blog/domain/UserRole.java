package com.lissenberg.blog.domain;

import javax.persistence.Embeddable;

@Embeddable
public enum UserRole {

	READER, WRITER, ADMIN

}
