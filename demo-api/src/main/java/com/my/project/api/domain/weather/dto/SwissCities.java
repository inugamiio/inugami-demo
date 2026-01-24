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
package com.my.project.api.domain.weather.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SwissCities {
    UNDEFINED(-1, -1),
    VERSOIX(46.2831, 6.1673),
    GENEVE(46.2044, 6.1432),
    LAUSANNE(46.5197, 6.6323);

    private static final Collection<SwissCities> VALUES = Collections.unmodifiableCollection(Arrays.asList(values()));
    private final        double                  latitude;
    private final        double                  longitude;

    public static SwissCities fromCode(final String name) {
        return VALUES.stream()
                     .filter(city -> city.name().equalsIgnoreCase(name))
                     .findFirst()
                     .orElse(UNDEFINED);
    }
}
