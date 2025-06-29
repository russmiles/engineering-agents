package com.russmiles.engineeringagents.logging.personality.lebowski

import com.embabel.agent.core.EarlyTermination
import com.embabel.agent.event.*
import com.embabel.agent.event.logging.LoggingAgenticEventListener
import com.embabel.common.util.color
import com.embabel.common.util.hexToRgb
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service


val TransformSuccessResponses = listOf(
    "The Dude never loses!",
    "Sometimes there's a man",
    "Don’t forget to have fun.",
    "Stick to your convictions!",
    "The Dude makes the world a better place!",
    "Life is just a game, so have fun!"
)

val CompletionMessages = listOf(
    "This aggression will not stand, man.",
    "The Dude abides.",
    "Yeah, well, you know, that’s just, like, your opinion, man.",
    "Sometimes you eat the bear, and sometimes, well, he eats you.",
    "F$*k it, Dude. Let’s go bowling.",
    "Well, sir, it’s this rug I had. It really tied the room together.",
    "The Dude minds",
    "Nihilists! Say what you want about the tenets of National Socialism, Dude, at least it’s an ethos.",
    "Do you see what happens when you f$* a stranger in the a$$!",
    "You’re not wrong, Walter. You’re just an asshole.",
    "S$*t the f$*k up, Donny"
)

fun highlight(text: String) = "<$text>".color(LebowskiColorPalette.KNITWEAR)

/**
 * The AI Abides, man. This is just a Big Lebowski themed logging implementation
 */
