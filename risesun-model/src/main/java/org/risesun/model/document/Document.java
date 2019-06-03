package org.risesun.model.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.risesun.model.annotation.Identity;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public abstract class Document<ID extends Serializable> implements Serializable {
    @Identity
    public ID id;
}