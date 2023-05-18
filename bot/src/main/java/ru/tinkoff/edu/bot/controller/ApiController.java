package ru.tinkoff.edu.bot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.tinkoff.edu.bot.dto.ApiErrorResponse;
import ru.tinkoff.edu.bot.dto.LinkUpdate;

@Validated
@Tag(name = "updates", description = "the updates API")
public interface ApiController {

    /**
     * POST /updates : Отправить обновление
     *
     * @param linkUpdate  (required)
     * @return Обновление обработано (status code 200)
     *         or Некорректные параметры запроса (status code 400)
     */
    @Operation(
            operationId = "updatesPost",
            summary = "Отправить обновление",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Обновление обработано"),
                    @ApiResponse(responseCode = "400", description = "Некорректные параметры запроса", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/updates",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    ResponseEntity<Void> updatesPost(
            @Parameter(name = "LinkUpdate", description = "", required = true) @Valid @RequestBody LinkUpdate linkUpdate
    );

}
