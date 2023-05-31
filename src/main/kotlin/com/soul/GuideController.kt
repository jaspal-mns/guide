package com.soul

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus

@Controller("/guide")
class GuideController {

    @Get(uri="/", produces=["text/plain"])
    fun index(): String {
        return "Example Response"
    }
}