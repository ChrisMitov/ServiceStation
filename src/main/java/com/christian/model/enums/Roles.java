package com.christian.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {
  User, Employee, Admin;

  @Override public String toString() {
    return this.name();
  }

  @Override public String getAuthority() {
    return this.name();
  }
}
