/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.asset.coins;

import bisq.asset.Coin;
import bisq.asset.RegexAddressValidator;
import bisq.asset.AddressValidationResult;
import bisq.asset.Base58BitcoinAddressValidator;

public class ZeroOneCoin extends Coin {

    public ZeroOneCoin() {
        super("01coin", "ZOC", new ZeroOneCoinAddressValidator());
    }

    public static class ZeroOneCoinAddressValidator extends Base58BitcoinAddressValidator {

        @Override
        public AddressValidationResult validate(String address) {

            if (address.matches("^[Z][0-9a-zA-Z]{33}$"))
                return AddressValidationResult.validAddress();

            if (address.matches("^[5][0-9a-zA-Z]{33}$"))
                return AddressValidationResult.validAddress();

            return AddressValidationResult.invalidStructure();
        }
    }

}
