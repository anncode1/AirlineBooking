package domain.model.baggage.type

data class Hand(
    override val emoji: String,
    override val quantity: Int,
    override val title: String,
    override val description: String
) : BaggageType(emoji, quantity, title, description)
