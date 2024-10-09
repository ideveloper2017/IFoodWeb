package uz.ifood.app.api.v1.web.response

import org.springframework.http.HttpStatus

class ResponseMessage(var status: HttpStatus?, var message: String?,data: List<Any>?)
