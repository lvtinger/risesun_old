package org.risesun.data.mysql.meta.bean;

import lombok.Getter;
import lombok.Setter;
import org.risesun.data.mysql.enums.PrimaryKeyGenerateMode;

@Getter
@Setter
public class PrimaryKey {
    private Property property;
    private PrimaryKeyGenerateMode mode;
}