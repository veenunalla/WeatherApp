package com.lowe.core.scopes;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * Fragment scope.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Scope
public @interface FragmentScope {
}
