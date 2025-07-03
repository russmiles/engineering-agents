package com.russmiles.engineeringagents.logging.personality.lebowski

import com.embabel.agent.event.logging.personality.ColorPalette
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("lebowski")
object LebowskiColorPalette : ColorPalette {
    const val KNITWEAR: Int = 0xD2B48C

    override val highlight: Int
        get() = KNITWEAR
    override val color2: Int
        get() = KNITWEAR
}