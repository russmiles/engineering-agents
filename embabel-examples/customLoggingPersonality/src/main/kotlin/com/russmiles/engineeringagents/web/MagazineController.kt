package com.russmiles.engineeringagents.web

import com.embabel.agent.api.common.autonomy.Autonomy
import com.embabel.agent.core.ProcessOptions
import com.embabel.agent.core.Verbosity
import com.embabel.agent.event.logging.LoggingPersonality
import com.embabel.agent.shell.formatProcessOutput
import com.embabel.common.util.color
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.slf4j.Logger
import org.springframework.web.bind.annotation.PathVariable

//@RestController
class MagazineController (
    private val loggingPersonality: LoggingPersonality,
    private val autonomy: Autonomy,
    private val objectMapper: ObjectMapper
) {

    private val logger: Logger = loggingPersonality.logger

    @GetMapping("/")
    fun welcome(): String {
        return "Welcome."
    }

    @GetMapping("/tellmeastory/{topic}", produces = ["application/json"])
    fun tellMeAStoryOnTopic(@PathVariable topic:String): String {
        val intent = "Tell me a story about ${topic}"
        logger.info(intent)
        val verbosity = Verbosity(
            debug = false,
            showPrompts = true,
            showLlmResponses = false,
            showPlanning = true,
        )
        val output = autonomy.chooseAndRunAgent(
            intent = intent,
            processOptions = ProcessOptions(
                test = false,
                verbosity = verbosity,
            ))
        logger.info("executed \"$intent\"".color(loggingPersonality.colorPalette.color2))
        logger.info("using object mapper \"$objectMapper\"")
        return formatProcessOutput(
            output,
            loggingPersonality.colorPalette,
            objectMapper,
            80)
    }
}