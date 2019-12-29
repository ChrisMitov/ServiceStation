package com.christian.model.enums;

public enum Roles {
  User, Employee, Admin;

  @Override public String toString() {
    return this.name();
  }
}
