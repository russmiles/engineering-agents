package com.russmiles.engineeringagents

import com.embabel.agent.config.annotation.EnableAgentShell
import com.embabel.agent.config.annotation.EnableAgents
import com.embabel.agent.config.annotation.LocalModels
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAgentShell
@ConfigurationPropertiesScan
@EnableAgents(loggingTheme = "lebowski",
    localModels = [LocalModels.OLLAMA])
class CustomLoggingPersonality

fun main(args: Array<String>) {
    runApplication<CustomLoggingPersonality>(*args)
}
