package com.talkevents.cassandra.models;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("phone")
public record Phone(String number, String type) {

}
