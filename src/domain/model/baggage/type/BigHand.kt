package domain.model.baggage.type

class BigHand : BaggageType() {
    override val emoji: String = super.emoji + super.emoji
    override val title: String = "BigHandBaggage"
}
