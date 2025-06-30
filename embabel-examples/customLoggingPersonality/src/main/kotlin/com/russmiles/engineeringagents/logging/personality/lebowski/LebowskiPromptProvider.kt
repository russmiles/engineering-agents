package com.russmiles.engineeringagents.logging.personality.lebowski

import com.embabel.agent.shell.MessageGeneratorPromptProvider
import com.embabel.common.util.RandomFromFileMessageGenerator
import com.embabel.common.util.bold
import com.embabel.common.util.color
import com.embabel.common.util.italic
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

fun guide(text: String) = "${" Scene ".bold()} ${text.italic().color(LebowskiColorPalette.TOWEL_YELLOW)}"

val SceneLocations = listOf(
    "The Dude’s Apartment",
    "Hollywood Star Lanes bowling alley",
    "Lebowski’s Mansion",
    "Sobchak Security",
    "Wooden bridge",
    "Maude’s Loft",
    "Crane Jackson’s Fountain Street Theater",
    "Jackie Treehorn’s Beach Party",
    "Jackie Treehorn’s Mansion",
    "Donny’s ashes scattering spot",)

@Component
@Profile("lebowski")
class LebowskiPromptProvider : MessageGeneratorPromptProvider(
    color = LebowskiColorPalette.TOWEL_YELLOW,
    prompt = SceneLocations.random(),
    messageGenerator = RandomFromFileMessageGenerator(
        url = "logging/lebowski.txt"
    ),
)