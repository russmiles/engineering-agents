package com.russmiles.engineeringagents.agent

import com.embabel.agent.domain.io.UserInput
import com.embabel.agent.testing.unit.FakeOperationContext
import com.embabel.agent.testing.unit.LlmInvocation
import com.embabel.agent.testing.unit.UnitTestUtils.captureLlmCall
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.Instant

/**
 * Unit tests for the WriteAndReviewAgent class.
 * Tests the agent's ability to craft and review stories based on user input.
 */
internal class WriteAndReviewAgentTest {

    /**
     * Tests the story crafting functionality of the WriteAndReviewAgent.
     * Verifies that the LLM call contains expected content and configuration.
     */
    @Test
    fun testCraftStory() {
        // Create agent with word limits: 200 min, 400 max
        val agent = WriteAndReviewAgent(200, 400)

        // Capture the LLM call made during story crafting
        val llmCall = captureLlmCall(Runnable {
            agent.craftStory(UserInput("Tell me a story about a brave knight", Instant.now()))
        })

        // Verify the prompt contains the expected keyword
        Assertions.assertTrue(
            llmCall.prompt.contains("knight"),
            "Expected prompt to contain 'knight'"
        )


        // Verify the temperature setting for creative output
        Assertions.assertEquals(
            0.9, llmCall.llm!!.temperature, 0.01,
            "Expected temperature to be 0.9: Higher for more creative output"
        )
    }

    /**
     * Tests the story review functionality of the WriteAndReviewAgent.
     * Verifies that the review process includes expected prompt content.
     */
    @Test
    fun testReview() {
        // Create agent with word limits
        val agent = WriteAndReviewAgent(200, 400)

        // Set up test data
        val userInput = UserInput("Tell me a story about a brave knight", Instant.now())
        val story = Story("Once upon a time, Sir Galahad...")

        // Create fake context and set expected response
        val context = FakeOperationContext.create()
        context.expectResponse("A thrilling tale of bravery and adventure!")

        // Execute the review
        agent.reviewStory(userInput, story, context)

        // Verify the LLM invocation contains expected content
        val llmInvocation: LlmInvocation =
            context.llmInvocations.singleOrNull()
                ?: error("Expected a single LLM invocation, not ${context.llmInvocations.single()}")
        Assertions.assertTrue(
            llmInvocation.prompt.contains("knight"),
            "Expected prompt to contain 'knight'"
        )
        Assertions.assertTrue(
            llmInvocation.prompt.contains("review"),
            "Expected prompt to contain 'review'"
        )
    }
}