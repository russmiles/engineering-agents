package com.russmiles.engineeringagents

import com.embabel.agent.config.annotation.EnableAgentShell
import com.embabel.agent.config.annotation.EnableAgents
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAgentShell
@EnableAgents(loggingTheme = "lebowski")
class CustomLoggingPersonality

fun main(args: Array<String>) {
    runApplication<CustomLoggingPersonality>(*args)
}
