
package mage.cards.c;

import java.util.UUID;
import mage.abilities.effects.common.LookLibraryAndPickControllerEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.ComparisonType;
import mage.constants.Zone;
import mage.filter.FilterCard;
import mage.filter.predicate.mageobject.ConvertedManaCostPredicate;

/**
 *
 * @author jeffwadsworth
 */
public final class CollectedCompany extends CardImpl {

    private static final FilterCard filter = new FilterCard("up to two creature cards with converted mana cost 3 or less");

    static {
        filter.add(CardType.CREATURE.getPredicate());
        filter.add(new ConvertedManaCostPredicate(ComparisonType.FEWER_THAN, 4));
    }

    public CollectedCompany(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.INSTANT},"{3}{G}");

        // Look at the top six cards of your library. Put up to two creature cards with converted mana cost 3 or less from among them onto the battlefield.
        // Put the rest on the bottom of your library in any order.
        this.getSpellAbility().addEffect(new LookLibraryAndPickControllerEffect(6, 2, filter, false, true, Zone.BATTLEFIELD, false));

    }

    public CollectedCompany(final CollectedCompany card) {
        super(card);
    }

    @Override
    public CollectedCompany copy() {
        return new CollectedCompany(this);
    }
}
