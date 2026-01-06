/* --------------------------------------------------------------------
 *  Inugami
 * --------------------------------------------------------------------
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.my.project.api.domain.user.exception;

import io.inugami.framework.interfaces.exceptions.DefaultWarning;
import io.inugami.framework.interfaces.exceptions.Warning;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * @since 2026-01-06
 */
public enum UserWarning implements Warning {
    READ_PARTIAL_INFO(DefaultWarning.builder()
                                    .warningCode("WARN-USER-2_0")
                                    .category("providers")
                                    .message("some providers can't retrieve user's information")
                                    .domain(UserWarning.Constants.USER)
    );

    public static final Collection<UserWarning> VALUES = Collections.unmodifiableCollection(Arrays.asList(values()));
    private final       Warning                 warning;

    private UserWarning(final DefaultWarning.DefaultWarningBuilder builder) {
        warning = builder.build();
    }


    @Override
    public Warning getCurrentWaring() {
        return warning;
    }

    private static class Constants {
        public static final String USER = "USER";
    }
}

