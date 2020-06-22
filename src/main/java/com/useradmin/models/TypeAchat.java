package com.useradmin.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TypeAchat {

        Article("Article"),
        Service("Service");

        private String value;

        TypeAchat(String value) {
                this.value = value;
        }

        @JsonProperty
        public String getValue() {
                return value;
        }

        @JsonCreator
        public static TypeAchat fromJson(@JsonProperty("value") String value) {
                return valueOf(value);
        }
}
