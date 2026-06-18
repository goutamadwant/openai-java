// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseFunctionCallArgumentsDoneEventTest {

    @Test
    fun create() {
        val responseFunctionCallArgumentsDoneEvent =
            ResponseFunctionCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .itemId("item_id")
                .name("name")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseFunctionCallArgumentsDoneEvent.arguments()).isEqualTo("arguments")
        assertThat(responseFunctionCallArgumentsDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseFunctionCallArgumentsDoneEvent.name()).contains("name")
        assertThat(responseFunctionCallArgumentsDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseFunctionCallArgumentsDoneEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseFunctionCallArgumentsDoneEvent =
            ResponseFunctionCallArgumentsDoneEvent.builder()
                .arguments("arguments")
                .itemId("item_id")
                .name("name")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseFunctionCallArgumentsDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseFunctionCallArgumentsDoneEvent),
                jacksonTypeRef<ResponseFunctionCallArgumentsDoneEvent>(),
            )

        assertThat(roundtrippedResponseFunctionCallArgumentsDoneEvent)
            .isEqualTo(responseFunctionCallArgumentsDoneEvent)
    }

    @Test
    fun validateWhenNameMissing() {
        val responseFunctionCallArgumentsDoneEvent =
            jsonMapper()
                .readValue(
                    """
                    {
                      "type": "response.function_call_arguments.done",
                      "arguments": "{}",
                      "item_id": "fc_071179986c0b4d5f016977cf066b3481939993c816cc22819c",
                      "output_index": 0,
                      "sequence_number": 4
                    }
                    """
                        .trimIndent(),
                    jacksonTypeRef<ResponseFunctionCallArgumentsDoneEvent>(),
                )

        responseFunctionCallArgumentsDoneEvent.validate()

        assertThat(responseFunctionCallArgumentsDoneEvent.arguments()).isEqualTo("{}")
        assertThat(responseFunctionCallArgumentsDoneEvent.itemId())
            .isEqualTo("fc_071179986c0b4d5f016977cf066b3481939993c816cc22819c")
        assertThat(responseFunctionCallArgumentsDoneEvent.name()).isEmpty()
        assertThat(responseFunctionCallArgumentsDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseFunctionCallArgumentsDoneEvent.sequenceNumber()).isEqualTo(4L)
    }
}
