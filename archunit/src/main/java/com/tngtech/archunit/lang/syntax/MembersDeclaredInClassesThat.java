/*
 * Copyright 2014-2026 TNG Technology Consulting GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tngtech.archunit.lang.syntax;

import java.util.function.Function;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaMember;
import com.tngtech.archunit.lang.syntax.elements.GivenMembersConjunction;


class MembersDeclaredInClassesThat<MEMBER extends JavaMember, CONJUNCTION extends GivenMembersConjunction<MEMBER>>
        extends AbstractClassesThat<CONJUNCTION> {
    private final Function<DescribedPredicate<? super JavaClass>, CONJUNCTION> predicateAggregator;

    MembersDeclaredInClassesThat(Function<DescribedPredicate<? super JavaClass>, CONJUNCTION> predicateAggregator) {
        this.predicateAggregator = predicateAggregator;
    }

    @Override
    protected CONJUNCTION givenWith(DescribedPredicate<? super JavaClass> predicate) {
        return predicateAggregator.apply(predicate);
    }
}
