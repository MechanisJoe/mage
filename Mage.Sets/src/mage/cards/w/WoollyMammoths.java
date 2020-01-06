
package mage.cards.w;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.condition.common.PermanentsOnTheBattlefieldCondition;
import mage.abilities.decorator.ConditionalContinuousEffect;
import mage.abilities.effects.common.continuous.GainAbilitySourceEffect;
import mage.abilities.keyword.TrampleAbility;
import mage.constants.SubType;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Duration;
import mage.constants.SuperType;
import mage.constants.TargetController;
import mage.constants.Zone;
import mage.filter.FilterPermanent;
import mage.filter.predicate.mageobject.SupertypePredicate;
import mage.filter.predicate.permanent.ControllerPredicate;

/**
 *
 * @author TheElk801
 */
public final class WoollyMammoths extends CardImpl {

    private static final FilterPermanent filter = new FilterPermanent("snow land");

    static {
        filter.add(new SupertypePredicate(SuperType.SNOW));
        filter.add(CardType.LAND.getPredicate());
        filter.add(new ControllerPredicate(TargetController.YOU));
    }

    public WoollyMammoths(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{G}{G}");

        this.subtype.add(SubType.ELEPHANT);
        this.power = new MageInt(3);
        this.toughness = new MageInt(2);

        // Woolly Mammoths has trample as long as you control a snow land.
        this.addAbility(new SimpleStaticAbility(
                Zone.BATTLEFIELD,
                new ConditionalContinuousEffect(
                        new GainAbilitySourceEffect(
                                TrampleAbility.getInstance(),
                                Duration.WhileOnBattlefield
                        ),
                        new PermanentsOnTheBattlefieldCondition(filter),
                        "{this} has trample as long as you control a snow land"
                )
        ));
    }

    public WoollyMammoths(final WoollyMammoths card) {
        super(card);
    }

    @Override
    public WoollyMammoths copy() {
        return new WoollyMammoths(this);
    }
}
