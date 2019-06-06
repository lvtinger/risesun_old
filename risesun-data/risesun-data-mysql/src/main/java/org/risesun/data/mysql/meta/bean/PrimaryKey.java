package org.risesun.data.mysql.meta.bean;

import lombok.Getter;
import lombok.Setter;
import org.risesun.data.mysql.support.DefaultValueGenerator;

@Getter
@Setter
public class PrimaryKey {
    private Property property;
    private DefaultValueGenerator generator;
}