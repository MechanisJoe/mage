
package mage.cards.b;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.SacrificeSourceCost;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.GenericManaCost;
import mage.abilities.effects.common.search.SearchLibraryPutInPlayEffect;
import mage.abilities.mana.ColorlessManaAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.*;
import mage.filter.FilterCard;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.mageobject.SubtypePredicate;
import mage.filter.predicate.mageobject.SupertypePredicate;
import mage.target.common.TargetCardInLibrary;

/**
 * @author North
 */
public final class BantPanorama extends CardImpl {

    private static final FilterCard filter = new FilterCard("a basic Forest, Plains, or Island card");

    static {
        filter.add(CardType.LAND.getPredicate());
        filter.add(new SupertypePredicate(SuperType.BASIC));
        filter.add(Predicates.or(
                new SubtypePredicate(SubType.FOREST),
                new SubtypePredicate(SubType.PLAINS),
                new SubtypePredicate(SubType.ISLAND)));
    }

    public BantPanorama(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.LAND}, "");

        // {T}: Add {C}.
        this.addAbility(new ColorlessManaAbility());

        // {1}, {T}, Sacrifice Bant Panorama: Search your library for a basic Forest, Plains, or Island card and put it onto the battlefield tapped. Then shuffle your library.
        TargetCardInLibrary target = new TargetCardInLibrary(filter);
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new SearchLibraryPutInPlayEffect(target, true, Outcome.PutLandInPlay), new GenericManaCost(1));
        ability.addCost(new TapSourceCost());
        ability.addCost(new SacrificeSourceCost());
        this.addAbility(ability);
    }

    public BantPanorama(final BantPanorama card) {
        super(card);
    }

    @Override
    public BantPanorama copy() {
        return new BantPanorama(this);
    }
}
