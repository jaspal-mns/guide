package com.soul

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/guide")
class GuideController {

    @Get(uri="/", produces=["text/plain"])
    fun index(): String {
        System.out.println("Hello World")
        return "Example Response"
    }
}