package com.russmiles.engineeringagents

import com.embabel.agent.config.annotation.EnableAgentShell
import com.embabel.agent.config.annotation.EnableAgents
import com.embabel.agent.config.annotation.LocalModels
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAgentShell
@EnableAgents(loggingTheme = "lebowski",
    localModels = [LocalModels.OLLAMA, LocalModels.DOCKER])
class CustomLoggingPersonality

fun main(args: Array<String>) {
    runApplication<CustomLoggingPersonality>(*args)
}