@Service
@Profile("lebowski")
class LebowskiLoggingAgenticEventListener : LoggingAgenticEventListener (
    url = "https://en.wikipedia.org/wiki/The_Big_Lebowski",
    logger = LoggerFactory.getLogger("Lebowski"),
    welcomeMessage = """

The AI Abides...

@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#  :@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%=+*@@@@@@@@@@@@@@@@@@.     @@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@@@@%+=#- - *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@%=. :-%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@%: =%@@@@%+-:-=+*%@@@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@%= .%@@@%=.     :=++#@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@
@@@@@@@**@@@@@@@@@+. #@@@.        :-=++%@@@@@@@@@%@@@@@@@%%%@@@@@@@@@@@@@%%@@
@@@@@@    @@@@%%%*-  @@@-           .=++#@@@@@@@@%%@@@@@%%%%@@@@@@@@@@@#:%%%%
@@@@@@@@@@@@@@@%#= .:%@@:           :-=++#@@@@@@@@@@@@@@%#%@@@@@@@        %%%
@@@@@@@@@@@@@@%%#::.*%@@:          -+#%%%@@@@@@@@@@@@@@%##%%@@@@@@%-+@@@##%%#
@@@@@@@@@@@@@%##==-*-%@@.      :-:+#@@@@@@%*#@@@@@@@@@%#####%@@@@@%       ##%
@@@@@@@@@@@@@@%*-=--#@@@.   :***+  +%*++=--=*%@@@@@%#%%#%@%*-######     .***+
%%%%%%%#  #@%%====+#%*@%.  **@@#+   +*-. .-+*#%@@@@@@@@@@%%@@%#**************
%%%#####%##*:  :#%##@@@@-:+#*+=.     +++--++###%@@@@@@@@@@@@@@%*#%%#####*****
    :#*        :*#@@@@@@+::      :  :+@@*+++##%%@@@@@@@@@@@@@@%*******#******
#%@@@%%%%##%#== =#@@@@@@@:      .++%%@@@%***#%#%@@@@@@@@@@@@@%#*+*+*****+++**
###%%%######*- .:#%@@@@@@#.....:== .+#%%@@@@@%@%@@@@@@@@@@@@@@:  . ...:-++++*
*###########*.::-##+%@@@@@=--=--=-.+%@@@@%%#%@@@@@@%@#%@@@@+          .--:-++
******%@@@%##=- :##-*#@@@@%------+#@@*--+*#*#@@@@@@@@@@@@%.       :         =
+*****@@@@%**==***%%=#@@@@@@*++=-*#+:-=*#%###@@@@@#*@@@@=             .- *#-=
@@@%*#@@@@@##*:+++*##*%@@@@@@@#+++**+=+++*#@@@@@@@%%@#-=              %*%=-.=
@@@@@@@@@@@@#*=-:-=**#%@@@@@@@@@#+*%##+*%@@@@@@@@@@@%==            : @@*==++*
@@@@@@@@@@@@@%+:-:-=-##@@@@@@@@@@@##*%%%@@@@@@@@@@@%#--          + %@@#=:::=%
@@@@@@@@@@@@@@#     :++#@@@@@@@@@@@#:+%@@@@@@@@@@@@%#+.          @@@@*  +#%%#
@@@@@@@@@@@@@@@@*+*#-= #%-@@@@@@@@@@**+@@@@@@@@@@%%#++-   . @@#  ++@%:#%##*##
@@@@@@@@@@@@@@@@%%=.  -#=@@@@@@%@@@@@@@@@@@@@@@%%*::-@  .@@   @ %:@@%%#*+*+#*
@@@@@@@@@@@@@@@%%@=..-#%@@@@@@@@@@#+@@@%%%@@@@+.. ..@% *@-+   @@@@@@@*+#*#   
@@@@@@@@@@@@@@@%%%#  =#@@@@@@@@@@@*++@#@@#####     %@+ -= :@*    @%@%#%*     
@@@@@@@@@@@@@@@@      *#@@@@@@@@@@*-*@*@@@#***     @@++    @    ::%@%#:      
@@@@@@@@@@@@#-           %@@@@@@@@+--*+#%#+**+   -@@@@@ +@       **@@        
@@@@@@@@@ +@@   :   . - ++*@@@@@@%-++%+%+#-++*   @@@@%@@@=      - *@-       =
@%:  =:  #= %    =  : .  .@%%@#*+:. .**+ %-+++   @@@@: @@       .-#@#        
     :  +@#@+    =* =   =: -%@@@   -+++=.%==++  @@@%%=         =@%@@@   =*  =
       . @%%@-+ +--.@=:  :=** @@    :%== #+++   @@*#:@+       ##%%@@@  .  =@ 
  +   @%  +@@@:-  @@.@:%@#+=+   : .==%:  :*+:   *#+# -:    +#%+##%@@@=    @% 
         -#@@@=+@@@@%@@%@@@@%   #@  =@.   #=    %+#:      .###+###@@@@.    @ 
    ...      @@+@%+@@%@@@@@@   : @  #@  : -      :*:       ##%*#%*:.=#%%   @.
 ...        %%%--@@@@%@@@@@@  .:.   +@  .:       +=-       **#*    ..*%=@    
.      +@%              .#@@ .:.:   -@            .*:    .%-       . ++@  +% 
    =@@:                 -*%%: :   +@@             .:     %       . ++### @@ 
  :@@@+                :   +#@+    @@#              ..              :::+@@   



    """.trimIndent().color(hexToRgb(LebowskiColorPalette.KNITWEAR)),
) {

    override fun getAgentDeploymentEventMessage(e: AgentDeploymentEvent): String =
        "${highlight("New s&%t has come to light")}: " +
                "Agent ${e.agent.name} has been deployed to Venice bungalow at 606 Venezia Avenue, Venice, CA\n\tdescription: ${e.agent.description}"

    override fun getRankingChoiceRequestEventMessage(e: RankingChoiceRequestEvent<*>): String =
        guide("Lot of moving parts for ${e.type.simpleName} based on ${e.basis}")

    override fun getRankingChoiceMadeEventMessage(e: RankingChoiceMadeEvent<*>): String =
        guide(
            """
        Maud recommends ${e.type.simpleName} '${e.choice.match.name}' with confidence ${e.choice.score} based on ${e.basis}.
        All options: ${e.rankings.infoString()}
        Remember to see a good doctor. That's thorough.
        """.trimIndent()
        )

    override fun getRankingChoiceNotMadeEventMessage(e: RankingChoiceCouldNotBeMadeEvent<*>): String =
        "${highlight("Calmer than you")}: Failed to choose ${e.type.simpleName} based on ${e.basis}. Choices: ${e.rankings.infoString()}. Confidence cutoff: ${e.confidenceCutOff}"

    override fun getDynamicAgentCreationMessage(e: DynamicAgentCreationEvent): String =
        "${highlight("New s&%t has come to light")}: Created agent ${e.agent.infoString()}"

    override fun getAgentProcessCreationEventMessage(e: AgentProcessCreationEvent): String =
        guide(
            """
        The Agent Abides.
            [${e.processId}] process created
        """.trimIndent()
        )

    override fun getAgentProcessReadyToPlanEventMessage(e: AgentProcessReadyToPlanEvent): String =
        "[${e.processId}] ${highlight("Lotta moving parts")} ready to translate from ${e.worldState.infoString(verbose = e.agentProcess.processContext.processOptions.verbosity.showLongPlans)}"

    override fun getAgentProcessPlanFormulatedEventMessage(e: AgentProcessPlanFormulatedEvent): String =
        "[${e.processId}] ${highlight("That's, like, your opinion, man")}: formulated plan ${e.plan.infoString(verbose = e.agentProcess.processContext.processOptions.verbosity.showLongPlans)} from ${e.worldState.infoString()}".color(
            LebowskiColorPalette.TOWEL_YELLOW
        )

    override fun getProcessCompletionMessage(e: AgentProcessFinishedEvent): String =
        """
        [${e.processId}] completed in ${e.agentProcess.runningTime}
        ${CompletionMessages.random()}

        ${"That rug really tied the room together.".color(LebowskiColorPalette.KNITWEAR)}
        """.trimIndent()

    override fun getProcessFailureMessage(e: AgentProcessFinishedEvent): String =
        "[${e.processId}] ${highlight("Do you have to use so many cuss words?")}: process failed catastrophically"

    override fun getEarlyTerminationMessage(e: EarlyTermination): String =
        """
        [${e.processId}] early termination by ${e.policy} for ${e.reason}
        The Dude abides. I don't know about you but I take comfort in that.
        """.trimIndent()

    override fun getObjectAddedEventMessage(e: ObjectAddedEvent): String =
        "[${e.processId}] Object added to the moving parts: ${if (e.agentProcess.processContext.processOptions.verbosity.debug) e.value else e.value::class.java.simpleName}"

    override fun getObjectBoundEventMessage(e: ObjectBoundEvent): String =
        "[${e.processId}] Object bound to the moving parts: ${e.name}:${if (e.agentProcess.processContext.processOptions.verbosity.debug) e.value else e.value::class.java.simpleName}"

    override fun getToolCallRequestEventMessage(e: ToolCallRequestEvent): String =
        "[${e.processId}] ${highlight("Lotta moving parts")}: (${e.action?.shortName()}) calling tool ${e.tool}(${e.toolInput})"

    override fun getToolCallSuccessResponseEventMessage(e: ToolCallResponseEvent, resultToShow: String): String =
        "[${e.processId}] ${highlight("New s&%t has come to light")}: (${e.action?.shortName()}) tool ${e.tool} returned $resultToShow in ${e.runningTime.toMillis()}ms with payload ${e.toolInput}"

    override fun getToolCallFailureResponseEventMessage(e: ToolCallResponseEvent, throwable: Throwable?): String =
        "[${e.processId}] ${highlight("Do you have to use so many cuss words?")}: (${e.action?.shortName()}) tool ${e.tool} failed $throwable in ${e.runningTime.toMillis()}ms with payload ${e.toolInput}"

    override fun getLlmRequestEventMessage(e: LlmRequestEvent<*>): String =
        "[${e.processId}] 🧠 Lotta moving parts: calculating LLM ${e.llm.name} to transform ${e.interaction.id.value} from ${e.outputClass.simpleName} -> ${e.interaction.llm} using ${e.interaction.toolCallbacks.joinToString { it.toolDefinition.name() }}"

    override fun getLlmResponseEventMessage(e: LlmResponseEvent<*>): String =
        """
        [${e.processId}] received LLM response ${e.interaction.id.value} of type ${e.response?.let { it::class.java.simpleName } ?: "null"} from ${e.interaction.llm.criteria} in ${e.runningTime.seconds} seconds
        ${TransformSuccessResponses.random()}
        """.trimIndent()

    override fun getActionExecutionStartMessage(e: ActionExecutionStartEvent): String =
        "[${e.processId}] ${highlight("New s&%t has come to light")}: executing action ${e.action.name}"

    override fun getActionExecutionResultMessage(e: ActionExecutionResultEvent): String =
        "[${e.processId}] ${highlight("New s&%t has come to light")}: completed action ${e.action.name} in ${e.actionStatus.runningTime}"

    override fun getProgressUpdateEventMessage(e: ProgressUpdateEvent): String =
        "[${e.processId}] Progress: ${e.createProgressBar(length = 50).color(LebowskiColorPalette.TOWEL_YELLOW)}"
}